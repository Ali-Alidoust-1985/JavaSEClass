package product.model.da;

import entity.PharmacyName;
import product.model.entity.Product;
import entity.Type;
import product.model.utils.JdbcProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.sun.deploy.ref.AppRef.Type.valueOf;

public class ProductDa implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;
    JdbcProvider jdbcProvider = new JdbcProvider();


    public ProductDa() throws SQLException {
        connection = jdbcProvider.getConnection();
    }

    public void save(Product product) throws SQLException {
        product.setId(jdbcProvider.getNextId("PRODUCT_SEQ"));
        preparedStatement = connection.prepareStatement(
                "INSERT INTO PRODUCT VALUES(?,?,?,?,?,?,?,?,?)"
        );
        preparedStatement.setInt(1, product.getId());
        preparedStatement.setString(2, product.getName());
        preparedStatement.setInt(3, product.getCount());
        preparedStatement.setDouble(4, product.getPrice());
        preparedStatement.setString(5, product.getBrand());
        preparedStatement.setDate(6, Date.valueOf(String.valueOf(product.getExpireDate())));
        preparedStatement.setString(7,product.getPharmacyName().name());
        preparedStatement.setBoolean(8,product.isDiecutCbx());
        preparedStatement.setBoolean(9,product.isRcsCbx());

        preparedStatement.execute();
    }

    public void edit(Product product) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "UPDATE PRODUCT SET NAME=?, COUNT=?, PRICE=?, BRAND=?, EXPIRE_DATE=?, PHARMACY_NAME=?, DieCUT=?, RCS=? WHERE ID=?"
        );

        preparedStatement.setString(1, product.getName());
        preparedStatement.setInt(2, product.getCount());
        preparedStatement.setDouble(3, product.getPrice());
        preparedStatement.setString(4, product.getBrand());
        preparedStatement.setDate(5, Date.valueOf(String.valueOf(product.getExpireDate())));
        preparedStatement.setString(6, product.getPharmacyName().name());
        preparedStatement.setBoolean(7,product.isDiecutCbx());
        preparedStatement.setBoolean(8,product.isRcsCbx());
        preparedStatement.setInt(9, product.getId());


        preparedStatement.execute();
    }

    public void remove(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "DELETE FROM PRODUCT WHERE ID=?"
        );
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    public List<Product> findAll() throws SQLException {
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM PRODUCT ORDER BY ID"
        );
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Product> productList = new ArrayList<>();

        while (resultSet.next()) {
            Product product =
                    Product
                            .builder()
                            .id(resultSet.getInt("ID"))
                            .name(resultSet.getString("NAME"))
                            .count(resultSet.getInt("COUNT"))
                            .price(resultSet.getDouble("PRICE"))
                            .brand(resultSet.getString("BRAND"))
                            .expireDate((resultSet.getDate("Expire_Date")).toLocalDate().atStartOfDay())
                            .pharmacyName(PharmacyName.valueOf(resultSet.getString("pharmacyName")))
                            .diecutCbx(resultSet.getBoolean("isdieCut"))
                            .type(Type.valueOf(resultSet.getString("Type")))
                            .diecutCbx(resultSet.getBoolean("Die_Cut_Package"))
                            .rcsCbx(resultSet.getBoolean("RCS_Package"))

                            .build();
            productList.add(product);
        }
        return productList;
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}

