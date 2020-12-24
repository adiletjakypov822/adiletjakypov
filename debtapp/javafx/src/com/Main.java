package com;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void init() throws Exception {
        System.out.println("Started!");
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Stage.fxml"));
        stage.setTitle("Debt app");
        stage.setScene(new Scene(root,360, 470));

        stage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Closed!");
    }

    public static void main(String args[]){
        launch(args);
    }

}
