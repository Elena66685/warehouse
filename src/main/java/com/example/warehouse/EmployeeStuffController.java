package com.example.warehouse;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeStuffController {

    Database database = new Database();

    ObservableList<Stuffuser> lists = FXCollections.observableArrayList();

    @FXML
    private Button add;

    @FXML
    private Button addstuff;

    @FXML
    private TableColumn<Stuffuser, Integer> count;

    @FXML
    private TableColumn<Stuffuser, Integer> id;

    @FXML
    private TableColumn<Stuffuser, String> minus;

    @FXML
    private TableColumn<Stuffuser, String> name;

    @FXML
    private TableColumn<Stuffuser, String> pack;

    @FXML
    private TableColumn<Stuffuser, String> plus;

    @FXML
    private TableColumn<Stuffuser, String> status;

    @FXML
    private TableView<Stuffuser> table;

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

    public void SetTable() throws SQLException {
        ResultSet resultSet = database.getEmployeeStuff();
        while (resultSet.next())
        {

        }
    }
}