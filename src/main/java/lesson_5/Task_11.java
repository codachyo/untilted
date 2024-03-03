package lesson_5;

import java.util.Arrays;
import java.util.Scanner;

class Task_11 {
    public static void main(String[] args) {
        int[] array = new int[3];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            System.out.print("Please provide array[" + i + "] value: ");
            array[i] = scanner.nextInt();
        }

        System.out.println("Array: " + Arrays.toString(array));

    }
}
