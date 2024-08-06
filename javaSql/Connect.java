package javaSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connect {
    public static void main(String[] args) throws SQLException {
        //connect
        Connection connection= DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "javase",
                "java123"
        );

        //transaction * Report
        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into person(id,name,family) values(3,'Ahmad','Ahmadi')"
//                Select * from PERSON;
        );

                preparedStatement.execute();


        //disconnect
        connection.close();
    }
}
