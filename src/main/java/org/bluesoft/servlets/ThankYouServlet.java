package org.bluesoft.servlets;

import org.bluesoft.data.MenuDao;
import org.bluesoft.data.MenuDaoFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/thankYou.html")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"user"}))
public class ThankYouServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Long orderId = (Long)session.getAttribute("orderId");

        MenuDao dao = MenuDaoFactory.getMenuDao();

        Double total = dao.getOrderTotal(orderId);

        if(total == null){
            resp.sendRedirect("/order.html");
            return;
        }

        String status = dao.getOrder(orderId).getStatus();

        req.setAttribute("total",total);
        req.setAttribute("status",status);
        req.setAttribute("currency","USD");
        req.setAttribute("id",orderId);

        ServletContext ctx = getServletContext();
        RequestDispatcher dispatcher = ctx.getRequestDispatcher("/thanks.jsp");
        dispatcher.forward(req,resp);

    }
}
