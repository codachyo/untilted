package lesson_6.ForInfiniteLoop;

class ForInfiniteLoopBreak {
    public static void main(String[] args) {
        int i = 0;
        for ( ; ; ) {
            if (i > 5) {
                break;
            }
            System.out.println("Loop iteration " + i);
            i++;
        }
    }
}