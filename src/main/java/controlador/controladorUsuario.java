/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import modelo.Usuario;

/**
 *
 * @author Vinicio
 */
public class controladorUsuario {

    public boolean ingresar(Usuario u) {
        Connection conn = null;
        Statement stm;
        ResultSet rs;
        int resultUpdate = 0;
        try {
            conn = ConectaDB.abrir();
            stm = conn.createStatement();
            resultUpdate = stm.executeUpdate("insert into usuario values(0,'" + u.getNombre() + 
                    "','" + u.getCorreo() + "'," + u.getEdad() + "," + u.getSexo() + ",'" + u.getContrasenia() + "','" + u.getRol()+ "',null);");
            if (resultUpdate != 0) {
                ConectaDB.cerrar();
                return true;
            } else {
                ConectaDB.cerrar();
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al ingresar al Usuario");
            e.printStackTrace();
            return false;
        }
    }
}
