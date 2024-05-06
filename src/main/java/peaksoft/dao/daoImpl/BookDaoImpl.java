package peaksoft.dao.daoImpl;

import peaksoft.config.JDBCconfig;
import peaksoft.dao.BookDao;
import peaksoft.enums.Genre;
import peaksoft.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private final Connection connection = JDBCconfig.getConnection();

    @Override
    public String createEnumColor() {
        String sql = """
                create type colors as enum ('pink','black','white','blue','yellow')
                """;
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            return "successfully created";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    @Override
    public String createTable() {
        String sql = """
                create table if not exists books(
                id serial primary key,
                title varchar,
                author varchar,
                publishedDate date,
                Genre varchar
                )
                """;
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            return "successfully created";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    @Override
    public String insertBook(Book newBook) {
        String sql = "insert into books (title, author, publisheddate, genre) values (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newBook.getTitle());
            preparedStatement.setString(2, newBook.getAuthor());
            preparedStatement.setDate(3, Date.valueOf(newBook.getPublishedDate()));
            preparedStatement.setString(4, newBook.getGenre().toString());
            preparedStatement.executeUpdate();
            return "Книга успешно добавлена!";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Ошибка при добавлении книги: " + e.getMessage();
        }
    }

    @Override
    public List<Book> getBooksByGenre(Genre genre) {
        List<Book> books = new ArrayList<>();
        String sql = "select * from books where genre = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, genre.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublishedDate(resultSet.getDate("publisheddate").toLocalDate());
                book.setGenre(Genre.valueOf(resultSet.getString("genre")));
                books.add(book);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return books;
    }

    @Override
    public String updateBook(Long bookId, Book newBook) {
        String sql = """
                update books set title = ?, author = ?, publisheddate = ?, genre = ? where id = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newBook.getTitle());
            preparedStatement.setString(2, newBook.getAuthor());
            preparedStatement.setDate(3, Date.valueOf(newBook.getPublishedDate()));
            preparedStatement.setString(4, newBook.getGenre().toString());
            preparedStatement.setLong(5, bookId);
            preparedStatement.executeUpdate();
            return "successfully updated";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    @Override
    public String deleteBook(Long id) {
        String sql = """
                delete from books where id = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            return "successfully deleted";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    @Override
    public List<Book> getBooksGroupedByAuthor() {
        List<Book> books = new ArrayList<>();
        String sql = """
                select * from books order by author  
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublishedDate(resultSet.getDate("publisheddate").toLocalDate());
                book.setGenre(Genre.valueOf(resultSet.getString("genre")));
                books.add(book);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return books;
    }

    @Override
    public List<Book> getBooksSortedByPublicationDate(String ascOrDesc) {
        List<Book> books = new ArrayList<>();
        String sql = "select * from books order by publisheddate " + ascOrDesc;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublishedDate(resultSet.getDate("publisheddate").toLocalDate());
                book.setGenre(Genre.valueOf(resultSet.getString("genre")));
                books.add(book);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return books;
    }

}
