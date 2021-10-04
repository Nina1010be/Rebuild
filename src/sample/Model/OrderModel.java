package sample.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderModel {

    ModelStandart model = new ModelStandart();
    ClientModel clientModel = new ClientModel();
    MasterModel masterModel = new MasterModel();
    ModelModel modelModel = new ModelModel();

    public ArrayList<Order> getOrderList() {

        ArrayList<Order> orderArrayList = new ArrayList<>();

        try (Connection conn = model.showSqlRequest()){

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `order`");

            while (rs.next()) {

                Order order = new Order();

                int idOrder = rs.getInt(1);
                int idMaster = rs.getInt(2);
                int idClient = rs.getInt(3);
                int idModel = rs.getInt(4);
                int quantityProduct = rs.getInt(5);
                String status = rs.getString(6);
                int price = rs.getInt(7);
                String date = rs.getString(8);

                order.setIdOrder(idOrder);
                order.setIdMasterOrder(idMaster);
                order.setIdClientOrder(idClient);
                order.setIdModelOrder(idModel);
                order.setQuantityProductOrder(quantityProduct);
                order.setStatusOrder(status);
                order.setPriceOrder(price);
                order.setDateOrder(date);

                Client client = clientModel.getClient(order.getIdClientOrder());
                if(client != null) {
                    order.setNameClientOrder(client.getLastNameClient());
                }
                Master master =  masterModel.getMaster(order.getIdMasterOrder());
                if(master != null) {
                    order.setNameMasterOrder(master.getLastNameMaster());
                }
                Model model = modelModel.getModel(order.getIdModelOrder());
                if(model != null) {
                    order.setTypeProductOrder(model.getNameModel());
                }
                orderArrayList.add(order);
            }
        }catch(Exception ex){

            System.out.println("Не коректное подключение");
            System.out.println(ex);
        }

        return orderArrayList;
    }

    public void addOrder (Order order) {

        String commandSQL = "INSERT INTO `order` " +
                "(idMasterOrder" +
                ", idClientOrder" +
                ", idModelOrder" +
                ", quantityProductOrder" +
                ", statusOrder" +
                ", priceOrder" +
                ", dateOrder) VALUES (" +
                "'"+order.getIdMasterOrder() +"'," +
                "'"+order.getIdClientOrder()+"'," +
                "'"+order.getIdModelOrder()+"'," +
                "'"+order.getQuantityProductOrder()+"'," +
                "'"+order.getStatusOrder()+"',"+
                "'"+order.getPriceOrder()+"',"+
                "'"+order.getDateOrder()+"');";

        model.invokeNonReturnableSqlRequest(commandSQL);
    }

    public void deleteOrder (int id) {

        String commandSQL = "DELETE FROM `order` WHERE idOrder = " + id;
        model.invokeNonReturnableSqlRequest(commandSQL);
    }

    public ArrayList<Order> getSeletOrderList(String findLastNameClientOrder, String findLastNameMasterOrder ) {

        ArrayList<Order> orderArrayList = new ArrayList<>();

        try (Connection conn = model.showSqlRequest()){


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from  `order` join `client` on `order`.idClientOrder = `client`.idclient join `master` on `master`.idmaster = `order`.idClientOrder where `client`.clientLastName like '%" + findLastNameClientOrder +"%' and `master`.lastNameMaster like '%"+findLastNameMasterOrder+"%';");

            while (rs.next()) {

                Order order = new Order();

                int idOrder = rs.getInt(1);
                int idMaster = rs.getInt(2);
                int idClient = rs.getInt(3);
                int idModel = rs.getInt(4);
                int quantityProduct = rs.getInt(5);
                String status = rs.getString(6);
                int price = rs.getInt(7);
                String date = rs.getString(8);

                order.setIdOrder(idOrder);
                order.setIdMasterOrder(idMaster);
                order.setIdClientOrder(idClient);
                order.setIdModelOrder(idModel);
                order.setQuantityProductOrder(quantityProduct);
                order.setStatusOrder(status);
                order.setPriceOrder(price);
                order.setDateOrder(date);

                Client client = clientModel.getClient(order.getIdClientOrder());
                if(client != null) {
                    order.setNameClientOrder(client.getLastNameClient());
                }
                Master master =  masterModel.getMaster(order.getIdMasterOrder());
                if(master != null) {
                    order.setNameMasterOrder(master.getLastNameMaster());
                }
                Model model = modelModel.getModel(order.getIdModelOrder());
                if(model != null) {
                    order.setTypeProductOrder(model.getNameModel());
                }
                orderArrayList.add(order);
            }
        } catch(Exception ex) {

            System.out.println("Не коректное подключение");
            System.out.println(ex);
        }

        return orderArrayList;
    }

    public Order getOrder (int id) {
        return null;
    }
}
