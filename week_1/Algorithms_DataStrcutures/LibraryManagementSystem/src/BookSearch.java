public class BookSearch {
    public Book linearSearchByTitle(Book[] books, String targetTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(targetTitle)) {
                return book;
            }
        }
        return null;
    }

    public Book binarySearchByTitle(Book[] sortedBooks, String targetTitle) {
        int left = 0;
        int right = sortedBooks.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = sortedBooks[mid].getTitle().compareToIgnoreCase(targetTitle);

            if (comparison == 0) {
                return sortedBooks[mid];
            }
            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}
