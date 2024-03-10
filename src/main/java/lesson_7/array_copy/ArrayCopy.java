package lesson_7.array_copy;

import java.util.Arrays;

class ArrayCopy {
    int[] copyInRange(int[] in, int numberFrom, int numberTo) {
        int[] result = new int[in.length];
        int newLength = 0;

        for (int i = 0; i < in.length; i++) {
            if (in[i] >= numberFrom && in[i] <= numberTo) {
                result[newLength++] = in[i];
            }
        }
        return (newLength > 0) ? Arrays.copyOf(result, newLength) : null;
    }
}
