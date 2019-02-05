package org.bluesoft.websockets;

import org.bluesoft.data.MenuDao;
import org.bluesoft.data.MenuDaoFactory;
import org.bluesoft.domain.Order;
import org.json.JSONObject;

import javax.websocket.Session;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KitchenDisplaySessionHandler {

    private List<Session> sessions = new ArrayList<>();

    public void addSession(Session session){
        sessions.add(session);
        sendAllOrders(session);
    }

    public void removeSession(Session session){
        sessions.remove(session);
    }

    private void sendMessage(JSONObject message) {
        for(Session session: sessions){
            try {
                session.getBasicRemote().sendText(message.toString());
            } catch (IOException e) {
                removeSession(session);
            }
        }
    }

    private void sendMessage(JSONObject message, Session session) {

        try {
                session.getBasicRemote().sendText(message.toString());
            } catch (IOException e) {
                removeSession(session);
            }
    }


    public void newOrder(Order order){
        JSONObject json = getJsonOrderObject(order);
        sendMessage(json);
    }

    private JSONObject getJsonOrderObject(Order order) {
        JSONObject json = new JSONObject();
        json.append("id",order.getId().toString());
        json.append("status",order.getStatus());
        json.append("content",order.toString());
        json.append("action","add");
        json.append("update", new Date().toString());
        return json;
    }

    public void amendOrder(Order order) {
        JSONObject json = new JSONObject();
        json.append("id",order.getId().toString());
        json.append("action","remove");
        sendMessage(json);
        if(!order.getStatus().equals("ready for collection"))
        newOrder(order);
    }

    private void sendAllOrders(Session session){
        MenuDao dao = MenuDaoFactory.getMenuDao();
        List<Order> orders = dao.getAllOrders();
        for (Order order: orders) {
            if(!order.getStatus().equals("ready for collection"))
            sendMessage(getJsonOrderObject(order), session);
        }
    }

}
