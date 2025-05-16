package javaapplication1.Storage;

import javaapplication1.Interf.ILists;
import javaapplication1.Model.SetMenu;

import java.io.*;
import java.util.ArrayList;

public class SetMenuList extends ArrayList<SetMenu> implements ILists<SetMenu> {
    @Override
    public boolean addNew(SetMenu setMenu) {
        return false;
    }

    @Override
    public boolean update(SetMenu setMenu) {
        return false;
    }

    @Override
    public SetMenu searchById(String id) {
        return null;
    }

    @Override
    public void showAll() {
        // Hiển thị danh sách thực đơn
        if (this.size() == 0) {
            System.out.println("Empy list of Feast Menu.");
        } else {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("List for Feast Menu ordering party");
            System.out.println("-----------------------------------------------------------------");
            for (SetMenu setMenu : this) {
                setMenu.showInfo();
            }
        }
    }

    @Override
    public boolean readFromFile() {
        String csvFile = "FeastMenu.csv";
        File file = new File(csvFile);
        // Kiểm tra xem file có tồn tại không
        if (!file.exists()) {
            System.out.println("File " + csvFile + " does not exist.");
            return false;
        }
        // Đọc file CSV
        this.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Đọc tiêu đề nếu có

            // Đọc từng dòng dữ liệu
            while(true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] data = line.split("[,]");
                String menuId = data[0].trim();
                String menuName = data[1].trim();
                double price = Double.parseDouble(data[2].trim());
                String ingredients = data[3].trim();

                this.add(new SetMenu(menuId, menuName, price, ingredients));
            }
            // Đóng file
            br.close();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean saveToFile() {
        return false;
    }
}
