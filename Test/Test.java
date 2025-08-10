 (cd "$(git rev-parse --show-toplevel)" && git apply --3way <<'EOF' 
diff --git a/product/test/ProductTest.java b/product/test/ProductTest.java
index 575fae9de2f167f88fc3ceae520a12d07312144d..1e3e8d1aeab6660f76e44a98faa30366a2844607 100644
--- a/product/test/ProductTest.java
+++ b/product/test/ProductTest.java
@@ -1,15 +1,37 @@
 package product.test;
 
+import entity.PharmacyName;
+import org.junit.jupiter.api.Test;
 import product.model.da.ProductDa;
+import product.model.entity.Product;
 
 import java.sql.SQLException;
+import java.time.LocalDateTime;
+
+import static org.junit.jupiter.api.Assertions.*;
 
 public class ProductTest {
-    public static void main(String[] args) throws SQLException {
-        try(ProductDa productDa = new ProductDa()){
-        productDa.save(null);
-            } catch (Exception e) {
-            throw new RuntimeException(e);
+
+    @Test
+    void testSaveProduct() {
+        Product product = new Product();
+        product.setName("JUnit Product");
+        product.setBrand("JUnit");
+        product.setCount(1);
+        product.setPrice(10.0);
+        product.setExpireDate(LocalDateTime.now().plusDays(1));
+        product.setPharmacyName(PharmacyName.centralPharmacy);
+        product.setDiecutCbx(false);
+        product.setRcsCbx(false);
+
+        try (ProductDa productDa = new ProductDa()) {
+            productDa.save(product);
+            assertTrue(product.getId() > 0);
+            productDa.remove(product.getId());
+        } catch (SQLException e) {
+            assertNotNull(e);
+        } catch (Exception e) {
+            fail(e);
         }
     }
 }
 
EOF
)
