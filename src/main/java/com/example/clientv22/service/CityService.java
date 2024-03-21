package com.example.clientv22.service;

import com.example.clientv22.Entity.AuthorEntity;
import com.example.clientv22.Entity.CityEntity;
import com.example.clientv22.Response.BaseResponse;
import com.example.clientv22.Response.DataResponse;
import com.example.clientv22.Response.ListResponse;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

import java.lang.reflect.Type;

public class CityService {

    @Getter
    private ObservableList<CityEntity> data = FXCollections.observableArrayList();
    private final HttpService http = new HttpService();
    JsonService service = new JsonService();
    ClientProperties prop = new ClientProperties();
    private Type dataType = new TypeToken<DataResponse<CityEntity>>() {

    }.getType(); //фиксируем тип DataResponce<BookEntity>

    private Type listType = new TypeToken<ListResponse<CityEntity>>() {

    }.getType(); //фиксируем тип DataResponce<BookEntity>

    public void getAll() {
        ListResponse<CityEntity> data = new ListResponse<>();
        data = service.getObject(http.get(prop.getAllCity()), listType);
        if (data.isSuccess()) {
            this.data.addAll(data.getData());
            this.data.forEach(System.out::println);
        } else {
            throw new RuntimeException(data.getMessage());
        }
    }

    public void add(CityEntity data) {
        String temp = http.post(prop.getSaveCity(), service.getJson(data));
        DataResponse<CityEntity> respose = service.getObject(temp, dataType);
        if (respose.isSuccess()) {
            this.data.add(respose.getData());

        } else {
            throw new RuntimeException(respose.getMessage());
        }
    }


    public void update(CityEntity data) {
        String temp = http.put(prop.getUpdateCity(), service.getJson(data));
        DataResponse<CityEntity> respose = service.getObject(temp, dataType);
        if (respose.isSuccess()) {
            this.data.add(respose.getData());

        } else {
            throw new RuntimeException(respose.getMessage());
        }
    }

    public void delete(CityEntity data) {
        String temp = http.delete(prop.getDeleteCity(), data.getId());
        BaseResponse response = service.getObject(temp, BaseResponse.class);
        if (response.isSuccess()) {
            this.data.remove(data);
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }


    public void findById(CityEntity data) {
        String temp = http.get(prop.getFineByIdCity() + data.getId());
        DataResponse<CityEntity> respose = service.getObject(temp, dataType);
        if (respose.isSuccess()) {
            this.data.add(respose.getData());

        } else {
            throw new RuntimeException(respose.getMessage());
        }

    }
}
