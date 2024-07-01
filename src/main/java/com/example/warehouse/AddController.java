package com.example.warehouse;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class AddController {

    Database database = new Database();

    @FXML
    private ComboBox<String> department;
    ObservableList<String> program = FXCollections.observableArrayList("Отдел кадров", "Бухгалтерия", "Безопасности", "Продаж", "ИТ");
    @FXML
    public Button send;

    @FXML
    private TextField data;

    @FXML
    private TextField name;

    @FXML
    void initialize()
    {
        department.setItems(program);

    }

    public void sendData() throws SQLException {
        database.singUpUser(name.getText(), data.getText(), department.getValue());

    }
}
