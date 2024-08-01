package lesson_9.Book;

class BookReaderTest {
    private static final String TEXT_RESET = "\u001B[0m";
    private static final String TEXT_RED = "\u001B[31m";
    private static final String TEXT_GREEN = "\u001B[32m";

    private static int totalRun = 0;
    private static int totalPassed = 0;
    private static int totalFailed = 0;

    public static void main(String[] args) {
        shouldAddNewBookTestReturnTrue();
        shouldAddNewBookTestUpdateDB();
        shouldNotAddDuplicateBookTestReturnFalse();
        shouldNotAddDuplicateBookTestDoNotUpdateDB();
        shouldNotAddNewBookWithoutAuthorTestReturnFalse();
        shouldNotAddNewBookWithoutTitleTestReturnFalse();
        shouldNotAddNewBookWithoutAuthorTestDoNotUpdateDB();
        shouldNotAddNewBookWithoutTitleTestDoNotUpdateDB();
        shouldDeleteBookTestReturnTrue();
        shouldDeleteBookTestUpdateDB();
        shouldNotDeleteNonexistentBookTestReturnFalse();
        shouldNotDeleteNonexistentBookTestDoNotUpdateDB();
        shouldProvideBookListTest();
        shouldProvideBooksByAuthorTestStrictSearch();
        shouldProvideBooksByAuthorTestFlexibleSearch();
        shouldProvideBooksByTitleTestStrictSearch();
        shouldProvideBooksByTitleTestFlexibleSearch();
        shouldMarkBookAsReadTestReturnTrue();
        shouldAMarkBookAsReadTestUpdateDB();
        shouldNotMarkNonexistentBookAsReadTestReturnFalse();
        shouldNotMarkNonexistentBookAsReadTestUpdateDB();
        shouldMarkBookAsUnreadTestReturnTrue();
        shouldAMarkBookAsUnreadTestUpdateDB();
        shouldNotMarkNonexistentBookAsUnreadTestReturnFalse();
        shouldNotMarkNonexistentBookAsUnreadTestUpdateDB();
        shouldProvideReadBooksListTest();
        shouldProvideUnreadBooksListTest();
        printFooter();
    }

    private static void shouldAddNewBookTestReturnTrue() {
        totalRun++;
        Book book = new Book("Author1", "Title1");
        BookReaderImpl reader = new BookReaderImpl();
        checkResult(true,  reader.addBook(book),"shouldAddNewBookTestReturnTrue");
    }

    private static void shouldAddNewBookTestUpdateDB() {
        totalRun++;
        BookReaderImpl reader = new BookReaderImpl();
        Book book = new Book("Author1", "Title1");
        reader.addBook(book);
        Book expected = clone(book);
        checkResult(expected,  reader.books[0],"shouldAddNewBookTestUpdateDB");
    }

    private static void shouldNotAddDuplicateBookTestReturnFalse() {
        totalRun++;
        Book book = new Book("Author1", "Title1");
        BookReaderImpl reader = new BookReaderImpl();
        reader.addBook(book);
        checkResult(false,  reader.addBook(book),"shouldNotAddDuplicateBookTestReturnFalse");
    }

    private static void shouldNotAddDuplicateBookTestDoNotUpdateDB() {
        totalRun++;
        Book book = new Book("Author1", "Title1");
        BookReaderImpl reader = new BookReaderImpl();
        reader.addBook(book);
        reader.addBook(book);
        checkResult(1,  reader.books.length,"shouldNotAddDuplicateBookTestDoNotUpdateDB");
    }

    private static void shouldNotAddNewBookWithoutAuthorTestReturnFalse() {
        totalRun++;
        Book book = new Book("", "Title1");
        BookReaderImpl reader = new BookReaderImpl();
        checkResult(false,  reader.addBook(book),"shouldNotAddNewBookWithoutAuthorTestReturnFalse");
    }

    private static void shouldNotAddNewBookWithoutTitleTestReturnFalse() {
        totalRun++;
        Book book = new Book("Author1", "");
        BookReaderImpl reader = new BookReaderImpl();
        checkResult(false,  reader.addBook(book),"shouldNotAddNewBookWithoutTitleTestReturnFalse");
    }

