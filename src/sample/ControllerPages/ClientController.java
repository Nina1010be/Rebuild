package sample.ControllerPages;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Model.Client;
import sample.Model.ClientModel;
import sample.Model.ModelStandart;

import java.util.ArrayList;

import static sample.Model.ModelStandart.*;

public class ClientController {

    @FXML
    private TextField newFirstNameClient;
    @FXML
    private TextField newLastNameClient;
    @FXML
    private TextField newPatronClient;
    @FXML
    private TextField newPhoneNumberClient;
    @FXML
    private TextField newINNClient;

    private Stage dialogStageClient;
    private Client client;

    ModelStandart modelStandart = new ModelStandart();

    public void setDialogStageClient(Stage dialogStageClient) {
        this.dialogStageClient = dialogStageClient;
    }
    public void onClickBackClient(ActionEvent actionEvent) {
        dialogStageClient.close();
    }

    ClientModel clientModel = new ClientModel();
    public void setClient (Client client) {

        this.client = client;

        newFirstNameClient.setText(client.getFirstNameClient());
        newLastNameClient.setText(client.getLastNameClient());
        newPatronClient.setText(client.getPatronClient());
        newPhoneNumberClient.setText(client.getPhoneNumberClient());
        newINNClient.setText(client.getInnClient());

    }

    public void onClickAddClient(ActionEvent actionEvent) {

        this.client = new Client();

        if(chekedRussionSymbol(newFirstNameClient.getText())) {
            if(chekedRussionSymbol(newLastNameClient.getText())) {
                if(chekedRussionSymbol(newPatronClient.getText())) {
                    if(newPhoneNumberClient.getText().length() != 0
                        && tryParseInt(newPhoneNumberClient.getText())
                        && newPhoneNumberClient.getText().toCharArray()[0] == '8'
                        && newPhoneNumberClient.getText().length() == 11){

                        ArrayList<String> phoneNumberList = new ArrayList<>();
                        ArrayList<Client> clientModelArrayList = clientModel.getClientList();

                        for (var item: clientModelArrayList) { phoneNumberList.add(item.getPhoneNumberClient()); }

                        if(checksUniquenessObjectInToDataBase(newPhoneNumberClient.getText(), phoneNumberList))
                        {
                            if(newINNClient.getText().length() != 0
                                    && newINNClient.getText().length() == 11
                                    && tryParseInt(newINNClient.getText())) {

                                ArrayList<String> innList = new ArrayList<>();
                                for (var item: clientModelArrayList) { innList.add(item.getInnClient()); }

                                if(checksUniquenessObjectInToDataBase(newINNClient.getText(), innList))
                                {
                                    this.client.setFirstNameClient(newFirstNameClient.getText());
                                    this.client.setLastNameClient(newLastNameClient.getText());
                                    this.client.setPatronClient(newPatronClient.getText());
                                    this.client.setPhoneNumberClient(newPhoneNumberClient.getText());
                                    this.client.setInnClient(newINNClient.getText());

                                    clientModel.addClient(client);
                                    dialogStageClient.close();

                                } else {
                                    modelStandart.ShowAlert("такой INN уже указан");
                                }
                            } else {
                                modelStandart.ShowAlert("INN указан не верно");
                            }
                        } else {
                            modelStandart.ShowAlert("Данный номер уже есть в базе данных");
                        }
                    } else {
                        modelStandart.ShowAlert("Номер указан не верно");
                    }
                } else {
                    modelStandart.ShowAlert("Отчество указанно не верно");
                }
            } else {
                modelStandart.ShowAlert("Фамилия указанна не верно");
            }
        } else {
            modelStandart.ShowAlert("Имя указанно не верно");
        }
    }

    public void onClickEditedClient(ActionEvent actionEvent) {
        if(chekedRussionSymbol(newFirstNameClient.getText())) {
            if(chekedRussionSymbol(newLastNameClient.getText())) {
                if(chekedRussionSymbol(newPatronClient.getText())) {
                    if(newPhoneNumberClient.getText().length() != 0
                            && tryParseInt(newPhoneNumberClient.getText())
                            && newPhoneNumberClient.getText().toCharArray()[0] == '8'
                            && newPhoneNumberClient.getText().length() == 11){

                        if(newINNClient.getText().length() != 0
                                && newINNClient.getText().length() == 11
                                && tryParseInt(newINNClient.getText())) {

                            this.client.setFirstNameClient(newFirstNameClient.getText());
                            this.client.setLastNameClient(newLastNameClient.getText());
                            this.client.setPatronClient(newPatronClient.getText());
                            this.client.setPhoneNumberClient(newPhoneNumberClient.getText());
                            this.client.setInnClient(newINNClient.getText());

                            clientModel.editClient(client);
                            dialogStageClient.close();

                        } else {
                            modelStandart.ShowAlert("INN указан не верно");
                        }

                    } else {
                        modelStandart.ShowAlert("Номер указан не верно");
                    }
                } else {
                    modelStandart.ShowAlert("Отчество указанно не верно");
                }
            } else {
                modelStandart.ShowAlert("Фамилия указанна не верно");
            }
        } else {
            modelStandart.ShowAlert("Имя указанно не верно");
        }
    }
}
