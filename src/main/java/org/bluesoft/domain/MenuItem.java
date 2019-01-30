package org.bluesoft.domain;

public class MenuItem {

    private int id;
    private String name;
    private String description;
    private MenuCategory menuCategory;
    private double price;

    public MenuItem() {
    }

    public MenuItem(int id, String name, String description, MenuCategory menuCategory, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.menuCategory = menuCategory;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

    public void setMenuCategory(MenuCategory menuCategory) {
        this.menuCategory = menuCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
