package sample.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {

    private IntegerProperty idClient;//Они позволяет автоматические получать уведомления при любых изменениях переменных. Это позволяет поддерживать синхронность представления и данных.
    private StringProperty firstNameClient;
    private StringProperty lastNameClient;
    private StringProperty patronClient;
    private StringProperty phoneNumberClient;
    private StringProperty innClient;

    public Client(int idClient, String firstNameClient, String lastNameClient, String patronClient, String phoneNumberClient, String innClient) {
        this.idClient = new SimpleIntegerProperty(idClient);
        this.firstNameClient = new SimpleStringProperty(firstNameClient);
        this.lastNameClient = new SimpleStringProperty(lastNameClient);
        this.patronClient = new SimpleStringProperty(patronClient);
        this.phoneNumberClient = new SimpleStringProperty(phoneNumberClient);
        this.innClient = new SimpleStringProperty(innClient);
    }

    public Client() {
        this(0,"", "", "", "", "");
    }

    public void setIdClient(int idClient) {
        this.idClient.set(idClient);
    }
    public void setFirstNameClient(String firstNameClient) {
        this.firstNameClient.set(firstNameClient);
    }
    public void setLastNameClient(String lastNameClient) {
        this.lastNameClient.set(lastNameClient);
    }
    public void setPatronClient(String patronClient) {
        this.patronClient.set(patronClient);
    }
    public void setPhoneNumberClient(String phoneNumberClient) {
        this.phoneNumberClient.set(phoneNumberClient);
    }
    public void setInnClient(String innClient) {
        this.innClient.set(innClient);
    }

    public int getIdClient() {
        return idClient.get();
    }
    public IntegerProperty idClientProperty() {
        return idClient;
    }

    public String getFirstNameClient() {
        return firstNameClient.get();
    }
    public StringProperty firstNameClientProperty() {
        return firstNameClient;
    }

    public String getLastNameClient() {
        return lastNameClient.get();
    }
    public StringProperty lastNameClientProperty() {
        return lastNameClient;
    }

    public String getPatronClient() {
        return patronClient.get();
    }
    public StringProperty patronClientProperty() {
        return patronClient;
    }

    public String getPhoneNumberClient() {
        return phoneNumberClient.get();
    }
    public StringProperty phoneNumberClientProperty() {
        return phoneNumberClient;
    }

    public String getInnClient() {
        return innClient.get();
    }
    public StringProperty innClientProperty() {
        return innClient;
    }


}
