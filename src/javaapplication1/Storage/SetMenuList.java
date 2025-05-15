package javaapplication1.Storage;

import javaapplication1.Interf.ILists;
import javaapplication1.Model.SetMenu;

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
