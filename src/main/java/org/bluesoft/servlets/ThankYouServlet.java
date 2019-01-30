package org.bluesoft.servlets;

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
        Double total = (Double) session.getAttribute("total");

        if(total == null){
            resp.sendRedirect("/order.html");
            return;
        }

        req.setAttribute("total",total);
        req.setAttribute("currency","USD");

        ServletContext ctx = getServletContext();
        RequestDispatcher dispatcher = ctx.getRequestDispatcher("/thanks.jsp");
        dispatcher.forward(req,resp);

    }
}
