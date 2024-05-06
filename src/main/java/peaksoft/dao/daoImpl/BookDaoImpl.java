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
        try(Statement statement = connection.createStatement()) {
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
                genre Genre
                )
                """;
        try(Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            return "successfully created";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    @Override
    public String insertBook(Book newBook) {
        String sql = """
                insert into books (title, author, published_date, genre)
                values(?,?,?,?,?);
                """;
        try(Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            return "successfully added!";
        }catch (SQLException e){
            return e.getMessage();
        }
    }

    @Override
    public List<Book> getBooksByGenre(Genre genre) {
        List<Book> books = new ArrayList<>();
        String sql = """
                select * from Books group by genre 
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublishedDate(resultSet.getDate("published_date").toLocalDate());
                book.setGenre(Genre.valueOf(resultSet.getString("genre")));
                books.add(book);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return books;
    }

    @Override
    public String updateBook(Long bookId, Book newBook) {
        String sql = """
                update books set title = ?, author = ?, published_date = ?, genre = ? where id = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newBook.getTitle());
            preparedStatement.setString(2, newBook.getAuthor());
            preparedStatement.setDate(3, Date.valueOf(newBook.getPublishedDate()));
            preparedStatement.setString(4, newBook.getGenre().toString());
            preparedStatement.setLong(5, bookId);
            preparedStatement.executeUpdate();
            return "successfully updated";
        }catch (SQLException e){
            return e.getMessage();
        }
    }

    @Override
    public String deleteBook(Long id) {
        String sql = """
                delete from books where id = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
            return "successfully deleted";
        }catch (SQLException e){
            return e.getMessage();
        }
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
