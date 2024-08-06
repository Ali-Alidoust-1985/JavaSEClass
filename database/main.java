package database;

import java.sql.*;

public class main {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "javase",
                "java123"
        );
        String username;
        String password;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from usr_tbl where USERNAME=? AND PASSWORD=?");
        preparedStatement.setString(1, "username");
        preparedStatement.setString(2, "password");
    }
}