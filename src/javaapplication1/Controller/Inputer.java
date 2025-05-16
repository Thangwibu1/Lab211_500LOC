package javaapplication1.Controller;

import java.util.Scanner;

public class Inputer {
    private static Scanner sc = new Scanner(System.in);

    //create method to input data
    public static String inputString(String match, String message) {
        String result = "";
        //create flag to check again1
        int flag = 0;
        do {
            if (flag == 0) {
                System.out.print(message);
                flag++;
            } else {
                System.out.println("Invalid input!");
                System.out.print(message);
            }

            result = sc.nextLine();
        } while (!result.matches(match) || result.trim().isEmpty());
        return result;
    }

    public static int inputInt(String match, String message) {
        int number = 0;
        while (true) {
            try {
                System.out.print(message);
                number = Integer.parseInt(sc.nextLine());
                if (!Integer.toString(number).matches(match)) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return number;
    }

    public static double inputDouble(String match, String message) {
        double number = 0.0;
        while (true) {
            try {
                System.out.print(message);
                number = Double.parseDouble(sc.nextLine());
                if (!Double.toString(number).matches(match)) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return number;
    }
}
