package lesson_6.array_service;

class ArrayService {

    public boolean containsNumber(int[] array, int numberToSearch) {
        boolean result = false;
        for (int number : array) {
            if (number == numberToSearch) {
                result = true;
                break;
            }
        }
        return result;
    }

    public int numberOccurrencesCount(int[] array, int numberToSearch) {
        int result = 0;
        for (int number : array) {
            if (number == numberToSearch) {
                result++;
            }
        }
        return result;
    }

    public boolean replaceNumberFirstOccurrence(int[] array, int numberToReplace, int newNumber) {
        boolean result = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == numberToReplace) {
                array[i] = newNumber;
                result = true;
                break;
            }
        }
        return result;
    }

    public int replaceNumberAllOccurrences(int[] array, int numberToReplace, int newNumber) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == numberToReplace) {
                array[i] = newNumber;
                result++;
            }
        }
        return result;
    }

    public void getReversed(int[] array) {
        int i = 0;
        int j = array.length - 1;
        int temp;

        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }

    public void getSorted(int[] array) {
        boolean isSorted = false;
        int temp;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                    isSorted = false;
                }
            }
        }

    }
}
