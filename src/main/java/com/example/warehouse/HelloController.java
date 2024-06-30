package com.example.warehouse;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button add;

    @FXML
    private TableColumn<?, ?> count;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> minus;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> pack;

    @FXML
    private TableColumn<?, ?> plus;

    @FXML
    private TableColumn<?, ?> status;

    public void newWindow1() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("employee.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)add.getScene().getWindow();
        stage.setTitle("СОТРУДНИКИ");
        stage.setScene(scene);
        stage.show();
    }
}