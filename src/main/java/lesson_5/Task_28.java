package lesson_5;

import java.util.Arrays;
import java.util.Random;

class Task_28 {
    public static void main(String[] args) {
        int[] array = new int[5];

        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println("Array: " + Arrays.toString(array));

        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        System.out.println("Minimal value is: " + min);
    }
}
