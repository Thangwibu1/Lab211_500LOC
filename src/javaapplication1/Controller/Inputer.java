package javaapplication1.Controller;

import java.util.Scanner;

public class Inputer {
    private static Scanner sc = new Scanner(System.in);
    //create method to input data
    public static String inputString(String match) {
        String result = "";
        do {
            System.out.print("Enter value: ");
            result = sc.nextLine();
        } while (!result.matches(match));
        return result;
    }

    public static int inputInt(String match) {
        int number = 0;
        try {
            System.out.print("Enter value: ");
            number = Integer.parseInt(sc.nextLine());
            if(!Integer.toString(number).matches(match)) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
        return number;
    }

    public static double inputDouble(String match) {
        double number = 0;
        try {
            System.out.print("Enter value: ");
            number = Double.parseDouble(sc.nextLine());
            if(!Double.toString(number).matches(match)) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
        return number;
    }
}
