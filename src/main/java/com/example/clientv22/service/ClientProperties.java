package com.example.clientv22.service;

import com.example.clientv22.MainApplication;
import lombok.Getter;

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
    private String  saveGenre;
    private String updateGenre;
    private String allPublisher;
    private String fineByIdPublisher;
    private String savePublisher;
    private String updatePublisher;
    private String deleteBook;
    private String deleteCity;
    private String DeleteGenre;
    private String deletePublisher;

    public ClientProperties(){
        try (InputStream input = MainApplication.class.getClassLoader().getResourceAsStream("config.propeties")){
            System.out.println(input);
            properties.load(input);//загрузка свойства из файла
            allBook = properties.getProperty("book.getAll");
            fineByIdBook = properties.getProperty("book.fineById");
            saveBook = properties.getProperty("book.save");
            updateBook = properties.getProperty("book.update");


        }


}
