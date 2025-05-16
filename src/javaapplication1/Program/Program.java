package javaapplication1.Program;

import javaapplication1.Controller.Inputer;
import javaapplication1.Controller.Menu;
import javaapplication1.Model.Customer;
import javaapplication1.Model.Order;
import javaapplication1.Model.SetMenu;
import javaapplication1.Storage.CustomerList;
import javaapplication1.Storage.OrderList;
import javaapplication1.Storage.SetMenuList;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Program {
    //create global variables
    static String id;
    static String name;
    static String phone;
    static String email;

    static boolean checkSave = false;
    //create variable for order
    static String orderId;
    static String customerId;
    static String setMenuId;
    static int numberOfTable;
    static String date;
    static String totalPrice;
    static Customer orderCustomer;
    static SetMenu orderSetMenu;

    public static void main(String[] args) throws IOException {
        CustomerList customers = new CustomerList();
        SetMenuList setMenu = new SetMenuList();
        OrderList orders = new OrderList();
        Order order;
        Menu menu = new Menu();
        orders.readFromFile();
        customers.readFromFile();
        setMenu.readFromFile();
        while (true) {
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

                    setMenu.showAll();
                    // Display feast menu
                    break;
                case 5:
                    //create orderId
                    orders.showAll();
                    Date currentDate = new Date();
                    System.out.println("---------------Place a feast order---------------");
                    SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
                    String formattedDate = sdf.format(currentDate);
                    orderId = formattedDate;

                    //handle customer ID
                    customers.showAll();
                    while (true) {
                        customerId = Inputer.inputString("^[CKG][0-9]{3}$", "Enter customer ID: ");
                        //check exits
                        if (!customers.searchByIdReturnBoolean(customerId)) {
                            System.out.println("Customer not found!!!");
                            continue;
                        }
                        orderCustomer = customers.searchById(customerId);
                        break;
                    }

                    //handle set menu ID
                    setMenu.showAll();
                    while (true) {
                        setMenuId = Inputer.inputString("^PW[0-9]{3}$", "Enter set menu ID: ");
                        //check exits
                        if (!setMenu.searchByIdReturnBoolean(setMenuId)) {
                            System.out.println("Set menu not found!!!");
                            continue;
                        }
                        orderSetMenu = setMenu.searchById(setMenuId);
                        break;
                    }
                    //handle number of table
                    numberOfTable = Inputer.inputInt("^[1-9][0-9]*$", "Enter number of table: ");

                    //handle order date
                    LocalDate localDate = LocalDate.now();
                    while (true) {
                        LocalDate futureDate = LocalDate.parse(Inputer.inputString("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$", "Enter order date (yyyy-MM-dd): "));
                        if (futureDate.isBefore(localDate)) {
                            System.out.println("Order date must be in the future!!!");
                            continue;
                        } else {
                            date = futureDate.toString();
                            break;
                        }
                    }

                    //handle total price
                    totalPrice = numberOfTable * orderSetMenu.getPrice() + "";
                    //create order
                    order = new Order(orderId, orderCustomer, orderSetMenu, numberOfTable, date, totalPrice);
                    //add order to list
                    orders.addNew(order);
                    //free memory
                    orderId = customerId = setMenuId = null;
                    numberOfTable = 0;
                    date = totalPrice = null;

                    break;
                case 6:
                    // Update order information
                    orders.showAll();
                    String updateOrderId = Inputer.inputString("^[0-9]{14}$", "Enter order ID to update: ");
                    //check exits
                    if (!orders.searchByIdReturnBoolean(updateOrderId)) {
                        System.out.println("Order not found!!!");
                        break;
                    }
                    //handle customer ID
                    Customer customerUpdate = orders.searchById(updateOrderId).getCustomer();
                    //handle set menu ID
                    SetMenu setMenuUpdate = orders.searchById(updateOrderId).getMenu();
                    //handle number of table
                    numberOfTable = Inputer.inputInt("^[1-9][0-9]*$", "Enter number of table update: ");
                    //handle order date
                    LocalDate newDate = LocalDate.now();
                    while (true) {
                        LocalDate futureDate = LocalDate.parse(Inputer.inputString("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$", "Enter order date (yyyy-MM-dd): "));
                        if (futureDate.isBefore(newDate)) {
                            System.out.println("Order date must be in the future!!!");
                            continue;
                        } else {
                            date = futureDate.toString();
                            break;
                        }
                    }
                    //handle total price
                    totalPrice = numberOfTable * setMenuUpdate.getPrice() + "";
                    //create order
                    order = new Order(updateOrderId, customerUpdate, setMenuUpdate, numberOfTable, date, totalPrice);
                    //update order to list
                    orders.update(order);
                    //free memory
                    updateOrderId = customerId = setMenuId = null;
                    numberOfTable = 0;
                    date = totalPrice = null;
                    break;
                case 7:
                    customers.saveToFile();
                    orders.saveToFile();
                    System.out.println("Data saved successfully.");
                    System.out.println("Goodbye!");
                    checkSave = true;
                    // Save data to file
                    break;
                case 8:
                    String listChoice = Inputer.inputString("^[OoCc]$", "Do you want to display customer list (C) or order list (O)? ");
                    if (listChoice.equalsIgnoreCase("c")) {
                        customers.showAll();
                    } else if (listChoice.equalsIgnoreCase("o")) {
                        orders.showAll();
                    }
                    // Display Customer or Order lists
                    break;
                case 0:
                    // Exit
                    System.out.println("Goodbye!");
                    System.exit(0);
                    return;
            }
            String choice = Inputer.inputString("^[YyNn]$", "Do you want to continue? (Y/N): ");
            if (!choice.equalsIgnoreCase("y")) {
                if (!checkSave) {
                    String saveChoice = Inputer.inputString("^[YyNn]$", "Do you want to save data to file? (Y/N): ");
                    if (saveChoice.equalsIgnoreCase("y")) {
                        customers.saveToFile();
                        orders.saveToFile();
                        System.out.println("Data saved successfully.");
                        System.out.println("Goodbye!");
                    } else {
                        System.out.println("Data not saved.");
                        System.out.println("Goodbye!");
                    }
                    break;
                }
                break;
            }
        }
    }
}
