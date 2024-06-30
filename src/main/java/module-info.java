module com.example.warehouse {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens com.example.warehouse to javafx.fxml;
    exports com.example.warehouse;
}
