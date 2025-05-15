package javaapplication1.Storage;
import javaapplication1.Interf.ILists;
import javaapplication1.Model.Customer;


import java.io.*;
import java.util.ArrayList;

public class CustomerList extends ArrayList<Customer> implements ILists<Customer> {
    String pathFile = "customer.dat";


    @Override
    public boolean addNew(Customer customer) {
        return false;
    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }

    @Override
    public Customer searchById(String id) {
        return null;
    }

    @Override
    public void showAll() {

    }

    //read from file
    @Override
    public boolean readFromFile() {
        boolean check = false;
        File file = new File(pathFile);
        // Kiểm tra xem file có tồn tại không
        if (!file.exists()) {
            try (FileOutputStream fos = new FileOutputStream(file)) {
                System.out.println("File mới đã được tạo!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return check;
        }
        // Đường dẫn đến file .dat
        try {
            // Tạo FileInputStream để đọc từ file .dat
            FileInputStream fileIn = new FileInputStream(pathFile);

            // Tạo ObjectInputStream để đọc đối tượng
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            // Đọc các đối tượng từ file
            try {
                while (true) {
                    // Đọc đối tượng và ép kiểu
                    CustomerList customer = (CustomerList) objectIn.readObject();
                    this.addAll(customer);
                    System.out.println("Đã đọc: " + customer);
                }
            } catch (EOFException e) {
                // Khi đọc hết file, EOFException sẽ được ném ra
                System.out.println("Đã đọc hết file");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // Đóng các streams
            objectIn.close();
            fileIn.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean saveToFile() {
        return false;
    }
}
