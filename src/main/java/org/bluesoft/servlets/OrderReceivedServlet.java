package org.bluesoft.servlets;

import org.bluesoft.data.MenuDao;
import org.bluesoft.data.MenuDaoFactory;
import org.bluesoft.data.MenuDataService;
import org.bluesoft.domain.Order;
import org.bluesoft.websockets.KitchenDisplaySessionHandler;
import org.bluesoft.websockets.KitchenDisplaySessionHandlerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/orderReceived.html")
public class OrderReceivedServlet extends HttpServlet {


	public void service (HttpServletRequest request, HttpServletResponse response) throws IOException {

		MenuDao dao = MenuDaoFactory.getMenuDao();

	    int maxId = dao.getFullMenu().size();
	    Order order = dao.newOrder(request.getUserPrincipal().getName());

	    for(int i = 0; i < maxId; i++){
	    	String quantity = request.getParameter("item_" + i);
	    	try{

	    		int q =Integer.parseInt(quantity);

	    		if(q > 0){
	    			dao.addToOrder(order.getId(), dao.getItem(i), q);
	    			order.addToOrder(dao.getItem(i),q);
				}

			}catch (NumberFormatException nfe){

			}
		}


		KitchenDisplaySessionHandler handler = KitchenDisplaySessionHandlerFactory.getHandler();
	    handler.newOrder(order);


		HttpSession session = request.getSession();
		session.setAttribute("orderId",order.getId());

		String redirectUrl = "/thankYou.html";
		redirectUrl = response.encodeURL(redirectUrl);

		response.sendRedirect(redirectUrl);
	}
}
