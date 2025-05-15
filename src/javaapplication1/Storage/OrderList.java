package javaapplication1.Storage;
import javaapplication1.Interf.ILists;
import javaapplication1.Model.Order;
import javaapplication1.Model.SetMenu;
import javaapplication1.Model.Customer;

import java.util.ArrayList;

public class OrderList extends ArrayList<Order> implements ILists<Order> {
    @Override
    public boolean addNew(Order order) {
        return false;
    }

    @Override
    public boolean update(Order order) {
        return false;
    }

    @Override
    public Order searchById(String id) {
        return null;
    }

    @Override
    public void showAll() {

    }

    @Override
    public boolean readFromFile() {
        return false;
    }

    @Override
    public boolean saveToFile() {
        return false;
    }
}
