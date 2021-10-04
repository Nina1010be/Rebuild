package sample.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Master {

    private IntegerProperty idMaster;
    private StringProperty firstNameMaster;
    private StringProperty lastNameMaster;
    private StringProperty patronMaster;
    private StringProperty phoneNumberMaster;
    private StringProperty innMaster;

    public Master(int idMaster, String firstNameMaster, String lastNameMaster, String patronMaster, String phoneNumberMaster, String innMaster) {

        this.idMaster = new SimpleIntegerProperty(idMaster);
        this.firstNameMaster = new SimpleStringProperty(firstNameMaster);
        this.lastNameMaster = new SimpleStringProperty(lastNameMaster);
        this.patronMaster = new SimpleStringProperty(patronMaster);
        this.phoneNumberMaster = new SimpleStringProperty(phoneNumberMaster);
        this.innMaster = new SimpleStringProperty(innMaster);
    }

    public Master() {
        this(0,"", "", "", "", "");
    }

    public void setIdMaster(int idMaster) {
        this.idMaster.set(idMaster);
    }
    public void setFirstNameMaster(String firstNameMaster) {
        this.firstNameMaster.set(firstNameMaster);
    }
    public void setLastNameMaster(String lastNameMaster) {
        this.lastNameMaster.set(lastNameMaster);
    }
    public void setPatronMaster(String patronMaster) {
        this.patronMaster.set(patronMaster);
    }
    public void setPhoneNumberMaster(String phoneNumberMaster) {
        this.phoneNumberMaster.set(phoneNumberMaster);
    }
    public void setInnMaster(String innMaster) {
        this.innMaster.set(innMaster);
    }

    public int getIdMaster() {
        return idMaster.get();
    }
    public IntegerProperty idMasterProperty() {
        return idMaster;
    }

    public String getFirstNameMaster() {
        return firstNameMaster.get();
    }
    public StringProperty firstNameMasterProperty() {
        return firstNameMaster;
    }

    public String getLastNameMaster() {
        return lastNameMaster.get();
    }
    public StringProperty lastNameMasterProperty() {
        return lastNameMaster;
    }

    public String getPatronMaster() {
        return patronMaster.get();
    }
    public StringProperty patronMasterProperty() {
        return patronMaster;
    }

    public String getPhoneNumberMaster() {
        return phoneNumberMaster.get();
    }
    public StringProperty phoneNumberMasterProperty() {
        return phoneNumberMaster;
    }

    public String getInnMaster() {
        return innMaster.get();
    }
    public StringProperty innMasterProperty() {
        return innMaster;
    }


}
