package com.example.clientv22.service;

import com.example.clientv22.MainApplication;
import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Getter
public class ClientProperties {
    private  final Properties properties = new Properties();

    private String allBook;
    private String fineByIdBook;
    private String saveBook;
    private String updateBook;
    private String fineByAuthorInBook;
    private String fineByTitleInBook;
    private String allCity;
    private String fineByIdCity;
    private String saveCity;
    private String updateCity;
    private String allGenre;
    private String fineByIdGenre;
    private String saveGenre;
    private String updateGenre;
    private String allPublisher;
    private String fineByIdPublisher;
    private String savePublisher;
    private String updatePublisher;
    private String deleteBook;
    private String deleteCity;
    private String deleteGenre;
    private String deletePublisher;

    private String fineByIdAuthor;
    private String allAuthor;
    private String saveAuthor;
    private String updateAuthor;
    private String deleteAuthor;

    public ClientProperties() {
        try (InputStream input = MainApplication.class.getClassLoader().getResourceAsStream("config.propeties")) {
            System.out.println(input);
            properties.load(input);//загрузка свойства из файла
            allBook = properties.getProperty("book.getAll");
            fineByIdBook = properties.getProperty("book.fineById");
            saveBook = properties.getProperty("book.save");
            updateBook = properties.getProperty("book.update");
            fineByAuthorInBook = properties.getProperty("book.findByAuthor");
            fineByTitleInBook = properties.getProperty("book.findByTitle");
            allCity = properties.getProperty("city.getAll");
            saveCity = properties.getProperty("city.save");
            fineByIdCity = properties.getProperty("city.fineById");
            updateCity = properties.getProperty("city.update");
            allGenre = properties.getProperty("genre.getAll");
            fineByIdGenre = properties.getProperty("genre.fineById");
            saveGenre = properties.getProperty("genre.save");
            updateGenre = properties.getProperty("genre.update");
            allPublisher = properties.getProperty("publisher.getAll");
            fineByIdPublisher = properties.getProperty("publisher.fineById");
            savePublisher = properties.getProperty("publisher.save");
            updatePublisher = properties.getProperty("publisher.update");
            deleteBook = properties.getProperty("book.del");
            deleteCity = properties.getProperty("city.del");
            deleteGenre = properties.getProperty("genre.del");
            deletePublisher = properties.getProperty("publisher.del");
    allAuthor = properties.getProperty("author.getAll");
    saveAuthor = properties.getProperty("author.save");
    updateAuthor = properties.getProperty("author.update");
    deleteAuthor = properties.getProperty("author.del");
fineByIdAuthor = properties.getProperty("author.fineById");
        } catch (IOException e) {
            e.printStackTrace();//обробатываеь исключение в слуучае ошибки
        }

    }
}
