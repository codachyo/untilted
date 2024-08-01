package lesson_9.MyClass;

class MyListTest {
    private static final String TEXT_RESET = "\u001B[0m";
    private static final String TEXT_RED = "\u001B[31m";
    private static final String TEXT_GREEN = "\u001B[32m";

    private static int totalRun = 0;
    private static int totalPassed = 0;
    private static int totalFailed = 0;

    public static void main(String[] args) {
        shouldReturnListLengthTest();
        shouldReturnTrueIfElementIsInListTest();
        shouldReturnFalseIfElementNotInListTest();
        shouldReturnElementAppearanceCountInListTestElementExists();
        shouldReturnElementAppearanceCountInListTestNoElement();
        shouldGetElementByIndexTest();
        shouldAddItemsToListTest();
        shouldAddItemsToListByIndexTest();
        shouldReplaceItemInListByIndexTest();
        shouldReplaceItemsInListByObjectTest();
        shouldRemoveItemsFromListByObjectTest();
        shouldRemoveItemFromListByIndexTest();
        shouldClearListTest();
        shouldSortItemsInListAscTest();
        shouldSortItemsInListDescTest();
        shouldReturnTrueIfListsAreEqualTest();
        shouldReturnFalseIfListsAreNotEqualTest();
        printFooter();
    }

    private static void shouldReturnListLengthTest() {
        totalRun++;
        MyListImpl list = new MyListImpl();
        list.add(new MyClass(1));
        checkResult(1,  list.size(),"shouldReturnListLengthTest");
    }

    private static void shouldReturnTrueIfElementIsInListTest() {
        totalRun++;
        MyListImpl list = new MyListImpl();
        list.add(new MyClass(1));
        checkResult(true,  list.isInList(new MyClass(1)),"shouldReturnTrueIfElementIsInListTest");
    }

    private static void shouldReturnFalseIfElementNotInListTest() {
        totalRun++;
        MyListImpl list = new MyListImpl();
        list.add(new MyClass(1));
        checkResult(false,  list.isInList(new MyClass(2)),"shouldReturnFalseIfElementNotInListTest");
    }

    private static void shouldReturnElementAppearanceCountInListTestElementExists() {
        totalRun++;
        MyListImpl list = new MyListImpl();
        list.add(new MyClass(1));
        list.add(new MyClass(2));
        list.add(new MyClass(3));
        list.add(new MyClass(2));
        checkResult(2,  list.appearanceCount(new MyClass(2)),"shouldReturnElementAppearanceCountInListTestElementExists");
    }

    private static void shouldReturnElementAppearanceCountInListTestNoElement() {
        totalRun++;
        MyListImpl list = new MyListImpl();
        list.add(new MyClass(1));
        list.add(new MyClass(3));
        checkResult(0,  list.appearanceCount(new MyClass(2)),"shouldReturnElementAppearanceCountInListTestNoElement");
    }

    private static void shouldGetElementByIndexTest() {
        totalRun++;
        MyListImpl list = new MyListImpl();
        list.add(new MyClass(1));
        list.add(new MyClass(3));
        list.add(new MyClass(5));
        checkResult(new MyClass(3),  list.get(1),"shouldGetElementByIndexTest");
    }

    private static void shouldAddItemsToListTest() {
        totalRun++;
        MyListImpl list = new MyListImpl();
        list.add(new MyClass(1));
        list.add(new MyClass(2));
        checkResult(2,  list.list.length,"shouldAddItemsToListTest");
    }

    private static void shouldAddItemsToListByIndexTest() {
        totalRun++;
        MyListImpl list = new MyListImpl();
        list.add(new MyClass(1));
        list.add(new MyClass(3));
        list.add(new MyClass(4));
        list.add(1, new MyClass(2));
        MyListImpl expected = new MyListImpl();
        expected.add(new MyClass(1));
        expected.add(new MyClass(2));
        expected.add(new MyClass(3));
        expected.add(new MyClass(4));
        checkResult(expected,  list,"shouldAddItemsToListByIndexTest");
    }

    private static void shouldReplaceItemInListByIndexTest() {
        totalRun++;
        MyListImpl list = new MyListImpl();
        list.add(new MyClass(1));
        list.add(new MyClass(2));
        list.add(new MyClass(3));
        list.add(new MyClass(4));
        list.replace(2, new MyClass(33));
        MyListImpl expected = new MyListImpl();
        expected.add(new MyClass(1));
        expected.add(new MyClass(2));
        expected.add(new MyClass(33));
        expected.add(new MyClass(4));
        checkResult(expected,  list,"shouldReplaceItemInListByIndexTest");
    }

    private static void shouldReplaceItemsInListByObjectTest() {
        totalRun++;
        MyListImpl list = new MyListImpl();
        list.add(new MyClass(3));
        list.add(new MyClass(2));
        list.add(new MyClass(3));
        list.add(new MyClass(4));
        list.replace(new MyClass(3), new MyClass(333));
        MyListImpl expected = new MyListImpl();
        expected.add(new MyClass(333));
        expected.add(new MyClass(2));
        expected.add(new MyClass(333));
        expected.add(new MyClass(4));
        checkResult(expected,  list,"shouldReplaceItemsInListByObjectTest");
    }

