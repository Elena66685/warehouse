package com.example.warehouse;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class EmployeeAddController {

    Database database = new Database();

    @FXML
    private Button backBtn;

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

    public void sendData() throws SQLException, IOException {
        int index = department.getSelectionModel().getSelectedIndex() + 1;
        database.singUpUser(name.getText(), data.getText(), index);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Сообщение");
        alert.setContentText("Сотрудник успешно добавлен!");
        alert.showAndWait();
        OpenEmployeeWindow();
    }

    public void OpenEmployeeWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("employee.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)backBtn.getScene().getWindow();
        stage.setTitle("СОТРУДНИКИ");
        stage.setScene(scene);
        stage.show();
    }
}
