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
                    "department text not null);");
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
        pstmt = dbConnection.prepareStatement("INSERT INTO department (department) values ('"+name+"');");
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
    public void singUpUser(String name, String data, Integer department_id) throws SQLException {

        PreparedStatement pstmt = dbConnection.prepareStatement("INSERT INTO employee (name, data, department_id) values ('"+name+"', '"+data+"', '"+department_id+"');");
        pstmt.executeUpdate();
    }

    public ResultSet getEmployee() throws SQLException {
        //PreparedStatement stmt = dbConnection.prepareStatement("SELECT employee.id, employee.name, employee.data, department.name FROM employee, department WHERE employee.department_id = department.id;");
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT employee.id, employee.name, employee.data, department.department FROM employee, department WHERE employee.department_id = department.id;");

        ResultSet resultSet = stmt.executeQuery();
        return resultSet;

       /*While (resultSet.next())
        {
            System.out.println(resultSet.getInt (1));
            System.out.println(resultSet.getString (2));
            System.out.println(resultSet.getString (3));
            System.out.println(resultSet.getString (4));
        }*/
    }
}

