package lesson_9.Book;

interface BookReader {
    boolean addBook(Book book);

    boolean isDuplicateBook(Book book);

    boolean isValidBook(Book book);

    boolean deleteBook(Book book);

    String[] getAllBooksList();

    Book[] getBooksByAuthor(String author, boolean strictSearch);

    Book[] getBooksByTitle(String title, boolean strictSearch);

    boolean markBookAsRead(Book book);

    boolean markBookAsUnread(Book book);

    String[] getReadBooksList();

    String[] getUnreadBooksList();
}
