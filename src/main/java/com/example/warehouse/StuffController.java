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

public class StuffController {

    Database database = new Database();

    ObservableList<Stuff> lists = FXCollections.observableArrayList();

    @FXML
    private Button add;

    @FXML
    private Button back;

    @FXML
    private TableColumn<Stuff, Integer> count;

    @FXML
    private TableColumn<Stuff, Integer> id;

    @FXML
    private TableColumn<Stuff, String> name;

    @FXML
    private TableView<Stuff> tableUser;

    @FXML
    private TableColumn<Stuff, String> type;

    @FXML
    private TableColumn<Stuff, String> weight;

    @FXML
    void initialize() throws SQLException {
        setStuff();
    }

    public void newStuffAddWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("stuff_add.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)add.getScene().getWindow();
        stage.setTitle("ВВЕДИТЕ ДАННЫЕ");
        stage.setScene(scene);
        stage.show();
    }

    public void setStuff() throws SQLException {
        ResultSet resultSet = database.getStuff();
        while (resultSet.next())
        {
            lists.add(new Stuff(resultSet.getInt("id"), resultSet.getString ("name"),
                    resultSet.getString ("weight"), resultSet.getInt("number"), resultSet.getString ("type_id")));
        }
        id.setCellValueFactory(new PropertyValueFactory<Stuff, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Stuff, String>("name"));
        weight.setCellValueFactory(new PropertyValueFactory<Stuff, String>("weight"));
        count.setCellValueFactory(new PropertyValueFactory<Stuff, Integer>("number"));
        type.setCellValueFactory(new PropertyValueFactory<Stuff, String>("type_id"));

        tableUser.setItems(lists);
    }

    public void newStuffEmployeeWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("employee_stuff.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)back.getScene().getWindow();
        stage.setTitle("CОТРУДНИК_ВЕЩЬ");
        stage.setScene(scene);
        stage.show();
    }
}
