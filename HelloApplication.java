package com.example.xo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 500);
            Image icon = new Image("C:\\Users\\owner\\IdeaProjects\\xo\\src\\main\\resources\\xo.png");
            stage.getIcons().add(icon);
            stage.setTitle("Tic Tac Toe");
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}