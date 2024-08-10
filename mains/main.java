package mains;

import java.sql.*;

public class main {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "javase",
                "java123"
        );
//        String username;
//        String password;
//        PreparedStatement preparedStatement = connection.prepareStatement(
//                "select * from usr_tbl where USERNAME=? AND PASSWORD=?");
//        preparedStatement.setString(1, "username");
//        preparedStatement.setString(2, "password");
        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into usr_tbl(id,username,password) values(person_seq.nextval,?,?)");
//        preparedStatement.setInt(1, 4);
        preparedStatement.setString(1, "admin1");
        preparedStatement.setString(2, "admin1");

        preparedStatement.executeUpdate();
        preparedStatement.close();

        connection.close();
    }
}