    private static void shouldNotAddNewBookWithoutAuthorTestDoNotUpdateDB() {
        totalRun++;
        Book book = new Book("", "Title1");
        BookReaderImpl reader = new BookReaderImpl();
        reader.addBook(book);
        checkResult(0,  reader.books.length,"shouldNotAddNewBookWithoutAuthorTestDoNotUpdateDB");
    }

    private static void shouldNotAddNewBookWithoutTitleTestDoNotUpdateDB() {
        totalRun++;
        Book book = new Book("Author1", "");
        BookReaderImpl reader = new BookReaderImpl();
        reader.addBook(book);
        reader.addBook(book);
        checkResult(0,  reader.books.length,"shouldNotAddNewBookWithoutTitleTestDoNotUpdateDB");
    }

    private static void shouldDeleteBookTestReturnTrue() {
        totalRun++;
        Book book = new Book("Author1", "Title1");
        BookReaderImpl reader = new BookReaderImpl();
        reader.addBook(book);
        checkResult(true,  reader.deleteBook(book),"shouldDeleteBookTestReturnTrue");
    }

    private static void shouldDeleteBookTestUpdateDB() {
        totalRun++;
        Book book = new Book("Author1", "Title1");
        BookReaderImpl reader = new BookReaderImpl();
        reader.addBook(book);
        int records = reader.books.length;
        reader.deleteBook(book);
        checkResult(0,  records - 1,"shouldDeleteBookTestUpdateDB");
    }

    private static void shouldNotDeleteNonexistentBookTestReturnFalse() {
        totalRun++;
        Book book = new Book("Author1", "Title1");
        BookReaderImpl reader = new BookReaderImpl();
        reader.addBook(book);
        checkResult(false,  reader.deleteBook(new Book("Author1", "Title2")),"shouldNotDeleteNonexistentBookTestReturnFalse");
    }

    private static void shouldNotDeleteNonexistentBookTestDoNotUpdateDB() {
        totalRun++;
        Book book = new Book("Author1", "Title1");
        BookReaderImpl reader = new BookReaderImpl();
        reader.addBook(book);
        int records = reader.books.length;
        reader.deleteBook(new Book("Author1", "Title2"));
        checkResult(0,  records - 1,"shouldNotDeleteNonexistentBookTestDoNotUpdateDB");
    }

    private static void shouldProvideBookListTest() {
        totalRun++;
        BookReaderImpl reader = new BookReaderImpl();
        reader.addBook(new Book("Author1", "Title1"));
        reader.addBook(new Book("Author2", "Title2"));
        reader.addBook(new Book("Author3", "Title3"));
        String[] expected = {"Title1 [Author1]", "Title2 [Author2]", "Title3 [Author3]"};
        checkResult(expected, reader.getAllBooksList(), "shouldProvideBookListTest");
    }

    private static void shouldProvideBooksByAuthorTestStrictSearch() {
        totalRun++;
        BookReaderImpl reader = new BookReaderImpl();
        reader.addBook(new Book("Author1", "Title1"));
        reader.addBook(new Book("Author2", "Title2"));
        reader.addBook(new Book("Author 2", "Title2"));
        reader.addBook(new Book("Author3", "Title3"));
        reader.addBook(new Book("Author2", "Title4"));
        reader.addBook(new Book("Author2suffix", "Title5"));
        Book[] expected = {new Book("Author2", "Title2"),
                new Book("Author2", "Title4")};
        checkResult(expected, reader.getBooksByAuthor("Author2", true), "shouldProvideBooksByAuthorTestStrictSearch");
    }

    private static void shouldProvideBooksByAuthorTestFlexibleSearch() {
        totalRun++;
        BookReaderImpl reader = new BookReaderImpl();
        reader.addBook(new Book("Author1", "Title1"));
        reader.addBook(new Book("Author2", "Title2"));
        reader.addBook(new Book("Author 2", "Title2"));
        reader.addBook(new Book("Author3", "Title3"));
        reader.addBook(new Book("Author2", "Title4"));
        reader.addBook(new Book("Author2suffix", "Title5"));
        Book[] expected = {new Book("Author2", "Title2"),
                new Book("Author2", "Title4"),
                new Book("Author2suffix", "Title5")};
        checkResult(expected, reader.getBooksByAuthor("Author2", false), "shouldProvideBooksByAuthorTestFlexibleSearch");
    }

