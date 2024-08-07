package com.example.warehouse;

import java.nio.file.FileSystems;
import java.sql.*;

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
    public void singUpUser(String name, String data, Integer department_id) throws SQLException {

        PreparedStatement pstmt = dbConnection.prepareStatement("INSERT INTO employee (name, data, department_id) values ('"+name+"', '"+data+"', '"+department_id+"');");
        pstmt.executeUpdate();
    }

    public ResultSet getEmployee() throws SQLException {
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT employee.id, employee.name, employee.data, department.name as department FROM employee, department WHERE employee.department_id = department.id;");

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

    public  void createType()
    {
        PreparedStatement pstmt;
        try {
            pstmt = dbConnection.prepareStatement("CREATE TABLE IF NOT EXISTS" +
                    "'type'(id integer primary key autoincrement," +
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

    public void inserting_type(String name) throws SQLException {
        PreparedStatement pstmt = null;
        pstmt = dbConnection.prepareStatement("INSERT INTO type (name) values ('"+name+"');");
        pstmt.executeUpdate();
    }

    public void getType() throws SQLException {
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT * FROM type");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
        }
    }

    public  void createStuff()
    {
        PreparedStatement pstmt;
        try {
            pstmt = dbConnection.prepareStatement("CREATE TABLE IF NOT EXISTS" +
                    "'stuff'(id integer primary key autoincrement," +
                    "name text not null," +
                    "weight text not null," +
                    "number integer not null," +
                    "type_id integer not null, foreign key(type_id) references type(id));");

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

    public void singUpStuff(String name, String weight, Integer number, Integer type_id) throws SQLException {

        PreparedStatement pstmt = dbConnection.prepareStatement("INSERT INTO stuff (name, weight, number, type_id) values ('"+name+"', '"+weight+"', '"+number+"', '"+type_id+"');");
        pstmt.executeUpdate();
    }

    public ResultSet getStuff() throws SQLException {
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT stuff.id, stuff.name, stuff.weight, stuff.number, type.name as type_id FROM stuff, type WHERE stuff.type_id = type.id;");

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

    public  void createStatus()
    {
        PreparedStatement pstmt;
        try {
            pstmt = dbConnection.prepareStatement("CREATE TABLE IF NOT EXISTS" +
                    "'status'(id integer primary key autoincrement," +
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

    public void inserting_status(String name) throws SQLException {
        PreparedStatement pstmt = null;
        pstmt = dbConnection.prepareStatement("INSERT INTO status (name) values ('"+name+"');");
        pstmt.executeUpdate();
    }

    public void getStatus() throws SQLException {
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT * FROM status");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
        }
    }

    public  void createEmployeeStuff() throws RuntimeException {
        PreparedStatement pstmt;
        try {
            pstmt = dbConnection.prepareStatement("CREATE TABLE IF NOT EXISTS" +
                    "'employee_stuff'(id integer primary key autoincrement," +
                    "name_employee_id integer not null," +
                    "name_stuff_id integer not null," +
                    "count integer not null," +
                    "data text not null," +
                    "data_refund text," +
                    "name_status_id integer not null," +
                    "foreign key(name_status_id) references status(id)," +
                    "foreign key(name_employee_id) references employee(id)," +
                    "foreign key(name_stuff_id) references stuff(id));");

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

    public void singUpEmployeeStuff(Integer name_employee_id, Integer name_stuff_id, Integer count, String data, String data_refund, Integer name_status_id) throws SQLException {

        PreparedStatement pstmt = dbConnection.prepareStatement("INSERT INTO employee_stuff (name_employee_id, name_stuff_id, count, data, data_refund, name_status_id) values ('"+name_employee_id+"', '"+name_stuff_id+"', '"+count+"', '"+data+"', '"+data_refund+"', '"+name_status_id+"');");
        pstmt.executeUpdate();
    }

    public ResultSet getEmployeeStuff() throws SQLException {
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT employee_stuff.id, employee.name, stuff.name AS names, employee_stuff.count, employee_stuff.data, employee_stuff.data_refund, status.name AS sname FROM employee_stuff INNER JOIN employee ON employee_stuff.name_employee_id = employee.id INNER JOIN stuff ON employee_stuff.name_stuff_id = stuff.id INNER JOIN status ON employee_stuff.name_status_id = status.id;");

        ResultSet resultSet = stmt.executeQuery();

        /*while (resultSet.next())
        {
            System.out.println(resultSet.getInt (1));
            System.out.println(resultSet.getString (2));
            System.out.println(resultSet.getString (3));
            System.out.println(resultSet.getInt (4));
            System.out.println(resultSet.getString (5));
            System.out.println(resultSet.getString (6));
            System.out.println(resultSet.getString (7));

        }*/
        return resultSet;
    }

    public ResultSet getEmployeeName() throws SQLException {
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT employee.name FROM employee;");

        ResultSet resultSet = stmt.executeQuery();
        return resultSet;
    }

    public ResultSet getStuffName() throws SQLException {
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT stuff.name FROM stuff;");

        ResultSet resultSet = stmt.executeQuery();
        return resultSet;
    }

    public ResultSet getStatusName() throws SQLException {
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT status.name FROM status;");

        ResultSet resultSet = stmt.executeQuery();
        return resultSet;
    }

    public ResultSet getStuffNumber(int index_stuff) throws SQLException {
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT stuff.number FROM stuff WHERE stuff.id = '"+index_stuff+"';");

        ResultSet resultSet = stmt.executeQuery();
        return resultSet;
    }

    public void updateStuffNumber(int index_stuff, int num) throws SQLException {
        PreparedStatement stmt = dbConnection.prepareStatement("UPDATE stuff SET number = '"+num+"' WHERE id = '"+index_stuff+"';");
        stmt.executeUpdate();

    }
}