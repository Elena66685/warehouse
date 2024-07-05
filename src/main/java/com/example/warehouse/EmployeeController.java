package com.example.warehouse;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeController {


    ObservableList<User> list = FXCollections.observableArrayList();

    Database database = new Database();
    @FXML
    public Button add;

    @FXML
    private Button back;

    @FXML
    private TableColumn<User, String> data;

    @FXML
    private TableColumn<User, String> department;

    @FXML
    private TableColumn<User, Integer> id;

    @FXML
    private TableColumn<User, String> name;

    @FXML
    private TableView<User> tableUser;

    @FXML
    void initialize() throws SQLException {

        setEmployee();
    }

    public void newWindow2() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("employee_add.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)add.getScene().getWindow();
        stage.setTitle("ВВЕДИТЕ ДАННЫЕ");
        stage.setScene(scene);
        stage.show();
    }
    
    public void setEmployee() throws SQLException {
        ResultSet resultSet = database.getEmployee();
        while (resultSet.next())
        {
            list.add(new User(resultSet.getInt("id"), resultSet.getString ("name"),
                              resultSet.getString ("data"), resultSet.getString ("department")));
        }
        id.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        data.setCellValueFactory(new PropertyValueFactory<User, String>("data"));
        department.setCellValueFactory(new PropertyValueFactory<User, String>("department"));

        tableUser.setItems(list);
    }

    public void OpenEmployeeWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("employee_stuff.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)back.getScene().getWindow();
        stage.setTitle("СОТРУДНИК_ВЕЩЬ");
        stage.setScene(scene);
        stage.show();
    }
}