    private static void shouldProvideBooksByTitleTestStrictSearch() {
        totalRun++;
        BookReaderImpl reader = new BookReaderImpl();
        reader.addBook(new Book("Author1", "Title1"));
        reader.addBook(new Book("Author2", "Title2"));
        reader.addBook(new Book("Author2", "Title 2"));
        reader.addBook(new Book("Author3", "Title3"));
        reader.addBook(new Book("Author4", "Title2"));
        reader.addBook(new Book("Author5", "Title2suffix"));
        Book[] expected = {new Book("Author2", "Title2"),
                new Book("Author4", "Title2")};
        checkResult(expected, reader.getBooksByTitle("Title2", true), "shouldProvideBooksByTitleTestStrictSearch");
    }

    private static void shouldProvideBooksByTitleTestFlexibleSearch() {
        totalRun++;
        BookReaderImpl reader = new BookReaderImpl();
        reader.addBook(new Book("Author1", "Title1"));
        reader.addBook(new Book("Author2", "Title2"));
        reader.addBook(new Book("Author2", "Title 2"));
        reader.addBook(new Book("Author3", "Title3"));
        reader.addBook(new Book("Author4", "Title2"));
        reader.addBook(new Book("Author5", "Title2suffix"));
        Book[] expected = {new Book("Author2", "Title2"),
                new Book("Author4", "Title2"),
                new Book("Author5", "Title2suffix")};
        checkResult(expected, reader.getBooksByTitle("Title2", false), "shouldProvideBooksByTitleTestFlexibleSearch");
    }

    private static void shouldMarkBookAsReadTestReturnTrue() {
        totalRun++;
        Book book = new Book("Author1", "Title1");
        BookReaderImpl reader = new BookReaderImpl();
        reader.addBook(book);
        checkResult(true,  reader.markBookAsRead(book),"shouldMarkBookAsReadTestReturnTrue");
    }

    private static void shouldAMarkBookAsReadTestUpdateDB() {
        totalRun++;
        Book book = new Book("Author1", "Title1");
        BookReaderImpl reader = new BookReaderImpl();
        reader.addBook(book);
        reader.markBookAsRead(book);
        checkResult(true,  reader.books[0].isRead(),"shouldAMarkBookAsReadTestUpdateDB");
    }

    private static void shouldNotMarkNonexistentBookAsReadTestReturnFalse() {
        totalRun++;
        BookReaderImpl reader = new BookReaderImpl();
        reader.addBook(new Book("Author1", "Title1"));
        checkResult(false, reader.markBookAsRead(new Book("Author2", "Title2")),"shouldNotMarkNonexistentBookAsReadTestReturnFalse");
    }

    private static void shouldNotMarkNonexistentBookAsReadTestUpdateDB() {
        totalRun++;
        Book book = new Book("Author1", "Title1");
        BookReaderImpl reader = new BookReaderImpl();
        reader.addBook(book);
        reader.markBookAsRead(new Book("Author2", "Title2"));
        checkResult(false,  reader.books[0].isRead(),"shouldNotMarkNonexistentBookAsReadTestUpdateDB");
    }

    private static void shouldMarkBookAsUnreadTestReturnTrue() {
        totalRun++;
        Book book = new Book("Author1", "Title1");
        BookReaderImpl reader = new BookReaderImpl();
        reader.addBook(book);
        checkResult(true,  reader.markBookAsUnread(book),"shouldMarkBookAsUnreadTestReturnTrue");
    }

    private static void shouldAMarkBookAsUnreadTestUpdateDB() {
        totalRun++;
        Book book = new Book("Author1", "Title1");
        BookReaderImpl reader = new BookReaderImpl();
        reader.addBook(book);
        reader.markBookAsUnread(book);
        checkResult(false,  reader.books[0].isRead(),"shouldAMarkBookAsUnreadTestUpdateDB");
    }

