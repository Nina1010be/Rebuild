package sample.Model;

import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;

public class ModelStandart {

    private static final String url = "jdbc:mysql://localhost:3306/nina";
    private static final String user = "root";
    private static final String password = "admin";

    public void invokeNonReturnableSqlRequest(String commandSQL) {

        includeDriver();

        try (Connection conn = DriverManager.getConnection(url, user, password)){

            Statement statement = conn.createStatement();
            statement.executeUpdate(commandSQL);
        }catch(Exception ex){

            System.out.println("Не коректное подключение");
            System.out.println(ex);
        }
    }

    public Connection showSqlRequest() throws SQLException {

        includeDriver();
        return DriverManager.getConnection(url, user, password);
    }

    public void includeDriver() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Не удачная загрузка драйвера.");
        }
    }

    public void ShowAlert(String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информация");
        alert.setHeaderText("Результат выполнения операции");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static Boolean chekedRussionSymbol(String field) {
        String []  str = new String []{"й","ц","у","к","е","н","г","ш","щ","з","х","ъ","ф","ы","в","а","п","р","о","л","д","ж","э","я","ч","с","м","и","т","ь","б","ю","ё"};
        char[]  fieldstr = field.toLowerCase(Locale.ROOT).toCharArray();

        if(fieldstr.length==0)
        {
            return false;
        }

        Boolean flag = false;
        for (int i = 0; i < fieldstr.length; i++) {

            flag = false;

            for (int j = 0; j <  str.length ; j++) {

                if(Character.toString(fieldstr[i]).equals(str[j])){
                    flag = true;
                    break;
                }
            }
            if(flag != true)
            {
                return  false;
            }
        }
        return  true;
    }
    public static boolean tryParseInt(String value) {
        char [] symbol = value.toCharArray();
        try {
            for (var s: symbol) {
                Integer.parseInt(String.valueOf(s));
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean checksUniquenessObjectInToDataBase(String str, ArrayList<String> list){
        for (var item : list){
            if(item.equals(str)) {
                return false;
            }
        }
        return  true;
    }
    public static boolean checksUniquenessObjectInToDataBase(String str,Integer id, ArrayList<String> list, ArrayList<Integer> idList){
        for (int i = 0; i < list.size(); i++) {
            if( (list.get(i).equals(str)) && !idList.get(i).equals(id)) {
                return false;
            }
        }
        return  true;
    }

}
