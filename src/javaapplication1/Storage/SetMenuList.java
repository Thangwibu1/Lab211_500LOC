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
        // Tìm kiếm thực đơn theo ID
        for (SetMenu setMenu : this) {
            if (id.equalsIgnoreCase(setMenu.getMenuId())) {
                return setMenu;
            }
        }
        return null;
    }

    // Tìm kiếm thực đơn theo ID nhưng trả về boolean
    public boolean searchByIdReturnBoolean(String id) {
        for (SetMenu setMenu : this) {
            if (id.equalsIgnoreCase(setMenu.getMenuId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void showAll() {
        int count = 0;
        // Hiển thị danh sách thực đơn
        if (this.size() == 0) {
            System.out.println("Empy list of Feast Menu.");
        } else {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("List for Feast Menu ordering party");
            System.out.println("-----------------------------------------------------------------");
            for (SetMenu setMenu : this) {
                if(count == 0) {
                    count++;
                    continue;
                }
                setMenu.showInfo();
            }
        }
    }

    @Override
    public boolean readFromFile() throws IOException {
        String csvFile = "FeastMenu.csv";
        File file = new File(csvFile);
        // Kiểm tra xem file có tồn tại không
        if (!file.exists()) {
            System.out.println("File " + csvFile + " does not exist.");
            return false;
        }
        // Đọc file CSV
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        this.clear();
        while (true) {
            line = br.readLine();
            if (line == null) {
                break;
            }
            String[] data = line.split(",");
            String menuID = data[0].trim();
            String menuName = data[1].trim();
            double price = Double.parseDouble(data[2].trim());
            String ingredients = data[3].trim();

            SetMenu setMenu = new SetMenu(menuID, menuName, price, ingredients);
            this.add(setMenu);
        }


        return true;
    }

    @Override
    public boolean saveToFile() {
        return false;
    }
}
