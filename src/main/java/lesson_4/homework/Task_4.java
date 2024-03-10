package lesson_4.homework;

import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please provide a number: ");
        int userInput = scanner.nextInt();

        int remainder = userInput % 2;

        if (remainder == 0) {
            System.out.println("Provided number is even");
        } else {
            System.out.println("Provided number is not even");
        }
    }
}
