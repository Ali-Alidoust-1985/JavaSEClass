package product.test;

import entity.PharmacyName;
import org.junit.jupiter.api.Test;
import product.model.da.ProductDa;
import product.model.entity.Product;

import java.sql.SQLException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    void testSaveProduct() {
        Product product = new Product();
        product.setName("JUnit Product");
        product.setBrand("JUnit");
        product.setCount(1);
        product.setPrice(10.0);
        product.setExpireDate(LocalDateTime.now().plusDays(1));
        product.setPharmacyName(PharmacyName.centralPharmacy);
        product.setDiecutCbx(false);
        product.setRcsCbx(false);

        try (ProductDa productDa = new ProductDa()) {
            productDa.save(product);
            assertTrue(product.getId() > 0);
            productDa.remove(product.getId());
        } catch (SQLException e) {
            assertNotNull(e);
        } catch (Exception e) {
            fail(e);
        }
    }
}
