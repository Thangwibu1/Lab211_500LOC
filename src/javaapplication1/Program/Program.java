package javaapplication1.Program;

import javaapplication1.Controller.Inputer;
import javaapplication1.Controller.Menu;
import javaapplication1.Model.Customer;
import javaapplication1.Storage.CustomerList;
import javaapplication1.Storage.SetMenuList;

import java.io.IOException;

public class Program {
    //create global variables
    static String id;
    static String name;
    static String phone;
    static String email;

    public static void main(String[] args) throws IOException {
        CustomerList customers = new CustomerList();
        SetMenuList setMenu = new SetMenuList();

        Menu menu = new Menu();
        customers.readFromFile();
        while(true) {
            int choose = menu.showMenu();
            switch (choose) {
                case 1:

                    customers.showAll();
                    System.out.println("---------------Register new customer---------------");
                    //enter identification
                    while (true) {
                        id = Inputer.inputString("^[CKG][0-9]{3}$", "Enter customer ID: ");
                        //check exits
                        if (customers.searchByIdReturnBoolean(id)) {
                            System.out.println("Customer ID already exists!!!");
                            continue;
                        }
                        break;
                    }
                    //enter name
                    while (true) {
                        name = Inputer.inputString("^[A-Za-z ]+$", "Enter customer name: ");
                        if (name.length() < 2 || name.length() > 25) {
                            System.out.println("Name must be between 2 and 25 characters!");
                            continue;
                        } else {
                            break;
                        }
                    }
                    System.out.print("Enter customer phone: ");
                    phone = Inputer.inputString("^0[0-9]{9}$", "");
                    System.out.print("Enter customer email: ");
                    email = Inputer.inputString("^[a-zA-Z0-9._%+-]+@gmail\\.com$", "");

                    //new customer
                    Customer customer = new Customer(id, name, phone, email);
                    //add customer to list
                    customers.addNew(customer);
                    //save customer to file
                    //free memory
                    id = name = phone = email = null;
                    // Register customer
                    break;
                case 2:
                    customers.showAll();
                    System.out.println("---------------Update customer information---------------");
                    String updateId = Inputer.inputString("^[CKG][0-9]{3}$", "Enter customer ID to update: ");
                    //check exits
                    if (!customers.searchByIdReturnBoolean(updateId)) {
                        System.out.println("Customer not found!!!");
                        break;
                    }
                    //enter filed
                    while (true) {
                        name = Inputer.inputString("^[A-Za-z ]+$", "Enter customer name: ");
                        if (name.length() < 2 || name.length() > 25) {
                            System.out.println("Name must be between 2 and 25 characters!");
                            continue;
                        } else {
                            break;
                        }
                    }
                    System.out.print("Enter customer phone: ");
                    phone = Inputer.inputString("^0[0-9]{9}$", "");
                    System.out.print("Enter customer email: ");
                    email = Inputer.inputString("^[a-zA-Z0-9._%+-]+@gmail\\.com$", "");

                    // Update customer information
                    customer = new Customer(updateId, name, phone, email);
                    customers.update(customer);

                    //free memory
                    updateId = name = phone = email = null;
                    break;
                case 3:
                    // Search customer by ID
                    customers.showAll();
                    id = Inputer.inputString("^[CKG][0-9]{3}$", "Enter customer ID to search: ");
                    //check exits
                    if (!customers.searchByIdReturnBoolean(id)) {
                        System.out.println("Customer not found!!!");
                        break;
                    } else {
                        Customer customerFound = customers.searchById(id);
                        System.out.println(customerFound);
                    }
                    break;
                case 4:
                    setMenu.readFromFile();
                    setMenu.showAll();
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
            String choice = Inputer.inputString("^[YyNn]$", "Do you want to continue? (Y/N): ");
            if(!choice.equalsIgnoreCase("y")) {
                String saveChoice = Inputer.inputString("^[YyNn]$", "Do you want to save data to file? (Y/N): ");
                if(saveChoice.equalsIgnoreCase("y")) {
                    customers.saveToFile();
                    System.out.println("Data saved successfully.");
                    System.out.println("Goodbye!");
                } else {
                    System.out.println("Data not saved.");
                    System.out.println("Goodbye!");
                }
                break;
            }
        }
    }
}
