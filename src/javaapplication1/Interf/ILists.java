package javaapplication1.Interf;

public interface ILists<T> {
    //add new Customer or order
    public boolean addNew(T t);

    //update ìnormation of Customer or order
    public boolean update(T t);

    //search Customer or order by id
    public T searchById(String id);

    //show all infor
    public void showAll();
    public boolean readFromFile();
    public boolean saveToFile();
}
