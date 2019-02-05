package org.bluesoft.websockets;

import org.bluesoft.data.MenuDao;
import org.bluesoft.data.MenuDaoFactory;
import org.bluesoft.domain.Order;
import org.json.JSONObject;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/kitchenManagement")
public class KitchenDisplayWebsocket {

    private KitchenDisplaySessionHandler handler = KitchenDisplaySessionHandlerFactory.getHandler();

    @OnOpen
    public void open(Session session){

        handler.addSession(session);
    }

    @OnClose
    public void close(Session session){
        handler.removeSession(session);
    }

    public void error(Throwable error){
        throw new RuntimeException(error);
    }

    @OnMessage
    public void message(String message, Session session){
        JSONObject json = new JSONObject(message);
        Long id = json.getLong("id");
        String status = json.getString("status");

        MenuDao dao = MenuDaoFactory.getMenuDao();
        dao.updateOrderStatus(id,status);

        Order order = dao.getOrder(id);
        KitchenDisplaySessionHandler handler = KitchenDisplaySessionHandlerFactory.getHandler();
        handler.amendOrder(order);
    }
}
