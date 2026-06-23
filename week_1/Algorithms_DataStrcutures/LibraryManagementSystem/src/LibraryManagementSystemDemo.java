public class LibraryManagementSystemDemo {
    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "Java Basics", "John"),
            new Book(2, "Data Structures", "Mary"),
            new Book(3, "Algorithms", "Alex")
        };

        Book[] sortedBooks = {
            new Book(3, "Algorithms", "Alex"),
            new Book(2, "Data Structures", "Mary"),
            new Book(1, "Java Basics", "John")
        };

        BookSearch search = new BookSearch();
        System.out.println(search.linearSearchByTitle(books, "Data Structures"));
        System.out.println(search.binarySearchByTitle(sortedBooks, "Java Basics"));
    }
}
