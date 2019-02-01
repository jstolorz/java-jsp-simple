package org.bluesoft.domain;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private long id;
    private Map<MenuItem, Integer> currentOrder = new HashMap<>();
    private String status;
    private String customer;

    public void addToOrder(MenuItem menuItem, int quantity){
        int currentQuantity = 0;

        if(currentOrder.get(menuItem) != null){
            currentQuantity = currentOrder.get(menuItem);
        }

        currentQuantity += quantity;

        currentOrder.put(menuItem, currentQuantity);
    }

    public Double getOrderTotal(){
        double d = 0d;

        for (MenuItem menuItem : currentOrder.keySet()){
            d += currentOrder.get(menuItem) * menuItem.getPrice();
        }

        return d;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Map<MenuItem, Integer> getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Map<MenuItem, Integer> currentOrder) {
        this.currentOrder = currentOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setContents(Map<MenuItem,Integer> contents){
        this.currentOrder = contents;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", currentOrder=" + currentOrder +
                ", status='" + status + '\'' +
                ", customer='" + customer + '\'' +
                '}';
    }
}
