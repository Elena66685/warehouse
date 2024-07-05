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

public class StuffAddController {

    Database database = new Database();

    @FXML
    private Button backBtn;

    @FXML
    private TextField count;

    @FXML
    private TextField name;

    @FXML
    private Button send;

    @FXML
    private ComboBox<String> typy;
    ObservableList<String> program = FXCollections.observableArrayList("Канцелярия", "Техника", "Мебель", "Инструмкнты");


    @FXML
    private TextField weight;

    @FXML
    void initialize()
    {
        typy.setItems(program);
    }

    public void setDBstuff() throws SQLException, IOException {
        int index = typy.getSelectionModel().getSelectedIndex() + 1;
        database.singUpStuff(name.getText(), weight.getText(), Integer.valueOf(count.getText()), index);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Сообщение");
        alert.setContentText("Вещь успешно добавлена!");
        alert.showAndWait();
        OpenStuffWindow();
    }

    public void OpenStuffWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("stuff.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)send.getScene().getWindow();
        stage.setTitle("ВЕЩИ");
        stage.setScene(scene);
        stage.show();
    }
}
