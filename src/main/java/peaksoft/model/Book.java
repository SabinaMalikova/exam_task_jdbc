package peaksoft.model;

import lombok.*;
import peaksoft.enums.Genre;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Book {
    private Long id;
    private String title;
    private String author;
    private LocalDate publishedDate;
    private Genre genre;

    public Book(String title, String author, LocalDate publishedDate, Genre genre) {
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "\nBook{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishedDate=" + publishedDate +
                ", genre=" + genre +
                '}';
    }
}
