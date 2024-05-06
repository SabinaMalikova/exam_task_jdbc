package peaksoft.service.serviceImpl;

import peaksoft.enums.Genre;
import peaksoft.model.Book;
import peaksoft.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public String createEnumColor() {
        return null;
    }

    @Override
    public String createTable() {
        return null;
    }

    @Override
    public String insertBook(Book newBook) {
        return null;
    }

    @Override
    public List<Book> getBooksByGenre(Genre genre) {
        return null;
    }

    @Override
    public String updateBook(Long bookId, Book newBook) {
        return null;
    }

    @Override
    public String deleteBook(Long id) {
        return null;
    }

    @Override
    public List<Book> getBooksGroupedByAuthor() {
        return null;
    }

    @Override
    public List<Book> getBooksSortedByPublicationDate(String ascOrDesc) {
        return null;
    }
}
