package javaapplication1.Model;

public class SetMenu {
    String menuId;
    String menuName;
    double price;
    String ingredients;

    //default constructor
    public SetMenu() {
        this.menuId = "";
        this.menuName = "";
        this.price = 0.0;
        this.ingredients = "";
    }

    //constructor reference
    public SetMenu(String menuId, String menuName, double price, String ingredients) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.price = price;
        this.ingredients = ingredients;
    }
    //getters and setters

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    //toString method

    @Override
    public String toString() {
        return String.format("%s\t|%s\t|%s\t|%s", menuId, menuName, price, ingredients);
    }

    //show information
    public void showInfo() {
        System.out.println("Menu ID: " + menuId);
        System.out.println("Menu Name: " + menuName);
        System.out.println("Price: " + price);
        System.out.println("Ingredients: " + ingredients);
    }
}
