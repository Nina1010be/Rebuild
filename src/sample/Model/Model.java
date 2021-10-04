package sample.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
    private IntegerProperty idModel;
    private StringProperty nameModel;
    private StringProperty materialModel;
    private IntegerProperty priceModel;
    private StringProperty pictureModel;

    public Model(int idModel, String nameModel, String materialModel, int priceModel, String pictureModel) {
        this.idModel = new SimpleIntegerProperty(idModel);
        this.nameModel = new SimpleStringProperty(nameModel);
        this.materialModel = new SimpleStringProperty(materialModel);
        this.priceModel = new SimpleIntegerProperty(priceModel);
        this.pictureModel = new SimpleStringProperty(pictureModel);
    }

    public Model() {this(0,"", "", 0, "");}

    public void setIdModel(int idModel) {
        this.idModel.set(idModel);
    }
    public void setNameModel(String nameModel) {
        this.nameModel.set(nameModel);
    }
    public void setMaterialModel(String materialModel) {
        this.materialModel.set(materialModel);
    }
    public void setPriceModel(int priceModel) {
        this.priceModel.set(priceModel);
    }
    public void setPictureModel(String pictureModel) {
        this.pictureModel.set(pictureModel);
    }

    public int getIdModel() {
        return idModel.get();
    }
    public IntegerProperty idModelProperty() {
        return idModel;
    }

    public String getNameModel() {
        return nameModel.get();
    }
    public StringProperty nameModelProperty() {
        return nameModel;
    }

    public String getMaterialModel() {
        return materialModel.get();
    }
    public StringProperty materialModelProperty() {
        return materialModel;
    }

    public int getPriceModel() {
        return priceModel.get();
    }
    public IntegerProperty priceModelProperty() {
        return priceModel;
    }

    public String getPictureModel() {
        return pictureModel.get();
    }
    public StringProperty pictureModelProperty() {
        return pictureModel;
    }
}
