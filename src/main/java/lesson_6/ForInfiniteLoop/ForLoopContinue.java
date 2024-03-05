package lesson_6.ForInfiniteLoop;

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
