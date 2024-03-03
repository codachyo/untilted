package lesson_4.HomeWork;

import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please provide a number: ");
        int userInput = scanner.nextInt();

        if (userInput < 0) {
            System.out.println("Provided number is negative");
        } else if (userInput > 0) {
            System.out.println("Provided number is positive");
        } else {
            System.out.println("Provided number is zero");
        }
    }
}
