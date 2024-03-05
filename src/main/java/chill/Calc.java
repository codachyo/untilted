package chill;

import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Chill chill");
        System.out.println("print a first number");
        double num1 = scanner.nextDouble();

        System.out.println("print a second number");
        double num2 = scanner.nextDouble();

        System.out.println("select an action - (+, -, *, /:");
        char operator = scanner.next().charAt(0);

        double result;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;

            case '-':
                result = num1 - num2;
                break;

            case '*':
                result = num1 * num2;
                break;

            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("error.");
                return;
        }
        System.out.println("Result is: " + result);
        scanner.close();
    }
}
