package com.example.warehouse;

import java.nio.file.FileSystems;
import java.sql.*;

public class Database {

    //public Connection basedb = getDBConnection();
    //String.valueOf(FileSystems.getDefault().getPath("").toAbsolutePath()) +

    public Connection getDBConnection() throws RuntimeException {
        Connection db;
        String path = String.valueOf(FileSystems.getDefault().getPath("").toAbsolutePath()) + "\\src\\main\\resources\\com\\example\\warehouse\\database\\base.db";
        System.out.println(path);
        try {
            db = DriverManager.getConnection("jdbc:sqlite:" + path);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("База подключена!");
        return db;
    }
}
