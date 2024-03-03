package lesson_4.HomeWork;

import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please provide a digit from 1 till 7");
        int userInput = scanner.nextInt();

        switch(userInput) {
            case 1:
                System.out.println("Day of the week: Monday");
                break;
            case 2:
                System.out.println("Day of the week: Tuesday");
                break;
            case 3:
                System.out.println("Day of the week: Wednesday");
                break;
            case 4:
                System.out.println("Day of the week: Thursday");
                break;
            case 5:
                System.out.println("Day of the week: Friday");
                break;
            case 6:
                System.out.println("Day of the week: Saturday");
                break;
            case 7:
                System.out.println("Day of the week: Sunday");
                break;
            default:
                System.out.println("Provided digit is out of scope");
        }
    }
}
