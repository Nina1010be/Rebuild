package sample.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MasterModel {

    ModelStandart model = new ModelStandart();

    public ArrayList<Master> getMasterList() {
        ArrayList<Master> masterArrayList = new ArrayList<>();

        try (Connection conn = model.showSqlRequest()){

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from master");

            while (rs.next()) {

                Master master = new Master();

                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String patronymic = rs.getString(4);
                String phoneNumber = rs.getString(5);
                String inn = rs.getString(6);

                master.setIdMaster(id);
                master.setFirstNameMaster(firstName);
                master.setLastNameMaster(lastName);
                master.setPatronMaster(patronymic);
                master.setPhoneNumberMaster(phoneNumber);
                master.setInnMaster(inn);

                masterArrayList.add(master);
            }
        }catch(Exception ex){

            System.out.println("Не коректное подключение");

            System.out.println(ex);
        }
        return masterArrayList;
    }

    public void addMaster (Master master) {

        String commandSQL = "INSERT INTO master" +
                "(firstNameMaster" +
                ", lastNameMaster" +
                ", patronMaster" +
                ", phoneNumberMaster" +
                ", innMaster) VALUES (" +
                "'"+master.getFirstNameMaster() +"'," +
                "'"+master.getLastNameMaster()+"'," +
                "'"+master.getPatronMaster()+"'," +
                "'"+master.getPhoneNumberMaster()+"'," +
                "'"+master.getInnMaster()+"');";

        model.invokeNonReturnableSqlRequest(commandSQL);
    }

    public void deleteMaster (int id) {

        String commandSQL = "DELETE FROM master WHERE idmaster = " + id;
        model.invokeNonReturnableSqlRequest(commandSQL);
    }

    public ArrayList<Master> getSelectMasterList(String lastNameSelected, String innSelected ) {

        ArrayList<Master> masterArrayList = new ArrayList<>();

        try (Connection conn = model.showSqlRequest()){

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from master where " +
                    "innMaster like '%" + innSelected + "%' and " +
                    "lastNameMaster like '%" + lastNameSelected + "%'");

            while (rs.next()) {

                Master master = new Master();

                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String patronymic = rs.getString(4);
                String phoneNumber = rs.getString(5);
                String inn = rs.getString(6);

                master.setIdMaster(id);
                master.setFirstNameMaster(firstName);
                master.setLastNameMaster(lastName);
                master.setPatronMaster(patronymic);
                master.setPhoneNumberMaster(phoneNumber);
                master.setInnMaster(inn);

                masterArrayList.add(master);
            }
        } catch(Exception ex) {

            System.out.println("Не коректное подключение");
            System.out.println(ex);
        }

        return masterArrayList;
    }

    public Master getMaster (int idMaster) {
        Master master = new Master();

        try (Connection conn = model.showSqlRequest()){

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from master where idmaster = " + idMaster);

            while (rs.next()) {

                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String patronymic = rs.getString(4);
                String phoneNumber = rs.getString(5);
                String inn = rs.getString(6);

                master.setIdMaster(id);
                master.setFirstNameMaster(firstName);
                master.setLastNameMaster(lastName);
                master.setPatronMaster(patronymic);
                master.setPhoneNumberMaster(phoneNumber);
                master.setInnMaster(inn);
            }
        }catch(Exception ex){

            System.out.println("Не коректное подключение");

            System.out.println(ex);
        }
        return master;
    }

    public void editMaster(Master master) {

        String commandSQL = "UPDATE master SET" +
                " firstNameMaster = '" + master.getFirstNameMaster() + "'" +
                ", lastNameMaster = '" + master.getLastNameMaster() + "'" +
                ", patronMaster = '" + master.getPatronMaster() + "'" +
                ", phoneNumberMaster = '" + master.getPhoneNumberMaster() + "'" +
                ", innMaster = '" + master.getInnMaster() + "' WHERE idmaster = " + master.getIdMaster();

        model.invokeNonReturnableSqlRequest(commandSQL);
    }

    public Boolean ChekMasterInToOrederAndPurches(int id) {
        try (Connection conn = model.showSqlRequest()){

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from product where idMasterProduct = " + id);

            while (rs.next()) {
                return false;
            }

        } catch(Exception ex) {

            System.out.println("Не коректное подключение");
            System.out.println(ex);
        }
        try (Connection conn1 = model.showSqlRequest()){

            Statement stmt1 = conn1.createStatement();
            ResultSet rs1 = stmt1.executeQuery("select * from `order` where idMasterOrder = " + id);

            while (rs1.next()) {
                return false;
            }

        } catch(Exception ex) {

            System.out.println("Не коректное подключение");
            System.out.println(ex);
        }

        return true;
//        try (Connection conn = model.showSqlRequest()){
//
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from product where idMasterProduct = " + id);
//
//            if(rs != null) return false;
//
//            ResultSet rs1 = stmt.executeQuery("select * from `order` where idMasterOrder = " + id);
//
//            if(rs1 != null) return false;
//
//        } catch(Exception ex) {
//
//            System.out.println("Не коректное подключение");
//            System.out.println(ex);
//        }
//        return true;
    }
}