    private static void shouldRemoveItemsFromListByObjectTest() {
        totalRun++;
        MyListImpl list = new MyListImpl();
        list.add(new MyClass(1));
        list.add(new MyClass(2));
        list.add(new MyClass(1));
        list.add(new MyClass(4));
        list.remove(new MyClass(1));
        MyListImpl expected = new MyListImpl();
        expected.add(new MyClass(2));
        expected.add(new MyClass(4));
        checkResult(expected,  list,"shouldRemoveItemsFromListByObjectTest");
    }

    private static void shouldRemoveItemFromListByIndexTest() {
        totalRun++;
        MyListImpl list = new MyListImpl();
        list.add(new MyClass(1));
        list.add(new MyClass(2));
        list.add(new MyClass(3));
        list.remove(0);
        MyListImpl expected = new MyListImpl();
        expected.add(new MyClass(2));
        expected.add(new MyClass(3));
        checkResult(expected,  list,"shouldRemoveItemFromListByIndexTest");
    }

    private static void shouldClearListTest() {
        totalRun++;
        MyListImpl list = new MyListImpl();
        list.add(new MyClass(1));
        list.add(new MyClass(2));
        list.add(new MyClass(3));
        list.add(new MyClass(4));
        list.clear();
        checkResult(0,  list.size(),"shouldClearListTest");
    }

    private static void shouldSortItemsInListAscTest() {
        totalRun++;
        MyListImpl list = new MyListImpl();
        list.add(new MyClass(4));
        list.add(new MyClass(2));
        list.add(new MyClass(5));
        list.add(new MyClass(3));
        list.add(new MyClass(1));
        list.sort("ASC");
        MyListImpl expected = new MyListImpl();
        expected.add(new MyClass(1));
        expected.add(new MyClass(2));
        expected.add(new MyClass(3));
        expected.add(new MyClass(4));
        expected.add(new MyClass(5));
        checkResult(expected,  list,"shouldSortItemsInListAscTest");
    }

    private static void shouldSortItemsInListDescTest() {
        totalRun++;
        MyListImpl list = new MyListImpl();
        list.add(new MyClass(4));
        list.add(new MyClass(2));
        list.add(new MyClass(5));
        list.add(new MyClass(3));
        list.add(new MyClass(1));
        list.sort("DESC");
        MyListImpl expected = new MyListImpl();
        expected.add(new MyClass(5));
        expected.add(new MyClass(4));
        expected.add(new MyClass(3));
        expected.add(new MyClass(2));
        expected.add(new MyClass(1));
        checkResult(expected,  list,"shouldSortItemsInListDescTest");
    }

    private static void shouldReturnTrueIfListsAreEqualTest() {
        totalRun++;
        MyListImpl list = new MyListImpl();
        list.add(new MyClass(1));
        list.add(new MyClass(2));
        list.add(new MyClass(3));
        MyListImpl expected = new MyListImpl();
        expected.add(new MyClass(1));
        expected.add(new MyClass(2));
        expected.add(new MyClass(3));
        checkResult(true,  list.isEqual(expected),"shouldReturnTrueIfListsAreEqualTest");
    }

    private static void shouldReturnFalseIfListsAreNotEqualTest() {
        totalRun++;
        MyListImpl list = new MyListImpl();
        list.add(new MyClass(1));
        list.add(new MyClass(2));
        list.add(new MyClass(3));
        MyListImpl expected = new MyListImpl();
        expected.add(new MyClass(3));
        expected.add(new MyClass(2));
        expected.add(new MyClass(1));
        checkResult(false,  list.isEqual(expected),"shouldReturnFalseIfListsAreNotEqualTest");
    }

    private static void checkResult(boolean expected, boolean actual, String testName) {
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

    private static void checkResult(int expected, int actual, String testName) {
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

    private static void checkResult(MyClass expected, MyClass actual, String testName) {
        if (expected.equals(actual)) {
            System.out.println(TEXT_GREEN + testName + " - passed" + TEXT_RESET);
            totalPassed++;
        } else {
            System.out.println(TEXT_RED + testName + " - failed");
            System.out.println("Expected: " + expected);
            System.out.println("Actual:   " + actual + TEXT_RESET);
            totalFailed++;
        }
    }

    private static void checkResult(MyList expected, MyList actual, String testName) {
        if (expected.isEqual(actual)) {
            System.out.println(TEXT_GREEN + testName + " - passed" + TEXT_RESET);
            totalPassed++;
        } else {
            System.out.println(TEXT_RED + testName + " - failed");
            System.out.println("Expected:");
            expected.printElements();
            System.out.println("Actual:");
            actual.printElements();
            System.out.println(TEXT_RESET);
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
