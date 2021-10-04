package sample.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ClientModel {

    ModelStandart model = new ModelStandart();

    public ArrayList<Client> getClientList() {

        ArrayList<Client> clientArrayList = new ArrayList<>();

        try (Connection conn = model.showSqlRequest()){

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from client");

            while (rs.next()) {

                Client client = new Client();

                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String patronymic = rs.getString(4);
                String phoneNumber = rs.getString(5);
                String inn = rs.getString(6);

                client.setIdClient(id);
                client.setFirstNameClient(firstName);
                client.setLastNameClient(lastName);
                client.setPatronClient(patronymic);
                client.setPhoneNumberClient(phoneNumber);
                client.setInnClient(inn);

                clientArrayList.add(client);
            }
        }catch(Exception ex){

            System.out.println("Не коректное подключение");

            System.out.println(ex);
        }
        return clientArrayList;
    }

    public void addClient (Client client) {

        String commandSQL = "INSERT INTO client" +
                "(clientfirstName" +
                ", clientlastName" +
                ", clientpatronymic" +
                ", clientphoneNumber" +
                ", clientinn) VALUES (" +
                "'"+client.getFirstNameClient() +"'," +
                "'"+client.getLastNameClient()+"'," +
                "'"+client.getPatronClient()+"'," +
                "'"+client.getPhoneNumberClient()+"'," +
                "'"+client.getInnClient()+"');";

        model.invokeNonReturnableSqlRequest(commandSQL);
    }

    public void deleteCleint (int id) {

        String commandSQL = "DELETE FROM client WHERE idclient = " + id;
        model.invokeNonReturnableSqlRequest(commandSQL);
    }

    public ArrayList<Client> getSeletClientList(String lastNameSelected, String innSelected ) {

        ArrayList<Client> clientArrayList = new ArrayList<>();

        try (Connection conn = model.showSqlRequest()){

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from client where " +
                    "clientinn like '%" + innSelected + "%' and " +
                    "clientlastName like '%" + lastNameSelected + "%'");

            while (rs.next()) {

                Client client = new Client();

                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String patronymic = rs.getString(4);
                String phoneNumber = rs.getString(5);
                String inn = rs.getString(6);

                client.setIdClient(id);
                client.setFirstNameClient(firstName);
                client.setLastNameClient(lastName);
                client.setPatronClient(patronymic);
                client.setPhoneNumberClient(phoneNumber);
                client.setInnClient(inn);

                clientArrayList.add(client);
            }
        } catch(Exception ex) {

            System.out.println("Не коректное подключение");
            System.out.println(ex);
        }

        return clientArrayList;
    }

    public Client getClient (int idClint) {

        Client client = new Client();

        try (Connection conn = model.showSqlRequest()){

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from client WHERE idclient = " + idClint);

            while (rs.next()) {

                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String patronymic = rs.getString(4);
                String phoneNumber = rs.getString(5);
                String inn = rs.getString(6);

                client.setIdClient(id);
                client.setFirstNameClient(firstName);
                client.setLastNameClient(lastName);
                client.setPatronClient(patronymic);
                client.setPhoneNumberClient(phoneNumber);
                client.setInnClient(inn);
            }
        } catch(Exception ex) {

            System.out.println("Не коректное подключение");
            System.out.println(ex);
        }

        return client;
    }
    ModelStandart modelStandart = new ModelStandart();
    public Boolean ChekClientInToOrederAndPurches(int id) {

        try (Connection conn = model.showSqlRequest()){

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from purchase where idClientPurchase = " + id);

            while (rs.next()) {
                return false;
            }

        } catch(Exception ex) {

            System.out.println("Не коректное подключение");
            System.out.println(ex);
        }
        try (Connection conn1 = model.showSqlRequest()){

            Statement stmt1 = conn1.createStatement();
            ResultSet rs1 = stmt1.executeQuery("select * from `order` where idClientOrder = " + id);

            while (rs1.next()) {
                return false;
            }

        } catch(Exception ex) {

            System.out.println("Не коректное подключение");
            System.out.println(ex);
        }

        return true;
    }

    public void editClient(Client client) {

        String commandSQL = "UPDATE client SET" +
            " clientfirstName = '" + client.getFirstNameClient() + "'" +
            ", clientlastName = '" + client.getLastNameClient() + "'" +
            ", clientpatronymic = '" + client.getPatronClient() + "'" +
            ", clientphoneNumber = '" + client.getPhoneNumberClient() + "'" +
            ", clientinn = '" + client.getInnClient() + "' WHERE idclient = " + client.getIdClient();

        model.invokeNonReturnableSqlRequest(commandSQL);
    }
}
