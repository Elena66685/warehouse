package com.example.warehouse;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeeStuffController {

    @FXML
    private Button add;

    @FXML
    private Button addstuff;

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

    public void OpenEmployeeWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("employee.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)add.getScene().getWindow();
        stage.setTitle("СОТРУДНИКИ");
        stage.setScene(scene);
        stage.show();
    }

    public void OpenStuffWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("stuff.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)addstuff.getScene().getWindow();
        stage.setTitle("ВЕЩИ");
        stage.setScene(scene);
        stage.show();
    }
}