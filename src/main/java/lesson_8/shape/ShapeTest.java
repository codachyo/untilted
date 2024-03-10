package lesson_8.shape;

class ShapeTest {
    private static final String TEXT_RESET = "\u001B[0m";
    private static final String TEXT_RED = "\u001B[31m";
    private static final String TEXT_GREEN = "\u001B[32m";

    private static int totalRun = 0;
    private static int totalPassed = 0;
    private static int totalFailed = 0;

    public static void main(String[] args) {
        shouldCalculateCircleAreaTest();
        shouldCalculateCirclePerimeterTest();
        shouldCalculateSquareAreaTest();
        shouldCalculateSquarePerimeterTest();
        shouldCalculateRectangleAreaTest();
        shouldCalculateRectanglePerimeterTest();
        shouldCalculateTriangleAreaTest();
        shouldCalculateTrianglePerimeterTest();
        printFooter();
    }

    private static void shouldCalculateCircleAreaTest() {
        totalRun++;
        Shape shape = new Circle("circle", 2);
        checkResult(12.566370614359172, shape.calculateArea(), "shouldCalculateCircleAreaTest");
    }

    private static void shouldCalculateCirclePerimeterTest() {
        totalRun++;
        Shape shape = new Circle("circle", 3);
        checkResult(18.84955592153876, shape.calculatePerimeter(), "shouldCalculateCirclePerimeterTest");
    }

    private static void shouldCalculateSquareAreaTest() {
        totalRun++;
        Shape shape = new Square("square", 3);
        checkResult(9, shape.calculateArea(), "shouldCalculateSquareAreaTest");
    }

    private static void shouldCalculateSquarePerimeterTest() {
        totalRun++;
        Shape shape = new Square("square", 3);
        checkResult(12, shape.calculatePerimeter(), "shouldCalculateSquarePerimeterTest");
    }

    private static void shouldCalculateRectangleAreaTest() {
        totalRun++;
        Shape shape = new Rectangle("rectangle", 3, 2);
        checkResult(6, shape.calculateArea(), "shouldCalculateRectangleAreaTest");
    }

    private static void shouldCalculateRectanglePerimeterTest() {
        totalRun++;
        Shape shape = new Rectangle("rectangle", 3, 2);
        checkResult(10, shape.calculatePerimeter(), "shouldCalculateRectanglePerimeterTest");
    }

    private static void shouldCalculateTriangleAreaTest() {
        totalRun++;
        Shape shape = new Triangle("triangle", 3);
        checkResult(3.897114317029974, shape.calculateArea(), "shouldCalculateTriangleAreaTest");
    }

    private static void shouldCalculateTrianglePerimeterTest() {
        totalRun++;
        Shape shape = new Triangle("triangle", 3);
        checkResult(9, shape.calculatePerimeter(), "shouldCalculateTrianglePerimeterTest");
    }

    private static void checkResult(double expected, double actual, String testName) {
        if (expected == actual) {
            System.out.println(TEXT_GREEN + testName + " - passed" + TEXT_RESET);
            totalPassed++;
        } else {
            System.out.println(TEXT_RED + testName + " - failed");
            System.out.println("Expected: " + expected);
            System.out.println("Actual:   " + actual + TEXT_RESET);
            totalFailed++;
        }
    }

    private static void printFooter() {
        System.out.println("********************************************");
        if (totalFailed > 0) {
            System.out.println(TEXT_RED + "TOTAL: RUN = " + totalRun + "; PASSED = " + totalPassed +
                    "; FAILED = " + totalFailed + TEXT_RESET);
        } else {
            System.out.println(TEXT_GREEN + "TOTAL: RUN = " + totalRun + "; PASSED = " + totalPassed +
                    "; FAILED = " + totalFailed + TEXT_RESET);
        }
        System.out.println("********************************************");
    }
}
