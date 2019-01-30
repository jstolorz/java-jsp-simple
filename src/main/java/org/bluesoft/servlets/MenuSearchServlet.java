package org.bluesoft.servlets;

import org.bluesoft.data.MenuDao;
import org.bluesoft.data.MenuDaoFactory;
import org.bluesoft.data.MenuDataService;
import org.bluesoft.domain.MenuItem;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchResults.html")
public class MenuSearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String searchTerm = req.getParameter("searchTerm");
        MenuDao dao = MenuDaoFactory.getMenuDao();
        List<MenuItem> menuItems = dao.find(searchTerm);

        req.setAttribute("menuItems",menuItems);

        ServletContext ctx = getServletContext();
        RequestDispatcher dispatcher = ctx.getRequestDispatcher("/searchResults.jsp");
        dispatcher.forward(req,resp);
    }

}
