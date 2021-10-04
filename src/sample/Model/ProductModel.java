package sample.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductModel {

    ModelStandart model = new ModelStandart();

    public ArrayList<Product> getProductList() {

        ArrayList<Product> productArrayList = new ArrayList<>();

        try (Connection conn = model.showSqlRequest()){

            Statement stmt = conn.createStatement();
            MasterModel masterModel = new MasterModel();
            ModelModel modelModel = new ModelModel();

            ResultSet rs = stmt.executeQuery("select * from product");

            while (rs.next()) {

                Product product = new Product();

                int idProduct = rs.getInt(1);
                int idMaster = rs.getInt(2);
                int idModel = rs.getInt(3);
                int quantityProduct = rs.getInt(4);
                int price = rs.getInt(5);

                product.setIdProduct(idProduct);
                product.setIdMasterProduct(idMaster);
                product.setIdModelProduct(idModel);
                product.setQuantityProduct(quantityProduct);
                product.setPriceProduct(price);

                Master master = masterModel.getMaster(idMaster);
                product.setNameMasterProduct(master.getLastNameMaster() + " " + master.getFirstNameMaster());

                Model model = modelModel.getModel(idModel);
                product.setTypeProduct(model.getNameModel());

                productArrayList.add(product);
            }
        }catch(Exception ex){

            System.out.println("Не коректное подключение");

            System.out.println(ex);
        }
        return productArrayList;
    }

    public void addProduct (Product product) {

        String commandSQL = "INSERT INTO product" +
                "(idMasterProduct" +
                ", idModelProduct" +
                ", quantityProduct" +
                ", priceProduct) VALUES (" +
                "'"+product.getIdMasterProduct() +"'," +
                "'"+product.getIdModelProduct()+"'," +
                "'"+product.getQuantityProduct()+"'," +
                "'"+product.getPriceProduct()+"');";

        model.invokeNonReturnableSqlRequest(commandSQL);
    }

    public void deleteProduct (int id) {

        String commandSQL = "DELETE FROM product WHERE idProduct = " + id;
        model.invokeNonReturnableSqlRequest(commandSQL);
    }
    public ArrayList<Product> getSeletProductList(String findTypeProduct) {//убрать щиты

        ArrayList<Product> productArrayList = new ArrayList<>();

        try (Connection conn = model.showSqlRequest()){

            Statement stmt = conn.createStatement();
            MasterModel masterModel = new MasterModel();
            ModelModel modelModel = new ModelModel();

            ResultSet rs = stmt.executeQuery("select * from product join model on  product.idModelProduct = model.idmodel where model.nameModel like '%" + findTypeProduct +"%';");

            while (rs.next()) {

                Product product = new Product();

                int idProduct = rs.getInt(1);
                int idMaster = rs.getInt(2);
                int idModel = rs.getInt(3);
                int quantityProduct = rs.getInt(4);
                int price = rs.getInt(5);

                product.setIdProduct(idProduct);
                product.setIdMasterProduct(idMaster);
                product.setIdModelProduct(idModel);
                product.setQuantityProduct(quantityProduct);
                product.setPriceProduct(price);

                Master master = masterModel.getMaster(idMaster);
                product.setNameMasterProduct(master.getLastNameMaster() + " " + master.getFirstNameMaster());

                Model model = modelModel.getModel(idModel);
                product.setTypeProduct(model.getNameModel());

                productArrayList.add(product);
            }
        }catch(Exception ex){

            System.out.println("Не коректное подключение");

            System.out.println(ex);
        }
        return productArrayList;
    }

    public Product getProduct (int id) {
        return null;
    }

    public void editProduct(Product product) {

        String commandSQL = "UPDATE product SET" +
                " idMasterProduct = '" + product.getIdMasterProduct() + "'" +
                ", idModelProduct = '" + product.getIdModelProduct() + "'" +
                ", quantityProduct = '" + product.getQuantityProduct() + "'" +
                ", priceProduct = '" + product.getPriceProduct() + "' WHERE idProduct = " + product.getIdProduct();

        model.invokeNonReturnableSqlRequest(commandSQL);
    }
    ModelStandart modelStandart = new ModelStandart();
    public Boolean ChekProductInToOrederAndPurches(int id) {

        try (Connection conn = modelStandart.showSqlRequest()){

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from purchase where idProductPurchase = " + id);

            while (rs.next()) {
                return false;
            }

        } catch(Exception ex) {

            System.out.println("Не коректное подключение");
            System.out.println(ex);
        }
        return true;
    }
}
