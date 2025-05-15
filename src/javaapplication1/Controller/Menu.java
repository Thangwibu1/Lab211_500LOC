package javaapplication1.Controller;


public class Menu {
    public int showMenu() {
        System.out.println("------------------------Menu-------------------------");
        System.out.println("|1. Register customer                               |");
        System.out.println("|2. Update customer information                     |");
        System.out.println("|3. Search customer by ID                           |");
        System.out.println("|4. Display feast menu                              |");
        System.out.println("|5. Place a feast order                             |");
        System.out.println("|6. Update order information                        |");
        System.out.println("|7. Save data to file                               |");
        System.out.println("|8. Display Customer or Order lists                 |");
        System.out.println("|0. Exit                                            |");
        System.out.println("-----------------------------------------------------");
        System.out.print("Please choose an option: ");

        return Inputer.inputInt("^[0-8]$");
    }
}
