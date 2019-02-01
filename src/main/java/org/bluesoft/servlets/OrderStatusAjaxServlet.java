package org.bluesoft.servlets;

import org.bluesoft.data.MenuDao;
import org.bluesoft.data.MenuDaoFactory;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/updateStatus")
public class OrderStatusAjaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        MenuDao dao = MenuDaoFactory.getMenuDao();
        String status = dao.getOrder(id).getStatus();

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        JSONObject json = new JSONObject();

        json.put("status",status);

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");

        json.put("time",sdf.format(new Date()));
        out.write(json.toString());
        out.close();
    }
}
