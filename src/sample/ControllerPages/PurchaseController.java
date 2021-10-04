package sample.ControllerPages;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Model.*;

import java.util.Date;

public class PurchaseController {

    @FXML
    private TextField findLastNameMasterProduct;
    @FXML
    private TextField findTypeProduct;
    @FXML
    private TextField newQuantityPurchase;
    @FXML
    private Label selectedProductPurchase;
    @FXML
    private Label selectedClientPurchase;

    public TableView<Client> clientTable;

    public TableColumn<Client, String> firstNameClient;
    public TableColumn<Client, String> lastNameClient;
    public TableColumn<Client, String> patronClient;
    public TableColumn<Client, String> phoneNumberClient;
    public TableColumn<Client, String> innClient;
    public TableColumn<Client, Integer> idClient;

    private ObservableList<Client> clients = FXCollections.observableArrayList();

    public TableView<Product> productTable;

    public TableColumn<Product, String> typeProduct;
    public TableColumn<Product, String> nameMasterProduct;
    public TableColumn<Product, Integer> quantityProduct;
    public TableColumn<Product, String> statusProduct;
    public TableColumn<Product, Integer> priceProduct;
    public TableColumn<Product, Integer> idProduct;
    public TableColumn<Product, Integer> idMasterProduct;
    public TableColumn<Product, Integer> idModelProduct;
    public TableColumn<Product, Integer> idStatusProduct;

    private ObservableList<Product> products = FXCollections.observableArrayList();

    @FXML
    void initialize(){

        typeProduct.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().typeProductProperty());
        nameMasterProduct.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().nameMasterProductProperty());
        quantityProduct.setCellValueFactory(cellData-> cellData.getValue().quantityProductProperty().asObject());
        priceProduct.setCellValueFactory(cellData-> cellData.getValue().priceProductProperty().asObject());
        idProduct.setCellValueFactory(cellData-> cellData.getValue().idProductProperty().asObject());
        idMasterProduct.setCellValueFactory(cellData-> cellData.getValue().idMasterProductProperty().asObject());
        idModelProduct.setCellValueFactory(cellData-> cellData.getValue().idModelProductProperty().asObject());

        productTable.setItems(products);
        showProductInToTable();

        idClient.setCellValueFactory(cellData-> cellData.getValue().idClientProperty().asObject());
        firstNameClient.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().firstNameClientProperty());
        lastNameClient.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().lastNameClientProperty());
        patronClient.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().patronClientProperty());
        phoneNumberClient.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().phoneNumberClientProperty());
        innClient.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().innClientProperty());

        clientTable.setItems(clients);
        showClientInToTable();
    }
    ModelStandart modelStandart = new ModelStandart();
    private Stage dialogStagePurchase;
    private Purchase purchase;
    PurchaseModel purchaseModel = new PurchaseModel();

    public void setDialogStagePurchase(Stage dialogStagePurchase) {
        this.dialogStagePurchase = dialogStagePurchase;
    }
    public void onClickBackPurchase(ActionEvent actionEvent) {
        dialogStagePurchase.close();
    }

    ClientModel clientModel = new ClientModel();
    public void showClientInToTable() {

        clients.clear();
        clients.addAll(clientModel.getClientList());
    }

    ProductModel productModel = new ProductModel();
    public void showProductInToTable() {

        products.clear();
        products.addAll(productModel.getProductList());
    }

    public void setPurchase (Purchase purchase) {

        this.purchase = purchase;

    }

    @FXML
    private TextField findINNClient;
    @FXML
    private TextField findLastNameClient;

    public void onClickFindClient(ActionEvent actionEvent) {
        clients.clear();
        clients.addAll(clientModel.getSeletClientList(findLastNameClient.getText(), findINNClient.getText()));
    }

    public void onClickFindProduct(ActionEvent actionEvent) {

    }

    public void onClickAddNewPurchase(ActionEvent actionEvent) {

        Product selectProduct = productTable.getSelectionModel().getSelectedItem();
        Client selectClient = clientTable.getSelectionModel().getSelectedItem();
        purchase = new Purchase();

        if(selectProduct != null && selectClient != null && newQuantityPurchase.getText() != "") {

            purchase.setIdClientPurchase(selectClient.getIdClient());
            purchase.setIdProductPurchase(selectProduct.getIdProduct());
            purchase.setQuantityProductPurchase(Integer.valueOf(newQuantityPurchase.getText()));
            purchase.setNameClientPurchase(selectClient.getLastNameClient());
            Date date = new Date();
            purchase.setDatePurchase(String.valueOf(date.getDate()));
            purchase.setPricePurchase(Integer.valueOf(newQuantityPurchase.getText()) * selectProduct.getPriceProduct());

            purchaseModel.addPurchase(purchase);
            dialogStagePurchase.close();

        } else {
            modelStandart.ShowAlert("Ошибка");
        }
    }
}
