package lesson_5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Task_27 {
    public static void main(String[] args) {
        int[] array = new int[5];

        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println("Array: " + Arrays.toString(array));

        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        System.out.println("Maximal value is: " + max);
    }
}
