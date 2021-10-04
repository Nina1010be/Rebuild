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

public class OrderController {



    @FXML
    private Label selectedClientOrder;
    @FXML
    private Label selectedModelOrder;
    @FXML
    private Label selectedMasterOrder;

    @FXML
    private Label electedClientOrder;
    @FXML
    private Label editedSelectedModelOrder;
    @FXML
    private Label editedSelectedMasterOrder;
    @FXML
    private TextField editedQuantityOrder;

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

    public TableView<Client> clientTable;
    public TableColumn<Client, String> firstNameClient;
    public TableColumn<Client, String> lastNameClient;
    public TableColumn<Client, String> patronClient;
    public TableColumn<Client, String> phoneNumberClient;
    public TableColumn<Client, String> innClient;
    public TableColumn<Client, Integer> idClient;
    private ObservableList<Client> clients = FXCollections.observableArrayList();

    ModelStandart modelStandart = new ModelStandart();

    @FXML
    void initialize(){

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

        idClient.setCellValueFactory(cellData-> cellData.getValue().idClientProperty().asObject());
        firstNameClient.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().firstNameClientProperty());
        lastNameClient.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().lastNameClientProperty());
        patronClient.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().patronClientProperty());
        phoneNumberClient.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().phoneNumberClientProperty());
        innClient.setCellValueFactory(clientStringCellDataFeatures -> clientStringCellDataFeatures.getValue().innClientProperty());

        clientTable.setItems(clients);
        showClientInToTable();
    }

    MasterModel masterModel = new MasterModel();
    public void showMasterInToTable() {
        masters.clear();
        masters.addAll(masterModel.getMasterList());
    }

    ClientModel clientModel = new ClientModel();
    public void showClientInToTable() {

        clients.clear();
        clients.addAll(clientModel.getClientList());
    }

    ModelModel modelModel = new ModelModel();
    public void showModelInToTable() {

        models.clear();
        models.addAll(modelModel.getModelList());
    }

    private Stage dialogStageOrder;
    private Order order;

    public void setDialogStageOrder(Stage dialogStageOrder) {
        this.dialogStageOrder = dialogStageOrder;
    }
    public void onClickBackOrder(ActionEvent actionEvent) {
        dialogStageOrder.close();
    }

    OrderModel orderModel = new OrderModel();
    public void setOrder (Order order) {

        this.order = order;

        newQuantityOrder.setText(String.valueOf(order.getQuantityProductOrder()));
        selectedClientOrder.setText(order.getNameClientOrder());
        selectedModelOrder.setText(order.getTypeProductOrder());
        selectedMasterOrder.setText(order.getNameMasterOrder());

        editedQuantityOrder.setText(String.valueOf(order.getQuantityProductOrder()));
        electedClientOrder.setText(order.getNameClientOrder());
        editedSelectedModelOrder.setText(order.getTypeProductOrder());
        editedSelectedMasterOrder.setText(order.getNameMasterOrder());
    }

    @FXML
    private TextField findINNClient;
    @FXML
    private TextField findLastNameClient;

    public void onClickFindClient(ActionEvent actionEvent) {

        clients.clear();
        clients.addAll(clientModel.getSeletClientList(findLastNameClient.getText(), findINNClient.getText()));
    }

    @FXML
    private TextField findNameModel;

    public void onClickFindModel(ActionEvent actionEvent) {
        models.clear();
        models.addAll(modelModel.getSelectModelList(findNameModel.getText()));
    }

    @FXML
    private TextField findLastNameMaster;
    @FXML
    private TextField findINNMaster;

    public void onClickFindMaster(ActionEvent actionEvent) {
        masters.clear();
        masters.addAll(masterModel.getSelectMasterList(findLastNameMaster.getText(),findINNMaster.getText()));
    }

    @FXML
    private TextField newQuantityOrder;

    public void onClickAddNewOrder(ActionEvent actionEvent) {

        Model selectedModel = modelTable.getSelectionModel().getSelectedItem();
        Client selectClient = clientTable.getSelectionModel().getSelectedItem();
        Master selectMaster = masterTable.getSelectionModel().getSelectedItem();
        order = new Order();
        if(selectedModel != null) {
            if(selectClient != null) {
                if(selectMaster != null) {

                    order.setIdClientOrder(selectClient.getIdClient());
                    order.setIdMasterOrder(selectMaster.getIdMaster());
                    order.setIdModelOrder(selectedModel.getIdModel());
                    Date date = new Date();
                    order.setDateOrder(date.toString());
                    order.setPriceOrder(selectedModel.getPriceModel() * Integer.valueOf(newQuantityOrder.getText()));
                    order.setStatusOrder("Изделие в разработке");
                    order.setQuantityProductOrder(Integer.valueOf(newQuantityOrder.getText()));

                    orderModel.addOrder(order);
                    dialogStageOrder.close();
                } else {
                    modelStandart.ShowAlert("Не выбран мастер");
                }
            } else {
                modelStandart.ShowAlert("Не выбран клиент");
            }
        } else {
            modelStandart.ShowAlert("Не выбрана модель");
        }
    }
}
