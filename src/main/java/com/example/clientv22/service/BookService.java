package com.example.clientv22.service;

import com.example.clientv22.Entity.BookEntity;
import com.example.clientv22.Response.BaseResponse;
import com.example.clientv22.Response.DataResponse;
import com.example.clientv22.Response.ListResponse;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

import java.lang.reflect.Type;

public class BookService {
    @Getter
    private ObservableList<BookEntity> data = FXCollections.observableArrayList();
    private  final HttpService http = new HttpService();
    JsonService service = new JsonService();
    ClientProperties prop = new ClientProperties();
    private Type dataType = new TypeToken<DataResponse<BookEntity>>(){

    }.getType(); //фиксируем тип DataResponce<BookEntity>

    private Type listType = new TypeToken<ListResponse<BookEntity>>(){

    }.getType(); //фиксируем тип DataResponce<BookEntity>

public void getAll(){
    ListResponse<BookEntity> data=new ListResponse<>();
    data = service.getObject(http.get(prop.getAllBook()),listType);
if (data.isSuccess()){
    this.data.addAll(data.getData());
    this.data.forEach(System.out::println);
} else {
   throw new RuntimeException(data.getMessage());
}
}

public void add(BookEntity data){
    String temp = http.post(prop.getSaveBook(), service.getJson(data));
    DataResponse<BookEntity> respose = service.getObject(temp, dataType);
    if (respose.isSuccess()){
        this.data.add(respose.getData());

    }else{
        throw new RuntimeException(respose.getMessage());
    }
}


    public void update(BookEntity data){
        String temp = http.put(prop.getUpdateBook(), service.getJson(data));
        DataResponse<BookEntity> respose = service.getObject(temp, dataType);
        if (respose.isSuccess()){
            this.data.add(respose.getData());

        }else{
            throw new RuntimeException(respose.getMessage());
        }
    }

    public void delete(BookEntity data){
    String temp = http.delete(prop.getDeleteBook(), data.getId());
        BaseResponse response = service.getObject(temp,BaseResponse.class);
        if (response.isSuccess()){
            this.data.remove(data);
        }else {
            throw new RuntimeException(response.getMessage());
        }
    }


    public void findById(BookEntity data){
        String temp = http.get(prop.getFineByIdBook() + data.getId());
        DataResponse<BookEntity> respose = service.getObject(temp, dataType);
        if (respose.isSuccess()){
            this.data.add(respose.getData());

        }else{
            throw new RuntimeException(respose.getMessage());
        }
    }




}