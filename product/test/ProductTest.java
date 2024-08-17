package product.test;

import product.model.da.ProductDa;

import java.sql.SQLException;

public class ProductTest {
    public static void main(String[] args) throws SQLException {
        try(ProductDa productDa = new ProductDa()){
        productDa.save(null);
            } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
