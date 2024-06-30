package com.example.warehouse;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class AddController {
    @FXML
    public Button send;

    @FXML
    private TextField data;

    @FXML
    private TextField department;

    @FXML
    private TextField name;

    @FXML
    void initialize() {
        Database database = new Database();

        send.setOnAction(event -> {
            try {
                database.singUpUser(name.getText(), data.getText(), Integer.valueOf(department.getText()));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });


    }
}
