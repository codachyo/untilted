package lesson_5;

import java.util.Arrays;
import java.util.Scanner;

public class Task_10 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Tell me a number");

        int[] array = new int[3];
        array[0] = scanner.nextInt();
        array[1] = scanner.nextInt();
        array[2] = scanner.nextInt();

        System.out.println("Array = " + Arrays.toString(array));
    }
}
