package com.example.clientv22.service;

import com.example.clientv22.Entity.AuthorEntity;
import com.example.clientv22.Entity.BookEntity;
import com.example.clientv22.Response.BaseResponse;
import com.example.clientv22.Response.DataResponse;
import com.example.clientv22.Response.ListResponse;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

import java.lang.reflect.Type;

public class AuthorService {
    @Getter
    private ObservableList<AuthorEntity> data = FXCollections.observableArrayList();
    private final HttpService http = new HttpService();
    JsonService service = new JsonService();
    ClientProperties prop = new ClientProperties();
    private Type dataType = new TypeToken<DataResponse<AuthorEntity>>() {

    }.getType(); //фиксируем тип DataResponce<BookEntity>

    private Type listType = new TypeToken<ListResponse<AuthorEntity>>() {

    }.getType(); //фиксируем тип DataResponce<BookEntity>

    public void getAll(){
        ListResponse<AuthorEntity> data=new ListResponse<>();
        data = service.getObject(http.get(prop.getAllAuthor()),listType);
        if (data.isSuccess()){
            this.data.addAll(data.getData());
            this.data.forEach(System.out::println);
        } else {
            throw new RuntimeException(data.getMessage());
        }
    }

    public void add(AuthorEntity data){
        String temp = http.post(prop.getSaveAuthor(), service.getJson(data));
        DataResponse<AuthorEntity> respose = service.getObject(temp, dataType);
        if (respose.isSuccess()){
            this.data.add(respose.getData());

        }else{
            throw new RuntimeException(respose.getMessage());
        }
    }


    public void update(AuthorEntity data){
        String temp = http.put(prop.getUpdateAuthor(), service.getJson(data));
        DataResponse<AuthorEntity> respose = service.getObject(temp, dataType);
        if (respose.isSuccess()){
            this.data.add(respose.getData());

        }else{
            throw new RuntimeException(respose.getMessage());
        }
    }

    public void delete(AuthorEntity data){
        String temp = http.delete(prop.getDeleteAuthor(), data.getId());
        BaseResponse response = service.getObject(temp,BaseResponse.class);
        if (response.isSuccess()){
            this.data.remove(data);
        }else {
            throw new RuntimeException(response.getMessage());
        }
    }


    public void findById(AuthorEntity data){
        String temp = http.get(prop.getFineByIdAuthor() + data.getId());
        DataResponse<AuthorEntity> respose = service.getObject(temp, dataType);
        if (respose.isSuccess()){
            this.data.add(respose.getData());

        }else{
            throw new RuntimeException(respose.getMessage());
        }
    }




}

