package peaksoft.service.serviceImpl;

import peaksoft.dao.BookDao;
import peaksoft.dao.daoImpl.BookDaoImpl;
import peaksoft.enums.Genre;
import peaksoft.model.Book;
import peaksoft.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();
    @Override
    public String createEnumColor() {
        return bookDao.createEnumColor();
    }

    @Override
    public String createTable() {
        return bookDao.createTable();
    }

    @Override
    public String insertBook(Book newBook) {
        return bookDao.insertBook(newBook);
    }

    @Override
    public List<Book> getBooksByGenre(Genre genre) {
        return bookDao.getBooksByGenre(genre);
    }

    @Override
    public String updateBook(Long bookId, Book newBook) {
        return bookDao.updateBook(bookId,newBook);
    }

    @Override
    public String deleteBook(Long id) {
        return bookDao.deleteBook(id);
    }

    @Override
    public List<Book> getBooksGroupedByAuthor() {
        return bookDao.getBooksGroupedByAuthor();
    }

    @Override
    public List<Book> getBooksSortedByPublicationDate(String ascOrDesc) {
        return bookDao.getBooksSortedByPublicationDate(ascOrDesc);
    }
}
