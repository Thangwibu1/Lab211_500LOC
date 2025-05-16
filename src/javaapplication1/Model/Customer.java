package javaapplication1.Model;

public class Customer implements java.io.Serializable {
    private String id;
    private String name;
    private String phone;
    private String email;

    //default constructor
    public Customer() {
        this.id = "";
        this.name = "";
        this.phone = "";
        this.email = "";
    }

    //constructor reference
    public Customer(String id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    //getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s\t|%s\t|%s\t|%s", id, name, phone, email);
    }

    //show information
    public void showInfo() {
        System.out.println("| Customer ID: " + id);
        System.out.println("| Customer Name: " + name);
        System.out.println("| Customer Phone: " + phone);
        System.out.println("| Customer Email: " + email);
    }
}
