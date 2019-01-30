package org.bluesoft.servlets;

import org.bluesoft.data.MenuDao;
import org.bluesoft.data.MenuDaoFactory;
import org.bluesoft.domain.MenuItem;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/order.html")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"user"}))
public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MenuDao dao = MenuDaoFactory.getMenuDao();

        List<MenuItem> menuItems = dao.getFullMenu();

        req.setAttribute("menuItems",menuItems);

        ServletContext ctx = getServletContext();
        RequestDispatcher dispatcher = ctx.getRequestDispatcher("/orderResults.jsp");
        dispatcher.forward(req,resp);

    }
}
