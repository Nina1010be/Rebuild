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

import static sample.Model.ModelStandart.tryParseInt;

public class ProductController {

    @FXML
    private TextField findNameModel;
    @FXML
    private TextField findLastNameMaster;
    @FXML
    private TextField findINNMaster;
    @FXML
    private TextField newQuantityProduct;
    @FXML
    private Label selectedMasterProduct;
    @FXML
    private Label selectedModelProduct;

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

    @FXML
    void initialize(){

        firstNameMaster.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().firstNameMasterProperty());
        lastNameMaster.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().lastNameMasterProperty());
        patronMaster.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().patronMasterProperty());
        phoneNumberMaster.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().phoneNumberMasterProperty());
        innMaster.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().innMasterProperty());
        idMaster.setCellValueFactory(cellData-> cellData.getValue().idMasterProperty().asObject());

        masterTable.setItems(masters);

        nameModel.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().nameModelProperty());
        materialModel.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().materialModelProperty());
        priceModel.setCellValueFactory(cellData-> cellData.getValue().priceModelProperty().asObject());
        pictureModel.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().pictureModelProperty());
        idModel.setCellValueFactory(cellData-> cellData.getValue().idModelProperty().asObject());

        modelTable.setItems(models);
        showInToTable();
    }

    private Stage dialogStageProduct;
    private Product product;

    public void setDialogStageProduct(Stage dialogStageProduct) {
        this.dialogStageProduct = dialogStageProduct;
    }
    public void onClickBackProduct(ActionEvent actionEvent) {
        dialogStageProduct.close();
    }

    public void setProduct (Product product) {
        this.product = product;
        selectedMasterProduct.setText(product.getNameMasterProduct());
        selectedModelProduct.setText(product.getTypeProduct());
        newQuantityProduct.setText(String.valueOf(product.getQuantityProduct()));
    }

    MasterModel masterModel = new MasterModel();
    ModelModel modelModel = new ModelModel();
    ProductModel productModel = new ProductModel();

    public void showInToTable() {

        models.clear();
        models.addAll(modelModel.getModelList());
        masters.clear();
        masters.addAll(masterModel.getMasterList());
    }
    public void onClickFindModel(ActionEvent actionEvent) {

        models.clear();
        models.addAll(modelModel.getSelectModelList(findNameModel.getText()));
    }
    public void onClickFindMaster(ActionEvent actionEvent) {

        masters.clear();
        masters.addAll(masterModel.getSelectMasterList(findLastNameMaster.getText(), findINNMaster.getText()));
    }
    ModelStandart modelStandart = new ModelStandart();
    public void onClickAddNewProduct(ActionEvent actionEvent) {

        Master selectedMaster = masterTable.getSelectionModel().getSelectedItem();
        Model selectedModel = modelTable.getSelectionModel().getSelectedItem();

        Product product = new Product();

        if(selectedMaster != null && selectedModel != null) {
            if(tryParseInt(newQuantityProduct.getText())) {

                product.setIdModelProduct(selectedModel.getIdModel());
                product.setIdMasterProduct(selectedMaster.getIdMaster());
                product.setQuantityProduct(Integer.valueOf(newQuantityProduct.getText()));
                product.setPriceProduct(selectedModel.getPriceModel());

                productModel.addProduct(product);
                dialogStageProduct.close();

            } else {
                modelStandart.ShowAlert("Ошибка");
            }

        } else {
            modelStandart.ShowAlert("Ошибка");
        }

    }
    public void onClickEditedNewProduct(ActionEvent actionEvent) {

        Master selectedMaster = masterTable.getSelectionModel().getSelectedItem();

        if(selectedMaster != null) {
            product.setIdMasterProduct(selectedMaster.getIdMaster());
        }

        Model selectedModel = modelTable.getSelectionModel().getSelectedItem();

        if(selectedModel != null) {
            product.setIdModelProduct(selectedModel.getIdModel());
            product.setPriceProduct(selectedModel.getPriceModel());
        }

        if(tryParseInt(newQuantityProduct.getText()) && newQuantityProduct.getText() != "") {

            product.setQuantityProduct(Integer.valueOf(newQuantityProduct.getText()));
        }

        productModel.editProduct(product);
        dialogStageProduct.close();
    }
}
