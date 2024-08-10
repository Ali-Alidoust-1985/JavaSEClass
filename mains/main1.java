package mains;

import java.sql.*;

public class main1 {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "javase",
                "java123"
        );

        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from usr_tbl order by id");


        ResultSet resultset = preparedStatement.executeQuery();
        while(resultset.next()) {
            System.out.println(resultset.getString("id"));
            System.out.println(resultset.getString("username"));
            System.out.println(resultset.getString("password"));
        }

        preparedStatement.close();

        connection.close();
    }
}