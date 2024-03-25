package com.example.clientv22.controller;

import com.example.clientv22.Entity.AuthorEntity;
import com.example.clientv22.Response.DataResponse;
import com.example.clientv22.service.AuthorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;



public class AddAuthorViewController {
    private final AuthorService service = new AuthorService();
    private boolean addFlag = true;

    @FXML
    private TextField textLastname;

    @FXML
    private Button addAuthor;

    @FXML
    private Button cancelAuthorAdd;

    @FXML
    private ListView<AuthorEntity> dataList;

    @FXML
    private Button deleteAuthor;

    @FXML
    private TextField textName;

    @FXML
    private TextField textSurname;
    @FXML private void initialize(){
        service.getAll();
        dataList.setItems(service.getData());
    }
    @FXML
    void addAction(ActionEvent event){
        AuthorEntity author = new AuthorEntity();
        author.setLastname(textLastname.getText());
        author.setName(textName.getText());
        author.setSurname(textSurname.getText());
        if (addFlag){
            service.add(author);
        }else{
            author.setId(getSelectionElement().getId());
            service.update(author,getSelectionElement());
        }
       textLastname.clear();
        textName.clear();
        textSurname.clear();
    }
@FXML
public void cancelAction(ActionEvent event){
        addFlag = true;
}
    @FXML
 void onMouseClickDataList(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)){
            if (event.getClickCount() == 2){
                addFlag = false;
                AuthorEntity temp = getSelectionElement();
                textSurname.setText(temp.getSurname());
                textName.setText(temp.getName());
                textLastname.setText(temp.getLastname());
            }
        }
    }

    private AuthorEntity getSelectionElement(){
        AuthorEntity temp = dataList.getSelectionModel().getSelectedItem();
        return temp;
    }



}



