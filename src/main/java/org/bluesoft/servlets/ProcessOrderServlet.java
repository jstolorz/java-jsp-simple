package org.bluesoft.servlets;

import org.bluesoft.data.MenuDao;
import org.bluesoft.data.MenuDaoFactory;
import org.bluesoft.domain.Order;
import org.bluesoft.websockets.KitchenDisplaySessionHandler;
import org.bluesoft.websockets.KitchenDisplaySessionHandlerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/processorder.html")
public class ProcessOrderServlet extends HttpServlet {

    private MenuDao dao = MenuDaoFactory.getMenuDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<Order> orders;
        orders = dao.getAllOrders();
        req.setAttribute("orders",orders);

        List<String> statuses = new ArrayList<>();
        statuses.add("order accepted");
        statuses.add("payment received");
        statuses.add("being prepared");
        statuses.add("ready for collection");

        req.setAttribute("statuses", statuses);

        ServletContext ctx = getServletContext();
        RequestDispatcher dispatcher = ctx.getRequestDispatcher("/processorder.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        String status = req.getParameter("status");
        System.out.println(id + " " + status);
        dao.updateOrderStatus(id,status);

        Order order = dao.getOrder(id);
        KitchenDisplaySessionHandler handler = KitchenDisplaySessionHandlerFactory.getHandler();
        handler.amendOrder(order);

        doGet(req,resp);
    }
}
