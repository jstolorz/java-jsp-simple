package org.bluesoft.servlets;

import org.bluesoft.data.MenuDao;
import org.bluesoft.data.MenuDaoFactory;
import org.bluesoft.domain.Order;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/kitchenAsyncServlet", asyncSupported = true)
public class KitchenAsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AsyncContext asyncContext = req.startAsync(req,resp);

        KitchenAsyncTask task = new KitchenAsyncTask();
        task.setAsyncContext(asyncContext);

         asyncContext.start(task);

    }
}
