package com.example.clientv22.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BookEntity {

    private Long id;

    private String bookName;


    private AuthorEntity author;

    private PublisherEntity publisher;

    private GenreEntity genre;//:Жанр
    private String year;
}
