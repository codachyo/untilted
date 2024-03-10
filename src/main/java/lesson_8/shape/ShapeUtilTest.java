package lesson_8.shape;

class ShapeUtilTest {
    private static final String TEXT_RESET = "\u001B[0m";
    private static final String TEXT_RED = "\u001B[31m";
    private static final String TEXT_GREEN = "\u001B[32m";

    private static int totalRun = 0;
    private static int totalPassed = 0;
    private static int totalFailed = 0;

    private static ShapeUtil shapeUtil = new ShapeUtil();

    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = shapeUtil.createRandomShape();
        }
        shouldCalculateShapesAreaTest(shapes);
        shouldCalculateShapesPerimeterTest(shapes);
        printFooter();
    }

    private static void shouldCalculateShapesAreaTest(Shape[] shapes) {
        totalRun++;
        checkResult(0, shapeUtil.calculateArea(shapes), "shouldCalculateShapesAreaTest");
    }

    private static void shouldCalculateShapesPerimeterTest(Shape[] shapes) {
        totalRun++;
        checkResult(0, shapeUtil.calculatePerimeter(shapes), "shouldCalculateShapesPerimeterTest");
    }

    private static void checkResult(double expected, double actual, String testName) {
        if (expected < actual) {
            System.out.println(TEXT_GREEN + testName + " - passed" + TEXT_RESET);
            totalPassed++;
        } else {
            System.out.println(TEXT_RED + testName + " - failed");
            System.out.println("Expected is higher than: " + expected);
            System.out.println("Actual:                  " + actual + TEXT_RESET);
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
