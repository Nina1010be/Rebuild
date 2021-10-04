package sample.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PurchaseModel {
    ModelStandart model = new ModelStandart();

    public ArrayList<Purchase> getPurchaseList() {

        ArrayList<Purchase> purchaseArrayList = new ArrayList<>();

        try (Connection conn = model.showSqlRequest()){

            Statement stmt = conn.createStatement();
            MasterModel masterModel = new MasterModel();
            ModelModel modelModel = new ModelModel();

            ResultSet rs = stmt.executeQuery("select * from purchase");

            while (rs.next()) {

                Purchase purchase = new Purchase();

                int idPurchase = rs.getInt(1);
                int idClient = rs.getInt(2);
                int idProduct = rs.getInt(3);
                String nameClient = rs.getString(4);
                int quantityProduct = rs.getInt(5);
                String date = rs.getString(6);
                int price = rs.getInt(7);

                purchase.setIdProductPurchase(idProduct);
                purchase.setIdPurchase(idPurchase);
                purchase.setIdClientPurchase(idClient);
                purchase.setNameClientPurchase(nameClient);
                purchase.setQuantityProductPurchase(quantityProduct);
                purchase.setDatePurchase(date);
                purchase.setPricePurchase(price);

                purchaseArrayList.add(purchase);

            }
        }catch(Exception ex){

            System.out.println("Не коректное подключение");

            System.out.println(ex);
        }
        return purchaseArrayList;
    }

    public void addPurchase (Purchase purchase) {

        String commandSQL = "INSERT INTO purchase" +
                "(idClientPurchase" +
                ", idProductPurchase" +
                ", nameClientPurchase" +
                ", quantityProductPurchase" +
                ", datePurchase" +
                ", pricePurchase) VALUES (" +
                "'"+purchase.getIdClientPurchase() +"'," +
                "'"+purchase.getIdProductPurchase()+"'," +
                "'"+purchase.getNameClientPurchase()+"'," +
                "'"+purchase.getQuantityProductPurchase()+"'," +
                "'"+purchase.getDatePurchase()+"'," +
                "'"+purchase.getPricePurchase()+"');";

        model.invokeNonReturnableSqlRequest(commandSQL);
    }

    public void deletePurchase (int id) {

        String commandSQL = "DELETE FROM purchase WHERE idPurchase = " + id;
        model.invokeNonReturnableSqlRequest(commandSQL);
    }

}
