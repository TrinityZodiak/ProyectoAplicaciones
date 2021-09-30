package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB
{
    private static String driver ="";
    private static String dataBase = "";
    private static String hostName = "";
    private static String port = "3306";

    private static String url="jdbc:mysql://"+hostName+":"+ port + "/"+ dataBase +"?useTimezone=true&serverTimezone=UTC";

    private static String userName = "";
    private static String Password = "";

    public static Connection AbrirConexion(){
        Connection conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, Password);

        }catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
        return conn;
    }
}
