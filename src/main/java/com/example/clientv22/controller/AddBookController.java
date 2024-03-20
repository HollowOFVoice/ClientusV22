package com.example.clientv22.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddBookController {

    @FXML
    private ComboBox<?> ComboboxAuthor;

    @FXML
    private ComboBox<?> ComboboxGenre;

    @FXML
    private ComboBox<?> ComboboxPublisher;

    @FXML
    private Button addBook;

    @FXML
    private Button cancelBook;

    @FXML
    private TextField textTitle;

    @FXML
    private TextField textYear;

}
