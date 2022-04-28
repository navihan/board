package com.fastcampus.board;

import java.sql.*;

public class dbtest {

    public static void main(String[] args) throws SQLException, SQLException {
        String url = "jdbc:mysql://localhost:3306/fastcampus";
        String userName = "test";
        String password = "test";

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from board");

        resultSet.next();
        String writer = resultSet.getString("writer");
        System.out.println(writer);

        resultSet.close();
        statement.close();
        connection.close();
    }
}
