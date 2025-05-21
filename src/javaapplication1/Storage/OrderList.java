package javaapplication1.Storage;
import javaapplication1.Interf.ILists;
import javaapplication1.Model.Order;
import javaapplication1.Model.SetMenu;
import javaapplication1.Model.Customer;

import java.io.*;
import java.util.ArrayList;

public class OrderList extends ArrayList<Order> implements ILists<Order> {
    String pathFile = "orderlist.dat";
    @Override
    public boolean addNew(Order order) {
        this.add(order);
        return true;
    }

    @Override
    public boolean update(Order order) {
        Order search = searchById(order.getOrderId());
        if (search != null) {
            // Cập nhật thông tin đơn hàng
            search.setMenu(order.getMenu());
            search.setNumberOfTable(order.getNumberOfTable());
            search.setOrderDate(order.getOrderDate());
            search.setTotalPrice(order.getNumberOfTable() * order.getMenu().getPrice());
            return true;
        }
        return false;
    }

    @Override
    public Order searchById(String id) {
        for (Order order : this) {
            if (order.getOrderId().equals(id)) {
                return order;
            }
        }
        return null;
    }
    // Tìm kiếm theo ID nhưng trả về boolean
    public boolean searchByIdReturnBoolean(String id) {
        for (Order order : this) {
            if (order.getOrderId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void showAll() {
        for (Order order : this) {
            order.showInfo();
        }
    }

    @Override
    public boolean readFromFile() throws IOException {
        boolean check = false;
        File file = new File(pathFile);
        // Kiểm tra xem file có tồn tại không
        if (!file.exists()) {
            try {
                file.createNewFile();
                return true;
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
                e.printStackTrace();
                return false;
            }
        }

        // Kiểm tra xem file có rỗng không
        if (file.length() == 0) {
            System.out.println("File is empty.");
            return true;
        }
        // Đọc file
        try(FileInputStream fileIn = new FileInputStream(pathFile);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            this.clear();
            try {
                while (true) {
                    Order order = (Order) objectIn.readObject();
                    this.add(order);
                }
            } catch (EOFException e) {

            }
            check = true;

        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + e.getMessage());
            e.printStackTrace();
        } catch (InvalidClassException e) {
            System.err.println("Invalid class format: " + e.getMessage());
            e.printStackTrace();
        } catch (StreamCorruptedException e) {
            System.err.println("Corrupted stream: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IO error: " + e.getMessage());
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean saveToFile() {
        boolean check = false;
        try (FileOutputStream fileOut = new FileOutputStream(pathFile);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            // Giả sử class hiện tại implement Iterable<Customer> hoặc extend Collection<Customer>
            for (Order order : this) {
                if (order == null) {
                    continue;
                }
                objectOut.writeObject(order);
            }
            objectOut.flush(); // Đảm bảo dữ liệu được ghi xuống
            check = true;

        } catch (NotSerializableException e) {
            System.err.println("Lỗi: Customer class hoặc một trong các thuộc tính của nó không implement Serializable");
            System.err.println("Class gây lỗi: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Lỗi IO khi lưu: " + e.getMessage());
            e.printStackTrace();
        }

        return check;
    }

    //check duplicate
    public boolean checkDuplicate(String name, String date, String menuID) {
        for (Order order : this) {
            if (order.getCustomer().getName().equals(name)) {
                if (order.getOrderDate().equals(date)) {
                    if (order.getMenu().getMenuId().equals(menuID)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //Update customer
    public boolean updateCustomer(Customer customer) {
        boolean check = false;
        for (Order order : this) {
            if (order.getCustomer().getId().equals(customer.getId())) {
                order.setCustomer(customer);
                check = true;
            }
        }
        return check;
    }
}
