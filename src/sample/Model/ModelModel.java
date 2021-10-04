package sample.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ModelModel {

    ModelStandart modelStandart = new ModelStandart();

    public ArrayList<Model> getModelList() {
        ArrayList<Model> modelArrayList = new ArrayList<>();

        try (Connection conn = modelStandart.showSqlRequest()){

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from model");

            while (rs.next()) {

                Model model = new Model();

                int id = rs.getInt(1);
                String nameModel = rs.getString(2);
                String materialModel = rs.getString(3);
                int priceModel = rs.getInt(4);
                String pictureModel = rs.getString(5);


                model.setIdModel(id);
                model.setNameModel(nameModel);
                model.setMaterialModel(materialModel);
                model.setPriceModel(priceModel);
                model.setPictureModel(pictureModel);

                modelArrayList.add(model);
            }
        }catch(Exception ex){

            System.out.println("Не коректное подключение");

            System.out.println(ex);
        }
        return  modelArrayList;
    }

    public void addModel (Model model) {

        String commandSQL = "INSERT INTO model" +
                "(nameModel" +
                ", materialModel" +
                ", priceModel" +
                ", pictureModel) VALUES (" +
                "'"+model.getNameModel() +"'," +
                "'"+model.getMaterialModel()+"'," +
                "'"+model.getPriceModel()+"'," +
                "'"+model.getPictureModel()+"');";

        modelStandart.invokeNonReturnableSqlRequest(commandSQL);
    }

    public void deleteModel (int id) {

        String commandSQL = "DELETE FROM model WHERE idmodel = " + id;
        modelStandart.invokeNonReturnableSqlRequest(commandSQL);
    }

    public ArrayList<Model> getSelectModelList(String modelNameSelected) {

        ArrayList<Model> modelArrayList = new ArrayList<>();

        try (Connection conn = modelStandart.showSqlRequest()){

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from model where " +
                    "nameModel like '%" + modelNameSelected + "%'");

            while (rs.next()) {

                Model model = new Model();

                int id = rs.getInt(1);
                String nameModel = rs.getString(2);
                String materialModel = rs.getString(3);
                int priceModel = rs.getInt(4);
                String pictureModel = rs.getString(5);


                model.setIdModel(id);
                model.setNameModel(nameModel);
                model.setMaterialModel(materialModel);
                model.setPriceModel(priceModel);
                model.setPictureModel(pictureModel);

                modelArrayList.add(model);
            }
        } catch(Exception ex) {

            System.out.println("Не коректное подключение");
            System.out.println(ex);
        }

        return modelArrayList;
    }

    public Model getModel (int idModel) {
        Model model = new Model();

        try (Connection conn = modelStandart.showSqlRequest()){

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from model where idmodel = " + idModel);

            while (rs.next()) {

                int id = rs.getInt(1);
                String nameModel = rs.getString(2);
                String materialModel = rs.getString(3);
                int priceModel = rs.getInt(4);
                String pictureModel = rs.getString(5);


                model.setIdModel(id);
                model.setNameModel(nameModel);
                model.setMaterialModel(materialModel);
                model.setPriceModel(priceModel);
                model.setPictureModel(pictureModel);
            }
        }catch(Exception ex){

            System.out.println("Не коректное подключение");

            System.out.println(ex);
        }
        return  model;
    }

    public void editModel(Model model) {
        String commandSQL = "UPDATE model SET" +
                " nameModel = '" + model.getNameModel() + "'" +
                ", materialModel = '" + model.getMaterialModel() + "'" +
                ", priceModel = '" + model.getPriceModel() + "'" +
                ", pictureModel = '" + model.getPictureModel() + "' WHERE idmodel = " + model.getIdModel();

        modelStandart.invokeNonReturnableSqlRequest(commandSQL);
    }
    public Boolean ChekModelInToOrederAndPurches(int id) {
        try (Connection conn = modelStandart.showSqlRequest()){

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from product where idModelProduct = " + id);

            while (rs.next()) {
                return false;
            }

        } catch(Exception ex) {

            System.out.println("Не коректное подключение");
            System.out.println(ex);
        }
        try (Connection conn1 = modelStandart.showSqlRequest()){

            Statement stmt1 = conn1.createStatement();
            ResultSet rs1 = stmt1.executeQuery("select * from `order` where idModelOrder = " + id);

            while (rs1.next()) {
                return false;
            }

        } catch(Exception ex) {

            System.out.println("Не коректное подключение");
            System.out.println(ex);
        }

        return true;
    }
}
