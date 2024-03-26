package com.example.clientv22.controller;


import com.example.clientv22.Entity.BookEntity;
import com.example.clientv22.MainApplication;
import com.example.clientv22.service.BookService;
import com.example.clientv22.service.HttpService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {


    @FXML
    private TableView<BookEntity> bookTable;

    @FXML
    private TableColumn<BookEntity, String> columnAuthor;

    @FXML
    private TableColumn<BookEntity, String> columnGenre;

    @FXML
    private TableColumn<BookEntity, String> columnNumber;

    @FXML
    private TableColumn<BookEntity, String> columnPublisher;

    @FXML
    private TableColumn<BookEntity, String> columnTitle;
    @FXML
    private Button hehe;
     BookService service = new BookService();


    @FXML
    void addBookAction(ActionEvent event) {

    }

    @FXML
    void addOrChangeAuthorAction(ActionEvent event) {
        MainApplication.showAuthorDialog();
    }

    @FXML
    void addOrChangeCityAction(ActionEvent event) {

    }

    @FXML
    void addOrChangeGenreAction(ActionEvent event) {

    }

    @FXML
    void addOrChangePublisherAction(ActionEvent event) {
        MainApplication.showPublisherDialog();

    }

    @FXML
    void changeBookAction(ActionEvent event) {

    }
    @FXML
    void meme(ActionEvent event){
       MainApplication.videoDialog();
  }
    @FXML
    void closeAction(ActionEvent event) {

    }

    @FXML
    void deleteAuthorAction(ActionEvent event) {

    }

    @FXML
    void deleteBookAction(ActionEvent event) {
        HttpService service = new HttpService();
        System.out.println(service.get("http://localhost:2825/api/v1/books/all"));
    }

    @FXML
    void deleteCityAction(ActionEvent event) {

    }

    @FXML
    void deleteGenreAction(ActionEvent event) {

    }

    @FXML
    void deletePublisherAction(ActionEvent event) {

    }

    @FXML
    private void initialize(){
        //получаем все книги с сервера
        service.getAll();
        //связываем поля таблицы со столбцами
        columnAuthor.setCellValueFactory(new PropertyValueFactory<BookEntity, String>("author"));
        columnGenre.setCellValueFactory(new PropertyValueFactory<BookEntity, String>("genre"));
        columnNumber.setCellValueFactory(new PropertyValueFactory<BookEntity, String>("year"));
        columnTitle.setCellValueFactory(new PropertyValueFactory<BookEntity, String>("bookName"));
        columnPublisher.setCellValueFactory(new PropertyValueFactory<BookEntity, String>("publisher"));
        bookTable.setItems(service.getData());
    }

}

