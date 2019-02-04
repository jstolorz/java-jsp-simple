package org.bluesoft.servlets;

import org.bluesoft.data.MenuDao;
import org.bluesoft.data.MenuDaoFactory;
import org.bluesoft.domain.Order;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class KitchenAsyncTask implements Runnable{

    private AsyncContext asyncContext;

    public void setAsyncContext(AsyncContext asyncContext) {
        this.asyncContext = asyncContext;
    }

    @Override
    public void run() {

        HttpServletRequest req = (HttpServletRequest)asyncContext.getRequest();
        HttpServletResponse resp = (HttpServletResponse)asyncContext.getResponse();

        PrintWriter out = null;
        try {
            out = resp.getWriter();
        } catch (IOException e) {
            asyncContext.complete();
            throw new RuntimeException(e);
        }
        resp.setContentType("text/html");
        Long size = Long.parseLong(req.getParameter("size"));

        MenuDao dao = MenuDaoFactory.getMenuDao();

        while (dao.getAllOrders().size() < size){
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                asyncContext.complete();
                throw new RuntimeException(e);
            }
        }

        Order order = dao.getOrder(size);

        out.println("<p><strong>Next order:</strong><br>" + order.toString() + "</p>");
        out.close();

        asyncContext.complete();
    }
}
