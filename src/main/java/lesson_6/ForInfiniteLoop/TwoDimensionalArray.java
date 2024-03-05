package lesson_6.ForInfiniteLoop;

import java.util.Random;
class TwoDimensionalArray {
    public static void main(String[] args) {
        TwoDimensionalArray twoDimArray = new TwoDimensionalArray();
        int[][] array = twoDimArray.createArray(3, 4);
        twoDimArray.fillArrayWithRandomNumbers(array);
        twoDimArray.printArray(array);
        System.out.println("Array elements sum = " + twoDimArray.arrayElementsSum(array));
    }

    public int[][] createArray(int firstDimLength, int secondDimLength) {
        return new int[firstDimLength][secondDimLength];
    }

    public void fillArrayWithRandomNumbers(int[][] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(9);
            }
        }
    }

    public int arrayElementsSum(int[][] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result += array[i][j];
            }
        }
        return result;
    }

    public void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "|");
            }
            System.out.println();
        }
    }
}