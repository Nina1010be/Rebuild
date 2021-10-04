package sample.ControllerPages;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Model.Client;
import sample.Model.Master;
import sample.Model.MasterModel;
import sample.Model.ModelStandart;

import java.util.ArrayList;

import static sample.Model.ModelStandart.*;

public class MasterController {
    @FXML
    private TextField newFirstNameMaster;
    @FXML
    private TextField newLastNameMaster;
    @FXML
    private TextField newPatronMaster;
    @FXML
    private TextField newPhoneNumberMaster;
    @FXML
    private TextField newINNMaster;

    private Stage dialogStageMaster;
    private Master master;
    ModelStandart modelStandart = new ModelStandart();

    public void setDialogStageMaster(Stage dialogStageMaster) {
        this.dialogStageMaster = dialogStageMaster;
    }
    public void onClickBackMaster(ActionEvent actionEvent) {
        dialogStageMaster.close();
    }

    MasterModel masterModel = new MasterModel();
    public void setMaster (Master master) {

        this.master = master;

        newFirstNameMaster.setText(master.getFirstNameMaster());
        newLastNameMaster.setText(master.getLastNameMaster());
        newPatronMaster.setText(master.getPatronMaster());
        newPhoneNumberMaster.setText(master.getPhoneNumberMaster());
        newINNMaster.setText(master.getInnMaster());

    }

    public void onClickAddMaster(ActionEvent actionEvent) {

        this.master = new Master();

        if(chekedRussionSymbol(newFirstNameMaster.getText())) {
            if(chekedRussionSymbol(newLastNameMaster.getText())) {
                if(chekedRussionSymbol((newPatronMaster.getText()))) {
                    if(newPhoneNumberMaster.getText().length() != 0
                            && tryParseInt(newPhoneNumberMaster.getText())
                            && newPhoneNumberMaster.getText().toCharArray()[0] == '8'
                            && newPhoneNumberMaster.getText().length() == 11){

                        ArrayList<String> phoneNumberList = new ArrayList<>();
                        ArrayList<Master> masterModelArrayList = masterModel.getMasterList();

                        for (var item: masterModelArrayList) { phoneNumberList.add(item.getPhoneNumberMaster()); }

                        if(checksUniquenessObjectInToDataBase(newPhoneNumberMaster.getText(), phoneNumberList))
                        {
                            if(newINNMaster.getText().length() != 0
                                    && newINNMaster.getText().length() == 11
                                    && tryParseInt(newINNMaster.getText())) {

                                ArrayList<String> innList = new ArrayList<>();
                                for (var item: masterModelArrayList) { innList.add(item.getInnMaster()); }

                                if(checksUniquenessObjectInToDataBase(newINNMaster.getText(), innList))
                                {
                                    this.master.setFirstNameMaster(newFirstNameMaster.getText());
                                    this.master.setLastNameMaster(newLastNameMaster.getText());
                                    this.master.setPatronMaster(newPatronMaster.getText());
                                    this.master.setPhoneNumberMaster(newPhoneNumberMaster.getText());
                                    this.master.setInnMaster(newINNMaster.getText());

                                    masterModel.addMaster(master);
                                    dialogStageMaster.close();

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

    public void onClickEditedMaster(ActionEvent actionEvent) {
        if(chekedRussionSymbol(newFirstNameMaster.getText())) {
            if(chekedRussionSymbol(newLastNameMaster.getText())) {
                if(chekedRussionSymbol((newPatronMaster.getText()))) {
                    if(newPhoneNumberMaster.getText().length() != 0
                        && tryParseInt(newPhoneNumberMaster.getText())
                        && newPhoneNumberMaster.getText().toCharArray()[0] == '8'
                        && newPhoneNumberMaster.getText().length() == 11){

                        if(newINNMaster.getText().length() != 0
                                && newINNMaster.getText().length() == 11
                                && tryParseInt(newINNMaster.getText())) {

                                this.master.setFirstNameMaster(newFirstNameMaster.getText());
                                this.master.setLastNameMaster(newLastNameMaster.getText());
                                this.master.setPatronMaster(newPatronMaster.getText());
                                this.master.setPhoneNumberMaster(newPhoneNumberMaster.getText());
                                this.master.setInnMaster(newINNMaster.getText());

                                masterModel.editMaster(master);
                                dialogStageMaster.close();
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
