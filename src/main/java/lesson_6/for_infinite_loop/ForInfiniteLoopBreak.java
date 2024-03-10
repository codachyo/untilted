package lesson_6.for_infinite_loop;

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