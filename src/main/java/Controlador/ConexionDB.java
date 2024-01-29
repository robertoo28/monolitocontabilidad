package Controlador;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {
    private Connection connection;
    private String usuario = "root";
    private String password = "admin";
    private String servidor = "localhost";
    private String puerto = "3306";
    private String nombreBD = "db_contabilidad_readytogo";
    private String url = "jdbc:mysql://" + servidor + ":" + puerto + "/" + nombreBD + "?serverTimezone=UTC";
    private String driver = "com.mysql.cj.jdbc.Driver";

    public  ConexionDB() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,usuario,password);
            if (connection!=null){
                System.out.println("Se conecto bien");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println("print stack trace: ");
            e.printStackTrace();

        }

    }

    public Connection getConnection() {
        return connection;
    }
}
