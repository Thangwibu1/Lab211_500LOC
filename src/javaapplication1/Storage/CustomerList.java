package javaapplication1.Storage;
import javaapplication1.Interf.ILists;
import javaapplication1.Model.Customer;


import java.io.*;
import java.util.ArrayList;

public class CustomerList extends ArrayList<Customer> implements ILists<Customer> {
    String pathFile = "customer.dat";


    @Override
    public boolean addNew(Customer customer) {
        // Kiểm tra xem danh sách đã có khách hàng chưa
        this.add(customer);
        return true;
    }

    @Override
    public boolean update(Customer customer) {
        Customer search = searchById(customer.getId());
        if (search != null) {
            // Cập nhật thông tin khách hàng
            search.setName(customer.getName());
            search.setPhone(customer.getPhone());
            search.setEmail(customer.getEmail());
            return true;
        }
        return false;
    }

    @Override
    public Customer searchById(String id) {
        for (Customer customer : this) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    //search by ID but return boolean
    public boolean searchByIdReturnBoolean(String id) {
        for (Customer customer : this) {
            if (customer.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void showAll() {
        if (this.size() == 0) {
            System.out.println("Danh sách khách hàng rỗng.");
        } else {
            System.out.println("Danh sách khách hàng:");
            for (Customer customer : this) {
                System.out.println(customer);
            }
        }
    }

    //read from file
    @Override
    public boolean readFromFile() {
        boolean check = false;
        File file = new File(pathFile);

        if (!file.exists()) {
            try {
                file.createNewFile();
                return true; // New empty file created successfully
            } catch (IOException e) {
                System.err.println("Failed to create new file: " + e.getMessage());
                return false;
            }
        }

        // Kiểm tra nếu file rỗng
        if (file.length() == 0) {
            return true; // File trống không có gì để đọc
        }

        try (FileInputStream fileIn = new FileInputStream(pathFile);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            this.clear();
            try {
                while (true) {
                    Customer customer = (Customer) objectIn.readObject();
                    this.add(customer);
                }
            } catch (EOFException e) {
                // Đây là cách thông thường để phát hiện kết thúc của stream khi đọc các đối tượng
                // Không cần xử lý gì, đây là điều kiện thoát bình thường từ vòng lặp
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
            for (Customer customer : this) {
                if (customer == null) {
                    continue;
                }
                objectOut.writeObject(customer);
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
}
