package peaksoft;

import peaksoft.enums.Genre;
import peaksoft.model.Book;
import peaksoft.service.BookService;
import peaksoft.service.serviceImpl.BookServiceImpl;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BookService bookService = new BookServiceImpl();

//        System.out.println(bookService.createEnumColor());

//        System.out.println(bookService.createTable());

//        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", LocalDate.of(1960, 6, 11), Genre.FICTION);
//        Book book2 = new Book("1984", "George Orwell", LocalDate.of(1949, 7, 8), Genre.THRILLER);
//        Book book3 = new Book("Pride and Prejudice", "Jane Austen", LocalDate.of(1813, 1, 28), Genre.ROMANCE);
//        Book book4 = new Book("The Great Gatsby", "F. Scott Fitzgerald", LocalDate.of(1925,4, 10), Genre.ROMANCE);
//        Book book5 = new Book("The Catcher in the Rye", "J.D. Salinger", LocalDate.of(1951,5, 16), Genre.FICTION);
//        Book book6 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", LocalDate.of(1997, 2, 26), Genre.FANTASY);
//        System.out.println(bookService.insertBook(book1));
//        System.out.println(bookService.insertBook(book2));
//        System.out.println(bookService.insertBook(book3));
//        System.out.println(bookService.insertBook(book4));
//        System.out.println(bookService.insertBook(book5));
//        System.out.println(bookService.insertBook(book6));

//        System.out.println(bookService.getBooksByGenre(Genre.FICTION));

//        Book book7 = new Book("The Hobbit", "J.R.R. Tolkien", LocalDate.of(1937, 9, 21), Genre.FANTASY);
//        System.out.println(bookService.updateBook(2L, book7));

//        System.out.println(bookService.deleteBook(2L));

//        System.out.println(bookService.getBooksGroupedByAuthor());

//        System.out.println(bookService.getBooksSortedByPublicationDate("asc"));
//        System.out.println(bookService.getBooksSortedByPublicationDate("desc"));



    }
}
