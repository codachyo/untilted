package lesson_5;

import java.util.Arrays;
import java.util.Scanner;

class Task_25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please provide array size: ");
        int arraySize = scanner.nextInt();

        int[] array = new int[arraySize];

        for (int i = 0; i < array.length; i++) {
            System.out.print("Please provide array[" + i + "] value: ");
            array[i] = scanner.nextInt();
        }

        System.out.println("Array: " + Arrays.toString(array));
    }
}
