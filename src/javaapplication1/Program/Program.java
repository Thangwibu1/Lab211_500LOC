package javaapplication1.Program;

import javaapplication1.Controller.Inputer;
import javaapplication1.Controller.Menu;
import javaapplication1.Model.Customer;
import javaapplication1.Storage.CustomerList;
import javaapplication1.Storage.SetMenuList;

import java.io.IOException;

public class Program {
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
                    String id = Inputer.inputString("^[CKG][0-9]{3}$", "Enter customer ID: ");
                    System.out.print("Enter customer name: ");
                    String name = Inputer.inputString("^[A-Za-z ]+$", "");
                    System.out.print("Enter customer phone: ");
                    String phone = Inputer.inputString("^[0-9]{10}$", "");
                    System.out.print("Enter customer email: ");
                    String email = Inputer.inputString("^[a-zA-Z0-9._%+-]+@gmail\\.com$", "");

                    //new customer
                    Customer customer = new Customer(id, name, phone, email);
                    //add customer to list
                    customers.addNew(customer);
                    //save customer to file

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
                    String updateName = Inputer.inputString("^[A-Za-z ]+$", "Enter new customer name: ");
                    String updatePhone = Inputer.inputString("^[0-9]{10}$", "Enter new customer phone: ");
                    String updateEmail = Inputer.inputString("^[a-zA-Z0-9._%+-]+@gmail\\.com$", "Enter new customer email: ");

                    // Update customer information
                    Customer updateCustomer = new Customer(updateId, updateName, updatePhone, updateEmail);
                    customers.update(updateCustomer);
                    break;
                case 3:
                    // Search customer by ID
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
