package lesson_9.Book;

class BookReaderImpl implements BookReader {
    Book[] books = new Book[0];

    @Override
    public boolean addBook(Book book) {
        if (!isValidBook(book)) {
            return false;
        }
        if (isDuplicateBook(book)) {
            return false;
        }
        Book[] tmp = new Book[books.length + 1];
        for (int i = 0; i < books.length; i++) {
            tmp[i] = books[i];
        }
        books = tmp;
        books[books.length - 1] = book;
        return true;
    }

    @Override
    public boolean isDuplicateBook(Book book) {
        if (book == null) {
            return false;
        }
        for (Book b : books) {
            if (b.equals(book)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isValidBook(Book book) {
        if (book == null) {
            return false;
        }
        return !book.getAuthor().isBlank() && !book.getTitle().isBlank();
    }

    @Override
    public boolean deleteBook(Book book) {
        if (!isDuplicateBook(book)) {
            return false;
        }
        Book[] tmp = new Book[books.length - 1];
        int j = 0;
        boolean succeed = false;
        for (int i = 0; i < books.length; i++) {
            if (books[i].equals(book)) {
                succeed = true;
                continue;
            }
            tmp[j] = books[i];
            j++;
        }
        if (succeed) {
            books = tmp;
        }
        return succeed;
    }

    @Override
    public String[] getAllBooksList() {
        String[] list = new String[books.length];
        int i = 0;
        for (Book book : books) {
            list[i] = book.getTitle() + " [" + book.getAuthor() + "]";
            i++;
        }
        return list;
    }

    @Override
    public Book[] getBooksByAuthor(String author, boolean strictSearch) {
        Book[] result = new Book[books.length];
        int i = 0;
        boolean matched;
        for (Book book : books) {
            matched = false;
            if (book.getAuthor().equals(author)) {
                matched = true;
            } else {
                if (!strictSearch && isStartedWithLetters(book.getAuthor(), author)) {
                    matched = true;
                }
            }
            if (matched) {
                result[i] = book;
                i++;
            }
        }
        return trimArray(result, i);
    }

    @Override
    public Book[] getBooksByTitle(String title, boolean strictSearch) {
        Book[] result = new Book[books.length];
        int i = 0;
        boolean matched;
        for (Book book : books) {
            matched = false;
            if (book.getTitle().equals(title)) {
                matched = true;
            } else {
                if (!strictSearch && isStartedWithLetters(book.getTitle(), title)) {
                    matched = true;
                }
            }
            if (matched) {
                result[i] = book;
                i++;
            }
        }
        return trimArray(result, i);
    }

    @Override
    public boolean markBookAsRead(Book book) {
        if (book == null) {
            return false;
        }
        for (int i = 0; i < books.length; i++) {
            if (books[i].equals(book)) {
                books[i].setRead(true);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean markBookAsUnread(Book book) {
        if (book == null) {
            return false;
        }
        for (int i = 0; i < books.length; i++) {
            if (books[i].equals(book)) {
                books[i].setRead(false);
                return true;
            }
        }
        return false;
    }

    @Override
    public String[] getReadBooksList() {
        String[] list = new String[books.length];
        int i = 0;
        for (Book book : books) {
            if (book.isRead()) {
                list[i] = book.getTitle() + " [" + book.getAuthor() + "]";
                i++;
            }
        }
        return trimArray(list, i);
    }

    @Override
    public String[] getUnreadBooksList() {
        String[] list = new String[books.length];
        int i = 0;
        for (Book book : books) {
            if (!book.isRead()) {
                list[i] = book.getTitle() + " [" + book.getAuthor() + "]";
                i++;
            }
        }
        return trimArray(list, i);
    }

    private String[] trimArray(String[] arr, int fromIndex) {
        String[] result = new String[fromIndex];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    private Book[] trimArray(Book[] arr, int fromIndex) {
        Book[] result = new Book[fromIndex];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    private boolean isStartedWithLetters(String checkedString, String startedWith) {
        char[] checkedStringChars = checkedString.toCharArray();
        char[] startedWithChars = startedWith.toCharArray();
        for (int i = 0; i < startedWithChars.length; i++) {
            if (startedWithChars[i] != checkedStringChars[i]) {
                return false;
            }
        }
        return true;
    }
}
