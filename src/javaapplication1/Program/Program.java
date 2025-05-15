package javaapplication1.Program;

import javaapplication1.Controller.Menu;
import javaapplication1.Model.Customer;
import javaapplication1.Storage.CustomerList;

public class Program {
    public static void main(String[] args) {
        CustomerList customers = new CustomerList();
        Menu menu = new Menu();
        int choose = menu.showMenu();
        switch (choose) {
            case 1:
                customers.readFromFile();
                // Register customer
                break;
            case 2:
                // Update customer information
                break;
            case 3:
                // Search customer by ID
                break;
            case 4:
                // Display feast menu
                break;
            case 5:
                // Place a feast order
                break;
            case 6:
                // Update order information
                break;
            case 7:
                // Save data to file
                break;
            case 8:
                // Display Customer or Order lists
                break;
            case 0:
                // Exit
                System.out.println("Goodbye!");
                System.exit(0);
                return;
        }
    }
}
