package javaapplication1.Model;


public class Order implements java.io.Serializable{
    String orderId;
    Customer customer;
    SetMenu menu;
    int numberOfTable;
    String orderDate;
    String totalePrice;

    //default constructor
    public Order() {
        this.orderId = "";
        this.customer = null;
        this.menu = null;
        this.numberOfTable = 0;
        this.orderDate = "";
        this.totalePrice = "";
    }

    //constructor reference
    public Order(String orderId, Customer customer, SetMenu menu, int numberOfTable, String orderDate, String totalePrice) {
        this.orderId = orderId;
        this.customer = customer;
        this.menu = menu;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public SetMenu getMenu() {
        return menu;
    }

    public void setMenu(SetMenu menu) {
        this.menu = menu;
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

    public void showInfo() {
        System.out.printf("-----------------------------------------------------------------------\n");
        System.out.println("Order ID: " + orderId);
        System.out.println("----------------------------------------------------------------------");
        customer.showInfo();
        System.out.println("----------------------------------------------------------------------");
        menu.showInfo();
        System.out.println("Number of table: " + numberOfTable);
        System.out.println("Order date: " + orderDate);

        System.out.println("----------------------------------------------------------------------");
        System.out.println("Total price: " + totalePrice);
        System.out.println("----------------------------------------------------------------------");
    }
}
