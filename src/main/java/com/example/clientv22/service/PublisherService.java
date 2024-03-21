package com.example.clientv22.service;

import com.example.clientv22.Entity.GenreEntity;
import com.example.clientv22.Entity.PublisherEntity;
import com.example.clientv22.Response.BaseResponse;
import com.example.clientv22.Response.DataResponse;
import com.example.clientv22.Response.ListResponse;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

import java.lang.reflect.Type;

public class PublisherService{

    @Getter
    private ObservableList<PublisherEntity> data = FXCollections.observableArrayList();
    private final HttpService http = new HttpService();
    JsonService service = new JsonService();
    ClientProperties prop = new ClientProperties();
    private Type dataType = new TypeToken<DataResponse<PublisherEntity>>() {

    }.getType(); //фиксируем тип DataResponce<BookEntity>

    private Type listType = new TypeToken<ListResponse<PublisherEntity>>() {

    }.getType(); //фиксируем тип DataResponce<BookEntity>

    public void getAll() {
        ListResponse<PublisherEntity> data = new ListResponse<>();
        data = service.getObject(http.get(prop.getAllPublisher()), listType);
        if (data.isSuccess()) {
            this.data.addAll(data.getData());
            this.data.forEach(System.out::println);
        } else {
            throw new RuntimeException(data.getMessage());
        }
    }

    public void add(PublisherEntity data) {
        String temp = http.post(prop.getSavePublisher(), service.getJson(data));
        DataResponse<PublisherEntity> respose = service.getObject(temp, dataType);
        if (respose.isSuccess()) {
            this.data.add(respose.getData());

        } else {
            throw new RuntimeException(respose.getMessage());
        }
    }


    public void update(PublisherEntity data) {
        String temp = http.put(prop.getUpdatePublisher(), service.getJson(data));
        DataResponse<PublisherEntity> respose = service.getObject(temp, dataType);
        if (respose.isSuccess()) {
            this.data.add(respose.getData());

        } else {
            throw new RuntimeException(respose.getMessage());
        }
    }

    public void delete(PublisherEntity data) {
        String temp = http.delete(prop.getDeletePublisher(), data.getId());
        BaseResponse response = service.getObject(temp, BaseResponse.class);
        if (response.isSuccess()) {
            this.data.remove(data);
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }


    public void findById(PublisherEntity data) {
        String temp = http.get(prop.getFineByIdPublisher() + data.getId());
        DataResponse<PublisherEntity> respose = service.getObject(temp, dataType);
        if (respose.isSuccess()) {
            this.data.add(respose.getData());

        } else {
            throw new RuntimeException(respose.getMessage());
        }

    }
}