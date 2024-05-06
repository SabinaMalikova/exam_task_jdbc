package peaksoft.dao;

import peaksoft.enums.Genre;
import peaksoft.model.Book;

import java.util.List;

public interface BookDao {

    String createEnumColor();
    String createTable();
    String insertBook(Book newBook);
    List<Book> getBooksByGenre(Genre genre);
    String updateBook(Long bookId, Book newBook);
    String deleteBook(Long id);
    List<Book> getBooksGroupedByAuthor();
    List<Book> getBooksSortedByPublicationDate(String ascOrDesc);
}