    private static void shouldNotMarkNonexistentBookAsUnreadTestReturnFalse() {
        totalRun++;
        BookReaderImpl reader = new BookReaderImpl();
        reader.addBook(new Book("Author1", "Title1"));
        checkResult(false, reader.markBookAsUnread(new Book("Author2", "Title2")),"shouldNotMarkNonexistentBookAsUnreadTestReturnFalse");
    }

    private static void shouldNotMarkNonexistentBookAsUnreadTestUpdateDB() {
        totalRun++;
        Book book = new Book("Author1", "Title1");
        book.setRead(true);
        BookReaderImpl reader = new BookReaderImpl();
        reader.addBook(book);
        reader.markBookAsUnread(new Book("Author2", "Title2"));
        checkResult(true,  reader.books[0].isRead(),"shouldNotMarkNonexistentBookAsUnreadTestUpdateDB");
    }

    private static void shouldProvideReadBooksListTest() {
        totalRun++;
        BookReaderImpl reader = new BookReaderImpl();
        reader.addBook(new Book("Author1", "Title1"));
        reader.addBook(new Book("Author2", "Title2"));
        reader.addBook(new Book("Author3", "Title3"));
        reader.addBook(new Book("Author4", "Title4"));
        reader.addBook(new Book("Author5", "Title5"));
        reader.books[2].setRead(true);
        reader.books[4].setRead(true);
        String[] expected = {"Title3 [Author3]", "Title5 [Author5]"};
        checkResult(expected, reader.getReadBooksList(), "shouldProvideReadBooksListTest");
    }

    private static void shouldProvideUnreadBooksListTest() {
        totalRun++;
        BookReaderImpl reader = new BookReaderImpl();
        reader.addBook(new Book("Author1", "Title1"));
        reader.addBook(new Book("Author2", "Title2"));
        reader.addBook(new Book("Author3", "Title3"));
        reader.addBook(new Book("Author4", "Title4"));
        reader.addBook(new Book("Author5", "Title5"));
        reader.books[2].setRead(true);
        reader.books[4].setRead(true);
        String[] expected = {"Title1 [Author1]", "Title2 [Author2]", "Title4 [Author4]"};
        checkResult(expected, reader.getUnreadBooksList(), "shouldProvideUnreadBooksListTest");
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

    private static void checkResult(String[] expected, String[] actual, String testName) {
        if (arraysAreEqual(expected, actual)) {
            System.out.println(TEXT_GREEN + testName + " - passed" + TEXT_RESET);
            totalPassed++;
        } else {
            System.out.println(TEXT_RED + testName + " - failed");
            System.out.println("Expected: " + getArrayAsString(expected));
            System.out.println("Actual:   " + getArrayAsString(actual) + TEXT_RESET);
            totalFailed++;
        }
    }

    private static void checkResult(Book expected, Book actual, String testName) {
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

    private static void checkResult(Book[] expected, Book[] actual, String testName) {
        if (arraysAreEqual(expected, actual)) {
            System.out.println(TEXT_GREEN + testName + " - passed" + TEXT_RESET);
            totalPassed++;
        } else {
            System.out.println(TEXT_RED + testName + " - failed");
            System.out.println("Expected: " + getArrayAsString(expected));
            System.out.println("Actual:   " + getArrayAsString(actual) + TEXT_RESET);
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

    private static Book clone(Book origin) {
        if (origin == null) {
            return null;
        }
        Book result = new Book(origin.getAuthor(), origin.getTitle());
        result.setRead(origin.isRead());
        return result;
    }

    private static boolean arraysAreEqual(String[] arr1, String[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1 == null || arr2 == null) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean arraysAreEqual(Book[] arr1, Book[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1 == null || arr2 == null) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    private static String getArrayAsString(String[] arr) {
        if (arr == null || arr.length == 0) {
            return "Array is empty";
        }
        String result = "[ ";
        for (String str : arr) {
            result += (str + "; ");
        }
        return result + "]";
    }

    private static String getArrayAsString(Book[] arr) {
        if (arr == null || arr.length == 0) {
            return "Array is empty";
        }
        String result = "[ ";
        for (Book book : arr) {
            result += (book.toString() + "; ");
        }
        return result + "]";
    }

}
