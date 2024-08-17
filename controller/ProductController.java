package controller;

import entity.PharmacyName;
import product.model.entity.Product;
import entity.Type;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import product.model.da.ProductDa;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class ProductController implements Initializable {
    @FXML
    private TextField idTxt,nameTxt,priceTxt,brandTxt,countTxt;

    @FXML
    private DatePicker expirationDate;

    @FXML
    private ComboBox<String> pharmacyCmb;

    @FXML
    private ToggleGroup typeToggleGroup;

    @FXML
    private RadioButton disposableRdo, reusableRdo;

    @FXML
    private Button saveBtn, editBtn, removeBtn;

    @FXML
    private TableView<Product> productTbl;

    @FXML
    private TableColumn<Product, Integer> idCol;

    @FXML
    private TableColumn<Product, String> nameCol,brandCol;

    @FXML
    private TableColumn<Product, Double> priceCol;

    @FXML
    private CheckBox diecutCbx, rcsCbx;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        resetForm();
        for (PharmacyName pharmacyName : PharmacyName.values()) {
            pharmacyCmb.getItems().add(pharmacyName.toString());
        }


        saveBtn.setOnAction(event -> {
            try (ProductDa productDa = new ProductDa()) {
                RadioButton selectedRdo = (RadioButton) typeToggleGroup.getSelectedToggle();

                Product product = Product
                        .builder()
                        .name(nameTxt.getText())
                        .price(Double.parseDouble(priceTxt.getText()))
                        .brand(brandTxt.getText())
                        .count(Integer.parseInt(countTxt.getText()))
                        .expireDate(expirationDate.getValue().atStartOfDay())
                        .pharmacyName(PharmacyName.valueOf(pharmacyCmb.getSelectionModel().getSelectedItem()))
                        .rcsCbx(rcsCbx.isSelected())
                        .diecutCbx(diecutCbx.isSelected())
                        .build();

                productDa.save(product);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Product saved\n" + product.toString());
                alert.show();
                resetForm();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Product save Error!!\n" + e.getMessage());
                alert.show();
            }
        });


            editBtn.setOnAction(event -> {
                try (ProductDa productDa = new ProductDa()) {
                    RadioButton selectedRdo = (RadioButton) typeToggleGroup.getSelectedToggle();

                    Product product = Product
                            .builder()
                            .name(nameTxt.getText())
                            .price(Double.parseDouble(priceTxt.getText()))
                            .brand(brandTxt.getText())
                            .count(Integer.parseInt(countTxt.getText()))
                            .expireDate(expirationDate.getValue().atStartOfDay())
                            .pharmacyName(PharmacyName.valueOf(pharmacyCmb.getSelectionModel().getSelectedItem()))
                            .rcsCbx(rcsCbx.isSelected())
                            .diecutCbx(diecutCbx.isSelected())
                            .build();

                    productDa.edit(product);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Product edited\n" + product.toString());
                    alert.show();
                    resetForm();
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Product edit Error!!\n" + e.getMessage());
                    alert.show();
                }
        });
            removeBtn.setOnAction(event -> {
                try (ProductDa productDa = new ProductDa()) {
//                    RadioButton selectedRdo = (RadioButton) typeToggleGroup.getSelectedToggle();
                    Alert confirmAlert=new Alert(Alert.AlertType.CONFIRMATION,"Are you sure?");
                    if(confirmAlert.showAndWait().get()==ButtonType.OK) {
                        int id = Integer.parseInt(idTxt.getText());
                        productDa.remove(id);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Product removed with ID:" + id);
                        alert.show();
                        resetForm();
                    }
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Product remove Error!!\n" + e.getMessage());
                    alert.show();
                }

            });
            productTbl.setOnMouseReleased (event -> {
                Product product=productTbl.getSelectionModel().getSelectedItem();
                idTxt.setText(String.valueOf(product.getId()));
                nameTxt.setText(product.getName());
                priceTxt.setText(String.valueOf(product.getPrice()));
                countTxt.setText(String.valueOf(product.getCount()));
                brandTxt.setText(product.getBrand());
                if(product.getType().equals(Type.disposable)){
                    disposableRdo.setSelected(true);
                }else{
                    reusableRdo.setSelected(true);
                }
                expirationDate.setValue(LocalDate.from(product.getExpireDate()));
                pharmacyCmb.getSelectionModel().select(product.getPharmacyName().name());
                diecutCbx.setSelected(product.isDiecutCbx());
                rcsCbx.setSelected(product.isRcsCbx());
            });
    }





    private void resetForm() {
        idTxt.clear();
        nameTxt.clear();
        priceTxt.clear();
        brandTxt.clear();
        countTxt.clear();
        expirationDate.setValue(LocalDate.now());
        pharmacyCmb.getItems().clear();
        disposableRdo.setSelected(true);
        reusableRdo.setSelected(false);
        typeToggleGroup.selectToggle(null);

        try(ProductDa productDa=new ProductDa()){
            refreshTable(productDa.findAll());
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Product refresh Error!!\n" + e.getMessage());
            alert.show();
        }
    }

    private void refreshTable(List<Product> productList) {
        ObservableList<Product> product = FXCollections.observableList(productList);
        productTbl.setItems(product);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        pharmacyCmb.setItems(pharmacyCmb.getItems());
    }
}


