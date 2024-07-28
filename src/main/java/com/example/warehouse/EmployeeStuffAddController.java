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
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeStuffAddController {

    Database database = new Database();

    ObservableList<String> lists = FXCollections.observableArrayList();
    ObservableList<String> strings = FXCollections.observableArrayList();
    ObservableList<String> str = FXCollections.observableArrayList();

    @FXML
    private Button back;

    @FXML
    private TextField count;

    @FXML
    private TextField minus;

    @FXML
    private TextField plus;

    @FXML
    private Button send;

    @FXML
    private ComboBox<String> status;

    @FXML
    private ComboBox<String> stuff;

    @FXML
    private ComboBox<String> user;

    @FXML
    void initialize() throws SQLException {
        plus.setText(null);
        SetEmployeeStuffAdd();
        SetStuffAdd();
        SetStatusAdd();
    }

    public void SetEmployeeStuffAdd() throws SQLException {
        ResultSet resultSet = database.getEmployeeName();
        while (resultSet.next())
        {
            lists.add(resultSet.getString("name"));
        }
        user.setItems(lists);
    }

    public void SetStuffAdd() throws SQLException {
        ResultSet resultSet = database.getStuffName();
        while (resultSet.next())
        {
            strings.add(resultSet.getString("name"));
        }
        stuff.setItems(strings);
    }

    public void SetStatusAdd() throws SQLException {
        ResultSet resultSet = database.getStatusName();
        while (resultSet.next())
        {
            str.add(resultSet.getString("name"));
        }
        status.setItems(str);
    }

    public void sendEmployeeStuffAdd() throws SQLException, IOException {
        int index = user.getSelectionModel().getSelectedIndex() + 1;
        int index_stuff = stuff.getSelectionModel().getSelectedIndex() + 1;
        int index_status = status.getSelectionModel().getSelectedIndex() + 1;
        database.singUpEmployeeStuff(index, index_stuff, Integer.valueOf(count.getText()), minus.getText(), plus.getText(), index_status);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Сообщение");
        alert.setContentText("Запись успешно добавлена!");
        alert.showAndWait();
        OpenEmployeeStuffWindow();
    }

    public void OpenEmployeeStuffWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("employee_stuff.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)back.getScene().getWindow();
        stage.setTitle("СОТРУДНИК_ВЕЩЬ");
        stage.setScene(scene);
        stage.show();
    }
}
