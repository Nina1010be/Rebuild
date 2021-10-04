package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.ControllerPages.*;
import sample.Model.*;

import java.io.IOException;

public class Controller {

    public TableView<Client> clientTable;
    public TableColumn<Client, String> firstNameClient;
    public TableColumn<Client, String> lastNameClient;
    public TableColumn<Client, String> patronClient;
    public TableColumn<Client, String> phoneNumberClient;
    public TableColumn<Client, String> innClient;
    public TableColumn<Client, Integer> idClient;
    private ObservableList<Client> clients = FXCollections.observableArrayList();

    public TableView<Master> masterTable;
    public TableColumn<Master, String> firstNameMaster;
    public TableColumn<Master, String> lastNameMaster;
    public TableColumn<Master, String> patronMaster;
    public TableColumn<Master, String> phoneNumberMaster;
    public TableColumn<Master, String> innMaster;
    public TableColumn<Master, Integer> idMaster;
    private ObservableList<Master> masters = FXCollections.observableArrayList();

    public TableView<Model> modelTable;
    public TableColumn<Model, String> nameModel;
    public TableColumn<Model, String> materialModel;
    public TableColumn<Model, Integer> priceModel;
    public TableColumn<Model, String> pictureModel;
    public TableColumn<Model, Integer> idModel;
    private ObservableList<Model> models = FXCollections.observableArrayList();

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

    public TableView<Purchase> purchaseTable;
    public TableColumn<Purchase, String> nameClientPurchase;
    public TableColumn<Purchase, String> typeProductPurchase;
    public TableColumn<Purchase, Integer> quantityProductPurchase;
    public TableColumn<Purchase, String> datePurchase;
    public TableColumn<Purchase, Integer> pricePurchase;
    public TableColumn<Purchase, Integer> idProductPurchase;
    public TableColumn<Purchase, Integer> idPurchase;
    public TableColumn<Purchase, Integer> idClientPurchase;
    private ObservableList<Purchase> purchases = FXCollections.observableArrayList();

    public TableView<Order> orderTable;
    public TableColumn<Order, String> nameClientOrder;
    public TableColumn<Order, String> nameMasterOrder;
    public TableColumn<Order, String> typeProductOrder;
    public TableColumn<Order, Integer> quantityProductOrder;
    public TableColumn<Order, String> statusOrder;
    public TableColumn<Order, Integer> priceOrder;
    public TableColumn<Order, String> dateOrder;
    public TableColumn<Order, Integer> idMasterOrder;
    public TableColumn<Order, Integer> idClientOrder;
    public TableColumn<Order, Integer> idModelOrder;
    public TableColumn<Order, Integer> idOrder;
    public TableColumn<Order, Integer> idStatusOrder;
    private ObservableList<Order> orders = FXCollections.observableArrayList();

