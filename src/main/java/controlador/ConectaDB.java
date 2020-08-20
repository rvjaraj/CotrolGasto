package controlador;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaDB {

    private static String bd = "gastos";
    public static Connection con;
    public static String usuario = "root";
    public static String passw = "";
    public static String url = "jdbc:mysql://localhost:3306/gastos";

    public static Connection abrir() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, passw);
        } catch (Exception e) {
            System.out.println("Error en la conexion... " + e.getMessage());
            e.printStackTrace();
        }
        return con;
    }

    public static void cerrar() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            System.out.println("Error: No se logro cerrar conexion:\n" + e);
        }
    }
}
