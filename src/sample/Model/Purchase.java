package sample.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Purchase {
    private IntegerProperty idProductPurchase;
    private IntegerProperty idPurchase;
    private IntegerProperty idClientPurchase;
    private StringProperty nameClientPurchase;
    private StringProperty typeProductPurchase;
    private IntegerProperty quantityProductPurchase;
    private StringProperty datePurchase;
    private IntegerProperty pricePurchase;


    public Purchase(int idProductPurchase, int idPurchase, int idClientPurchase, String nameClientPurchase, String typeProductPurchase, int quantityProductPurchase, String datePurchase, int pricePurchase) {
        this.idProductPurchase = new SimpleIntegerProperty(idProductPurchase);
        this.idPurchase = new SimpleIntegerProperty(idPurchase);
        this.idClientPurchase = new SimpleIntegerProperty(idClientPurchase);
        this.nameClientPurchase = new SimpleStringProperty(nameClientPurchase);
        this.typeProductPurchase = new SimpleStringProperty(typeProductPurchase);
        this.quantityProductPurchase = new SimpleIntegerProperty(quantityProductPurchase);
        this.datePurchase = new SimpleStringProperty(datePurchase);
        this.pricePurchase = new SimpleIntegerProperty(pricePurchase);
    }

    public Purchase() {this(0,0,0,"", "", 0, "", 0);}

    public int getIdPurchase() {
        return idPurchase.get();
    }
    public IntegerProperty idPurchaseProperty() {
        return idPurchase;
    }
    public void setIdPurchase(int idPurchase) {
        this.idPurchase.set(idPurchase);
    }

    public int getIdProductPurchase() {
        return idProductPurchase.get();
    }
    public IntegerProperty idProductPurchaseProperty() {
        return idProductPurchase;
    }
    public void setIdProductPurchase(int idProductPurchase) {
        this.idProductPurchase.set(idProductPurchase);
    }

    public int getIdClientPurchase() {
        return idClientPurchase.get();
    }
    public IntegerProperty idClientPurchaseProperty() {
        return idClientPurchase;
    }
    public void setIdClientPurchase(int idClientPurchase) {
        this.idClientPurchase.set(idClientPurchase);
    }

    public String getNameClientPurchase() {
        return nameClientPurchase.get();
    }
    public StringProperty nameClientPurchaseProperty() {
        return nameClientPurchase;
    }
    public void setNameClientPurchase(String nameClientPurchase) {
        this.nameClientPurchase.set(nameClientPurchase);
    }

    public String getTypeProductPurchase() {
        return typeProductPurchase.get();
    }
    public StringProperty typeProductPurchaseProperty() {
        return typeProductPurchase;
    }
    public void setTypeProductPurchase(String typeProductPurchase) {this.typeProductPurchase.set(typeProductPurchase);}

    public int getQuantityProductPurchase() {
        return quantityProductPurchase.get();
    }
    public IntegerProperty quantityProductPurchaseProperty() {
        return quantityProductPurchase;
    }
    public void setQuantityProductPurchase(int quantityProductPurchase) {this.quantityProductPurchase.set(quantityProductPurchase);}

    public String getDatePurchase() {
        return datePurchase.get();
    }
    public StringProperty datePurchaseProperty() {
        return datePurchase;
    }
    public void setDatePurchase(String datePurchase) {
        this.datePurchase.set(datePurchase);
    }

    public int getPricePurchase() {
        return pricePurchase.get();
    }
    public IntegerProperty pricePurchaseProperty() {
        return pricePurchase;
    }
    public void setPricePurchase(int pricePurchase) {
        this.pricePurchase.set(pricePurchase);
    }
}
