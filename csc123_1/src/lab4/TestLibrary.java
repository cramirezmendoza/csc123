package lab4;

import java.util.List;

public class TestLibrary {

    public static void main(String[] args) {
        Library library = new Library("CSUDH", "Carson", "California");
        
        Book book1 = new Book("CSC", "Ramirez", 90, 903456);
        Book book2 = new Book("Java", "Eclipse", 78, 789012);
        
        library.addBook(book1);
        library.addBook(book2);
        
        
        

        // Retrieve and print all books in the library
        List<Book> libraryBooks = library.getBooks();
        if (!libraryBooks.isEmpty()) {
            System.out.println("Books in the Library:");
            for (Book book : libraryBooks) {
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Pages: " + book.getPages());
                System.out.println("ISBN: " + book.getISBN());
                System.out.println("Number of Books in the Library: " + library.getSize());

                System.out.println();
            }
        } else {
            System.out.println("Library does not have any books.");
        }
    }
}

