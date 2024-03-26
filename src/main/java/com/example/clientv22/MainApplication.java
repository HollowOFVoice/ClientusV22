package com.example.clientv22;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;



public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Ну даров");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    public static void showAuthorDialog(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("add-author-view.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Добавить/изменить автора");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void showPublisherDialog(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("publisher-add-view.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Добавить/изменить автора");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
//    static String content_Url = "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/jNQXAC9IVRw?si=VbFzQiFbNizgOe75\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>";
//    public static void vd(Stage primaryStage) {
//        WebView webView = new WebView();
//        WebEngine webEngine = webView.getEngine();
//        webEngine.loadContent(content_Url);
//
//        StackPane root = new StackPane();
//        root.getChildren().add(webView);
//
//        Scene scene = new Scene(root, 300, 250);
//
//        primaryStage.setTitle("Ухахааха");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }

    static String content_Url = "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/GvSA16SlpuY?si=qTpHNsv_vYk9JFhv\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>";
public static void videoDialog(){

    Stage dialogStage = new Stage();
    WebView webView = new WebView();
    WebEngine webEngine = webView.getEngine();
    webEngine.loadContent(content_Url);

    StackPane root = new StackPane();
    root.getChildren().add(webView);

    Scene scene = new Scene(root, 600, 330);
    dialogStage.setResizable(false);
    dialogStage.setTitle("даров твр-");
    dialogStage.setScene(scene);
    dialogStage.show();
}
}