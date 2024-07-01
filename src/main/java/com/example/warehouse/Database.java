package com.example.warehouse;

import java.nio.file.FileSystems;
import java.sql.*;
import java.util.Objects;

public class Database {

    public Connection dbConnection = getDBConnection();

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

    public  void createDB()
    {
        PreparedStatement pstmt;
        try {
            pstmt = dbConnection.prepareStatement("CREATE TABLE IF NOT EXISTS" +
                    "'department'(id integer primary key autoincrement," +
                    "name text not null);");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("таблица создана");
    }

    public void inserting_department(String name) throws SQLException {
        PreparedStatement pstmt = null;
        pstmt = dbConnection.prepareStatement("INSERT INTO department (name) values ('"+name+"');");
        pstmt.executeUpdate();
    }

    public void getDepartment() throws SQLException {
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT * FROM department");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
        }
    }

    public  void createDBemployee()
    {
        PreparedStatement pstmt;
        try {
            pstmt = dbConnection.prepareStatement("CREATE TABLE IF NOT EXISTS" +
                    "'employee'(id integer primary key autoincrement," +
                    "name text not null," +
                    "data text not null," +
                    "department_id integer not null, foreign key(department_id) references department(id));");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("таблица создана");
    }
    public void singUpUser(String name, String data, String department_id) throws SQLException {
        //String str = "SELECT id FROM department WHERE name = " +department_id;
        //PreparedStatement stmt = dbConnection.prepareStatement(str);
        //ResultSet resultSet = stmt.executeQuery();
        //while (resultSet.next()) {
            //System.out.println(resultSet.getInt(1));
        //}
       // PreparedStatement stmt = dbConnection.prepareStatement("SELECT id FROM department WHERE name IN ("+department_id+")");
        //ResultSet resultSet = stmt.executeQuery();
        int department = 0;
        //System.out.println(department);
        if(Objects.equals(department_id, "Отдел кадров")) department = 1;
        if(Objects.equals(department_id, "Бухгалтерия")) department = 2;
        if(Objects.equals(department_id, "Безопасности")) department = 3;
        if(Objects.equals(department_id, "Продаж")) department = 4;
        if(Objects.equals(department_id, "ИТ")) department = 5;
        //System.out.println(department);

        PreparedStatement pstmt = dbConnection.prepareStatement("INSERT INTO employee (name, data, department_id) values ('"+name+"', '"+data+"', '"+department+"');");
        pstmt.executeUpdate();
    }
}
