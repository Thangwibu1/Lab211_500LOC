package javaapplication1.Interf;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ILists<T> {
    //add new Customer or order
    public boolean addNew(T t);

    //update ìnormation of Customer or order
    public boolean update(T t);

    //search Customer or order by id
    public T searchById(String id);

    //search by ID but return boolean
    public boolean searchByIdReturnBoolean(String id);
    //show all infor
    public void showAll();
    public boolean readFromFile() throws FileNotFoundException, IOException;
    public boolean saveToFile();
}
