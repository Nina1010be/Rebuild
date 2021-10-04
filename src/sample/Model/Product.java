package sample.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Product {
    private IntegerProperty idProduct;
    private IntegerProperty idMasterProduct;
    private IntegerProperty idModelProduct;
    private StringProperty typeProduct;
    private StringProperty nameMasterProduct;
    private IntegerProperty quantityProduct;
    private IntegerProperty priceProduct;

    public Product(int idProduct, int idMasterProduct, int idModelProduct, int idStatusProduct, String typeProduct, String nameMasterProduct, int quantityProduct, String statusProduct, int priceProduct) {
        this.idProduct = new SimpleIntegerProperty(idProduct);
        this.idMasterProduct = new SimpleIntegerProperty(idMasterProduct);
        this.idModelProduct = new SimpleIntegerProperty(idModelProduct);
        this.typeProduct = new SimpleStringProperty(typeProduct);
        this.nameMasterProduct = new SimpleStringProperty(nameMasterProduct);
        this.quantityProduct = new SimpleIntegerProperty(quantityProduct);
        this.priceProduct = new SimpleIntegerProperty(priceProduct);
    }

    public Product() {this(0,0,0,0,"", "", 0, "", 0);}

    public int getIdProduct() {
        return idProduct.get();
    }
    public IntegerProperty idProductProperty() {
        return idProduct;
    }
    public void setIdProduct(int idProduct) {
        this.idProduct.set(idProduct);
    }

    public int getIdMasterProduct() {return idMasterProduct.get();}
    public IntegerProperty idMasterProductProperty() {
        return idMasterProduct;
    }
    public void setIdMasterProduct(int idMasterProduct) {
        this.idMasterProduct.set(idMasterProduct);
    }

    public int getIdModelProduct() {
        return idModelProduct.get();
    }
    public IntegerProperty idModelProductProperty() {
        return idModelProduct;
    }
    public void setIdModelProduct(int idModelProduct) {
        this.idModelProduct.set(idModelProduct);
    }

    public String getTypeProduct() {
        return typeProduct.get();
    }
    public StringProperty typeProductProperty() {
        return typeProduct;
    }
    public void setTypeProduct(String typeProduct) {
        this.typeProduct.set(typeProduct);
    }

    public String getNameMasterProduct() {
        return nameMasterProduct.get();
    }
    public StringProperty nameMasterProductProperty() {
        return nameMasterProduct;
    }
    public void setNameMasterProduct(String nameMasterProduct) {
        this.nameMasterProduct.set(nameMasterProduct);
    }

    public int getQuantityProduct() {
        return quantityProduct.get();
    }
    public IntegerProperty quantityProductProperty() {
        return quantityProduct;
    }
    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct.set(quantityProduct);
    }

    public int getPriceProduct() {
        return priceProduct.get();
    }
    public IntegerProperty priceProductProperty() {
        return priceProduct;
    }
    public void setPriceProduct(int priceProduct) {
        this.priceProduct.set(priceProduct);
    }
}
