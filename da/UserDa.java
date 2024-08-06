package da;

import Entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDa {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "javase",
                "java123"
        );
    }

    public void save(User user) throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "INSERT INTO USER_TBL (ID, USERNAME, PASSWORD) VALUES (USER_SEQ.NEXTVAL,?,?)"
        );
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.execute();
        close();
    }


    public void edit(User user)throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "UPDATE USER_TBL SET USERNAME = ?, PASSWORD = ? WHERE ID = ?"
        );
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setInt(3, user.getId());
        preparedStatement.execute();
        close();
    }


    public void remove(int id)throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "DELETE FROM USER_TBL WHERE ID = ?"
        );
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        close();
    }

    public List<User> findAll()throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM USER_TBL ORDER BY ID"
        );
        ResultSet resultSet = preparedStatement.executeQuery();

        List<User> userList = new ArrayList<User>();

        while(resultSet.next()) {
            User user = User
                    .builder()
                    .id(resultSet.getInt("id"))
                    .username(resultSet.getString("username"))
//                    .password(resultSet.getString("password"))
                    .password("********")
                    .build();
            userList.add(user);
        }
        close();
        return userList;
    }

    public User findById(int id)throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM USER_TBL WHERE ID = ?"
        );
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        User user = null;

        if(resultSet.next()) {
            user = User
                    .builder()
                    .id(resultSet.getInt("id"))
                    .username(resultSet.getString("username"))
                    .password(resultSet.getString("password"))
                    .build();
        }
        close();
        return user;
    }


    public User findByUsername(String username)throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM USER_TBL WHERE USERNAME = ?"
        );
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();

        User user = null;

        if(resultSet.next()) {
            user = User
                    .builder()
                    .id(resultSet.getInt("id"))
                    .username(resultSet.getString("username"))
                    .password(resultSet.getString("password"))
                    .build();
        }
        close();
        return user;
    }


    public User findByUsernameAndPassword(String username, String password)throws Exception {
        connect();
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM USER_TBL WHERE USERNAME = ? AND PASSWORD = ?"
        );
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();

        User user = null;

        if(resultSet.next()) {
            user = User
                    .builder()
                    .id(resultSet.getInt("id"))
                    .username(resultSet.getString("username"))
                    .password(resultSet.getString("password"))
                    .build();
        }
        close();
        return user;
    }

    public void close()throws Exception{
        preparedStatement.close();
        connection.close();
    }
}