    @FXML
    void initialize(){

        idClient.setCellValueFactory(cellData-> cellData.getValue().idClientProperty().asObject());
        firstNameClient.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().firstNameClientProperty());
        lastNameClient.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().lastNameClientProperty());
        patronClient.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().patronClientProperty());
        phoneNumberClient.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().phoneNumberClientProperty());
        innClient.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().innClientProperty());

        clientTable.setItems(clients);
        showClientInToTable();

        firstNameMaster.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().firstNameMasterProperty());
        lastNameMaster.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().lastNameMasterProperty());
        patronMaster.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().patronMasterProperty());
        phoneNumberMaster.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().phoneNumberMasterProperty());
        innMaster.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().innMasterProperty());
        idMaster.setCellValueFactory(cellData-> cellData.getValue().idMasterProperty().asObject());

        masterTable.setItems(masters);
        showMasterInToTable();

        nameModel.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().nameModelProperty());
        materialModel.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().materialModelProperty());
        priceModel.setCellValueFactory(cellData-> cellData.getValue().priceModelProperty().asObject());
        pictureModel.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().pictureModelProperty());
        idModel.setCellValueFactory(cellData-> cellData.getValue().idModelProperty().asObject());

        modelTable.setItems(models);
        showModelInToTable();

        typeProduct.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().typeProductProperty());
        nameMasterProduct.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().nameMasterProductProperty());
        quantityProduct.setCellValueFactory(cellData-> cellData.getValue().quantityProductProperty().asObject());
        priceProduct.setCellValueFactory(cellData-> cellData.getValue().priceProductProperty().asObject());
        idProduct.setCellValueFactory(cellData-> cellData.getValue().idProductProperty().asObject());
        idMasterProduct.setCellValueFactory(cellData-> cellData.getValue().idMasterProductProperty().asObject());
        idModelProduct.setCellValueFactory(cellData-> cellData.getValue().idModelProductProperty().asObject());

        productTable.setItems(products);
        showProductInToTable();

        nameClientPurchase.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().nameClientPurchaseProperty());
        typeProductPurchase.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().typeProductPurchaseProperty());
        quantityProductPurchase.setCellValueFactory(cellData-> cellData.getValue().quantityProductPurchaseProperty().asObject());
        datePurchase.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().datePurchaseProperty());
        pricePurchase.setCellValueFactory(cellData-> cellData.getValue().pricePurchaseProperty().asObject());
        idProductPurchase.setCellValueFactory(cellData-> cellData.getValue().idProductPurchaseProperty().asObject());
        idPurchase.setCellValueFactory(cellData-> cellData.getValue().idPurchaseProperty().asObject());
        idClientPurchase.setCellValueFactory(cellData-> cellData.getValue().idClientPurchaseProperty().asObject());

        purchaseTable.setItems(purchases);
        showPurchaseInToTable();


        nameClientOrder.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().nameClientOrderProperty());
        nameMasterOrder.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().nameMasterOrderProperty());
        typeProductOrder.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().typeProductOrderProperty());
        quantityProductOrder.setCellValueFactory(cellData-> cellData.getValue().quantityProductOrderProperty().asObject());
        statusOrder.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().statusOrderProperty());
        priceOrder.setCellValueFactory(cellData-> cellData.getValue().priceOrderProperty().asObject());
        dateOrder.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().dateOrderProperty());
        idMasterOrder.setCellValueFactory(cellData-> cellData.getValue().idMasterOrderProperty().asObject());
        idClientOrder.setCellValueFactory(cellData-> cellData.getValue().idClientOrderProperty().asObject());
        idModelOrder.setCellValueFactory(cellData-> cellData.getValue().idModelOrderProperty().asObject());
        idOrder.setCellValueFactory(cellData-> cellData.getValue().idOrderProperty().asObject());

        orderTable.setItems(orders);
        showOrderInToTable();

    }

    ModelStandart modelStandart = new ModelStandart();

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /// Master ///
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    MasterModel masterModel = new MasterModel();
    @FXML
    private TextField findLastNameMaster;
    @FXML
    private TextField findINNMaster;

    public void showMasterInToTable() {
        masters.clear();
        masters.addAll(masterModel.getMasterList());
    } // GOOD

    public void onClickFindMaster(ActionEvent actionEvent) {
        masters.clear();
        masters.addAll(masterModel.getSelectMasterList(findLastNameMaster.getText(), findINNMaster.getText()));
    } // GOOD

    public void onClickEditMaster(ActionEvent actionEvent) throws IOException {

        Master selectedMaster = masterTable.getSelectionModel().getSelectedItem();

        if(selectedMaster != null) {

            Stage newWindow = new Stage();
            FXMLLoader loader = new FXMLLoader();

            ShowNewView(
                loader,
                newWindow,
                "View/editMaster.fxml",
                "Добавление клиента",
                250,
                250
            );

            MasterController masterController = loader.getController();
            masterController.setDialogStageMaster(newWindow);
            masterController.setMaster(selectedMaster);
            newWindow.showAndWait();
            showMasterInToTable();
            showProductInToTable();

        } else {
            modelStandart.ShowAlert("Выберете поле для изменения!");
        }
    } // GOOD

    public void onClickAddMaster(ActionEvent actionEvent) throws IOException {

        Stage newWindow = new Stage();
        FXMLLoader loader = new FXMLLoader();

        ShowNewView(
            loader,
            newWindow,
            "View/addMaster.fxml",
            "Добавление клиента",
            250,
            250
        );

        MasterController masterController = loader.getController();
        masterController.setDialogStageMaster(newWindow);
        newWindow.showAndWait();
        showMasterInToTable();
    } // GOOD

    public void onClickDeleteMaster(ActionEvent actionEvent) {
        Master masterDelete = masterTable.getSelectionModel().getSelectedItem();

        if(masterDelete != null) {
            if(masterModel.ChekMasterInToOrederAndPurches(masterDelete.getIdMaster())) {
                masterModel.deleteMaster(masterDelete.getIdMaster());
                showMasterInToTable();
            } else {
                modelStandart.ShowAlert("У данного мастера есть заказы или продукты");
            }
        } else {
            modelStandart.ShowAlert("Выберете поле для удаления!");
        }
    } // GOOD

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /// Client ///
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ClientModel clientModel = new ClientModel();

    @FXML
    private TextField findLastNameClient;
    @FXML
    private TextField findINNClient;

    public void showClientInToTable() {

        clients.clear();
        clients.addAll(clientModel.getClientList());
    } // GOOD

    public void onClickFindClient(ActionEvent actionEvent) {

        clients.clear();
        clients.addAll(clientModel.getSeletClientList(findLastNameClient.getText(), findINNClient.getText()));
    } // GOOD

    public void onClickEditClient(ActionEvent actionEvent)  throws IOException{

        Client selectedClient = clientTable.getSelectionModel().getSelectedItem();

        if(selectedClient != null) {

            Stage newWindow = new Stage();
            FXMLLoader loader = new FXMLLoader();

            ShowNewView(
                    loader,
                    newWindow,
                    "View/editClient.fxml",
                    "Добавление клиента",
                    250,
                    250
            );

            ClientController clientController = loader.getController();

            clientController.setDialogStageClient(newWindow);
            clientController.setClient(selectedClient);

            newWindow.showAndWait();
            showClientInToTable();

        } else {
            modelStandart.ShowAlert("Выберете поле для изменения!");
        }
    } // GOOD

    public void onClickAddClient(ActionEvent actionEvent) throws IOException {

        Stage newWindow = new Stage();
        FXMLLoader loader = new FXMLLoader();

        ShowNewView(
                loader,
                newWindow,
                "View/addClient.fxml",
                "Добавление клиента",
                250,
                250
        );

        ClientController clientController = loader.getController();
        clientController.setDialogStageClient(newWindow);

        newWindow.showAndWait();
        showClientInToTable();
    } // GOOD

    public void onClickDeleteClient(ActionEvent actionEvent) {

        Client clientDelete = clientTable.getSelectionModel().getSelectedItem();

        if(clientDelete != null) {
            if(clientModel.ChekClientInToOrederAndPurches(clientDelete.getIdClient())) {
                clientModel.deleteCleint(clientDelete.getIdClient());
                showClientInToTable();
            } else {
                modelStandart.ShowAlert("У данного клиента есть заказы или покупки");
            }
        } else {
            modelStandart.ShowAlert("Выберете поле для удаления!");
        }
    } // GOOD

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /// Model ///
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ModelModel modelModel = new ModelModel();
    @FXML
    private TextField findNameModel;

    public void showModelInToTable() {

        models.clear();
        models.addAll(modelModel.getModelList());
    } // GOOD

    public void onClickFindModel(ActionEvent actionEvent) {

        models.clear();
        models.addAll(modelModel.getSelectModelList(findNameModel.getText()));

    } // GOOD

    public void onClickEditModel(ActionEvent actionEvent) throws IOException {
        Model selectedModel = modelTable.getSelectionModel().getSelectedItem();

        if(selectedModel != null) {

            Stage newWindow = new Stage();
            FXMLLoader loader = new FXMLLoader();

            ShowNewView(
                    loader,
                    newWindow,
                    "View/editModel.fxml",
                    "Добавление клиента",
                    250,
                    250
            );

            ModelController modelController = loader.getController();
            modelController.setDialogStageModel(newWindow);
            modelController.setModel(selectedModel);

            newWindow.showAndWait();
            showModelInToTable();
            showProductInToTable();

        } else {
            modelStandart.ShowAlert("Выберете поле для изменения!");
        }
    } // GOOD

    public void onClickAddModel(ActionEvent actionEvent) throws IOException {
        Stage newWindow = new Stage();
        FXMLLoader loader = new FXMLLoader();

        ShowNewView(
                loader,
                newWindow,
                "View/addModel.fxml",
                "Добавление клиента",
                250,
                250
        );

        ModelController modelController = loader.getController();
        modelController.setDialogStageModel(newWindow);

        newWindow.showAndWait();
        showModelInToTable();
    } // GOOD

    public void onClickDeleteModel(ActionEvent actionEvent) {
        Model selectedModel = modelTable.getSelectionModel().getSelectedItem();

        if(selectedModel != null) {
            if(modelModel.ChekModelInToOrederAndPurches(selectedModel.getIdModel())) {
                modelModel.deleteModel(selectedModel.getIdModel());
                showModelInToTable();
            } else {
                modelStandart.ShowAlert("Удаление запрешено");
            }
        } else {
            modelStandart.ShowAlert("Выберете поле для удаления!");
        }
    } // GOOD

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /// Product ///
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ProductModel productModel = new ProductModel();
    @FXML
    private TextField findTypeProduct;

    public void showProductInToTable() {

        products.clear();
        products.addAll(productModel.getProductList());
    }

    public void onClickFindProduct(ActionEvent actionEvent) {

        products.clear();
        products.addAll(productModel.getSeletProductList(findTypeProduct.getText()));

    }

    public void onClickAddProduct(ActionEvent actionEvent) throws IOException {

        Stage newWindow = new Stage();
        FXMLLoader loader = new FXMLLoader();

        ShowNewView(
                loader,
                newWindow,
                "View/addProduct.fxml",
                "Добавление клиента",
                600,
                600
        );

        ProductController productController = loader.getController();
        productController.setDialogStageProduct(newWindow);

        newWindow.showAndWait();
        showProductInToTable();
    }

    public void onClickEditProduct(ActionEvent actionEvent) throws IOException  {
        Product selectProduct = productTable.getSelectionModel().getSelectedItem();

        if(selectProduct != null) {

            Stage newWindow = new Stage();
            FXMLLoader loader = new FXMLLoader();

            ShowNewView(
                    loader,
                    newWindow,
                    "View/editProduct.fxml",
                    "Добавление клиента",
                    600,
                    600
            );

            ProductController productController = loader.getController();
            productController.setDialogStageProduct(newWindow);
            productController.setProduct(selectProduct);
            newWindow.showAndWait();
            showProductInToTable();

        } else {
            modelStandart.ShowAlert("Выберете поле для удаления!");
        }
    }

    public void onClickDeleteProduct(ActionEvent actionEvent) {
        Product selectProduct = productTable.getSelectionModel().getSelectedItem();

        if(selectProduct != null) {
            if(productModel.ChekProductInToOrederAndPurches(selectProduct.getIdProduct())) {
                productModel.deleteProduct(selectProduct.getIdProduct());
                showProductInToTable();
            } else {
                modelStandart.ShowAlert("у данной модели есть покупки");
            }
        } else {
            modelStandart.ShowAlert("Выберете поле для удаления!");
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /// Purchase ///
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    PurchaseModel purchaseModel = new PurchaseModel();

    public void showPurchaseInToTable() {

        purchases.clear();
        purchases.addAll(purchaseModel.getPurchaseList());
    }

    public void onClickFindPurchase(ActionEvent actionEvent) {
    }

    public void onClickDeletePurchase(ActionEvent actionEvent) {
        Purchase selectPurchase = purchaseTable.getSelectionModel().getSelectedItem();

        if(selectPurchase != null) {
            purchaseModel.deletePurchase(selectPurchase.getIdPurchase());
            showPurchaseInToTable();
        } else {
            modelStandart.ShowAlert("Для отмены покупки выберете поле с покупкой");
        }
    }

    public void onClickAddPurchase(ActionEvent actionEvent) throws IOException  {

        Stage newWindow = new Stage();
        FXMLLoader loader = new FXMLLoader();

        ShowNewView(
                loader,
                newWindow,
                "View/addPurchase.fxml",
                "Добавление клиента",
                600,
                600
        );

        PurchaseController purchaseController = loader.getController();
        purchaseController.setDialogStagePurchase(newWindow);

        newWindow.showAndWait();
        showPurchaseInToTable();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /// Order ///
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    OrderModel orderModel = new OrderModel();

    public void showOrderInToTable() {
        orders.clear();
        orders.addAll(orderModel.getOrderList());
    }
    @FXML
    private TextField findLastNameClientOrder;
    @FXML
    private TextField findLastNameMasterOrder;

    public void onClickFindOrder(ActionEvent actionEvent) {
        orders.clear();
        orders.addAll(orderModel.getSeletOrderList(findLastNameClientOrder.getText(), findLastNameMasterOrder.getText()));
    }

    public void onClickEditStatusOrder(ActionEvent actionEvent) {
    }

    public void onClickDeleteOrder(ActionEvent actionEvent) {
    }

    public void onClickAddOrder(ActionEvent actionEvent) throws IOException {
        Stage newWindow = new Stage();
        FXMLLoader loader = new FXMLLoader();

        ShowNewView(
                loader,
                newWindow,
                "View/addOrder.fxml",
                "Офформление заказа",
                600,
                600
        );

        OrderController orderController = loader.getController();
        orderController.setDialogStageOrder(newWindow);

        newWindow.showAndWait();
        showOrderInToTable();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /// //////////////////////////////////////////////////////////////////////////////////////////////////////////// ///
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void ShowNewView(FXMLLoader loader, Stage newWindow, String path, String title, int height , int width) throws IOException {

        loader.setLocation(getClass().getResource(path));
        Parent root = loader.load();

        Scene scene = new Scene(root ,height,width);

        newWindow.setTitle(title);
        newWindow.setScene(scene);

        newWindow.setMinHeight(width);
        newWindow.setMinWidth(height);

        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.initOwner(Main.getPrimaryStage());
    }
}
