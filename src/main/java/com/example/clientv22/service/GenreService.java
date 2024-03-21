package com.example.clientv22.service;

import com.example.clientv22.Entity.AuthorEntity;
import com.example.clientv22.Entity.CityEntity;
import com.example.clientv22.Entity.GenreEntity;
import com.example.clientv22.Response.BaseResponse;
import com.example.clientv22.Response.DataResponse;
import com.example.clientv22.Response.ListResponse;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

import java.lang.reflect.Type;

public class GenreService {

    @Getter
    private ObservableList<GenreEntity> data = FXCollections.observableArrayList();
    private final HttpService http = new HttpService();
    JsonService service = new JsonService();
    ClientProperties prop = new ClientProperties();
    private Type dataType = new TypeToken<DataResponse<GenreEntity>>() {

    }.getType(); //фиксируем тип DataResponce<BookEntity>

    private Type listType = new TypeToken<ListResponse<GenreEntity>>() {

    }.getType(); //фиксируем тип DataResponce<BookEntity>

    public void getAll() {
        ListResponse<GenreEntity> data = new ListResponse<>();
        data = service.getObject(http.get(prop.getAllGenre()), listType);
        if (data.isSuccess()) {
            this.data.addAll(data.getData());
            this.data.forEach(System.out::println);
        } else {
            throw new RuntimeException(data.getMessage());
        }
    }

    public void add(GenreEntity data) {
        String temp = http.post(prop.getSaveGenre(), service.getJson(data));
        DataResponse<GenreEntity> respose = service.getObject(temp, dataType);
        if (respose.isSuccess()) {
            this.data.add(respose.getData());

        } else {
            throw new RuntimeException(respose.getMessage());
        }
    }


    public void update(GenreEntity data) {
        String temp = http.put(prop.getUpdateGenre(), service.getJson(data));
        DataResponse<GenreEntity> respose = service.getObject(temp, dataType);
        if (respose.isSuccess()) {
            this.data.add(respose.getData());

        } else {
            throw new RuntimeException(respose.getMessage());
        }
    }

    public void delete(GenreEntity data) {
        String temp = http.delete(prop.getDeleteGenre(), data.getId());
        BaseResponse response = service.getObject(temp, BaseResponse.class);
        if (response.isSuccess()) {
            this.data.remove(data);
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }


    public void findById(GenreEntity data) {
        String temp = http.get(prop.getFineByIdGenre() + data.getId());
        DataResponse<GenreEntity> respose = service.getObject(temp, dataType);
        if (respose.isSuccess()) {
            this.data.add(respose.getData());

        } else {
            throw new RuntimeException(respose.getMessage());
        }

    }
}