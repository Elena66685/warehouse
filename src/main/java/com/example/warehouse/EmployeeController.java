package com.example.warehouse;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeeController {
    @FXML
    public Button add;

    @FXML
    void initialize() {

    }

    public void newWindow2() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("add.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)add.getScene().getWindow();
        stage.setTitle("ВВЕДИТЕ ДАННЫЕ");
        stage.setScene(scene);
        stage.show();
    }
}
