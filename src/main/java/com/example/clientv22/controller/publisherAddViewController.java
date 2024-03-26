package com.example.clientv22.controller;

import com.example.clientv22.Entity.AuthorEntity;
import com.example.clientv22.Entity.CityEntity;
import com.example.clientv22.Entity.PublisherEntity;
import com.example.clientv22.service.CityService;
import com.example.clientv22.service.PublisherService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class publisherAddViewController {
    private final CityService cityService = new CityService();
    private final PublisherService publisherService = new PublisherService();
    private boolean addFlag = true;

    @FXML
    private ComboBox<CityEntity> comboBoxCity;

    @FXML
    private Button addPublisher;

    @FXML
    private Button cancelPublisher;

    @FXML
    private ListView<PublisherEntity> dataList;

    @FXML
    private Button deletePublisher;

    @FXML
    private TextField textTitle;

    @FXML
    private void initialize(){
        cityService.getAll();
        publisherService.getAll();
        dataList.setItems(publisherService.getData());
        comboBoxCity.setItems(cityService.getData());
    }


    @FXML
    void ClicktoList(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)){
            if (event.getClickCount() == 2){
                addFlag = false;
                PublisherEntity temp = getSelectionElement();
                textTitle.setText(temp.getTitle());
               comboBoxCity.getSelectionModel().select(temp.getCity());
            }
        }
    }
@FXML
    void deleteAction(ActionEvent event){
        publisherService.delete(getSelectionElement());
}

    @FXML
    void addAction(ActionEvent event){
        PublisherEntity publisher = new PublisherEntity();
        publisher.setTitle(textTitle.getText());
        publisher.setCity(comboBoxCity.getSelectionModel().getSelectedItem());
        if (addFlag){
            publisherService.add(publisher);
        }else{
            publisher.setId(getSelectionElement().getId());
            publisherService.update(publisher , getSelectionElement());
        }
        textTitle.clear();

    }
    @FXML
    public void cancelAction(ActionEvent event){
        addFlag = true;
    }
    private PublisherEntity getSelectionElement(){
        PublisherEntity temp = dataList.getSelectionModel().getSelectedItem();
        return temp;
    }

}

