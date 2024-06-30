package com.example.warehouse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("СОТРУДНИК_ВЕЩЬ");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        launch();
        //Database bs = new Database();
        //Connection dbConnection = bs.getDBConnection();
        //bs.createDB();
        //bs.inserting_department("ИТ");
        //bs.getDepartment();
        //bs.createDBemployee();
    }
}