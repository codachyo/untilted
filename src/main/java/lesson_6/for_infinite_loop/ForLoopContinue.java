package lesson_6.for_infinite_loop;

class ForLoopContinue {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println("Loop iteration " + (i + 1));
        }
    }
}
