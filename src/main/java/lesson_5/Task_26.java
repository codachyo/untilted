package lesson_5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Task_26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please provide array size: ");
        int arraySize = scanner.nextInt();

        int[] array = new int[arraySize];

        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println("Array: " + Arrays.toString(array));
    }
}
