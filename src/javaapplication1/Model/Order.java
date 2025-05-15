package javaapplication1.Model;

public class Order {
    String orderId;
    String customerId;
    String menuId;
    int numberOfTable;
    String orderDate;
    String totalePrice;

    //default constructor
    public Order() {
        this.orderId = "";
        this.customerId = "";
        this.menuId = "";
        this.numberOfTable = 0;
        this.orderDate = "";
        this.totalePrice = "";
    }

    //constructor reference
    public Order(String orderId, String customerId, String menuId, int numberOfTable, String orderDate, String totalePrice) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.menuId = menuId;
        this.numberOfTable = numberOfTable;
        this.orderDate = orderDate;
        this.totalePrice = totalePrice;
    }

    //getters and setters

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public int getNumberOfTable() {
        return numberOfTable;
    }

    public void setNumberOfTable(int numberOfTable) {
        this.numberOfTable = numberOfTable;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getTotalePrice() {
        return totalePrice;
    }

    public void setTotalePrice(String totalePrice) {
        this.totalePrice = totalePrice;
    }


    //show information
    
}
