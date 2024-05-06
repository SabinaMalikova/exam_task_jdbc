package peaksoft.model;

import lombok.*;
import peaksoft.enums.Genre;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    private Long id;
    private String title;
    private String author;
    private LocalDate publishedDate;
    private Genre genre;
}
