/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author Vinicio
 */
public class ControladorUsuario {

    private Connection conn = null;
    private Statement stm;
    private ResultSet rs;
    private int resultUpdate = 0;

    public boolean ingresar(Usuario u) {
        try {
            conn = ConectaDB.abrir();
            stm = conn.createStatement();
            resultUpdate = stm.executeUpdate("insert into usuario values(0,'" + u.getNombre()
                    + "','" + u.getCorreo() + "'," + u.getEdad() + "," + u.getSexo() + ",'" + u.getContrasenia() + "','" + u.getRol() + "',null);");
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

    public ArrayList<Usuario> leeTodos() {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            conn = ConectaDB.abrir();
            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT * FROM usuario");
            if (!rs.next()) {
                System.out.println(" No se encontraron registros");
                ConectaDB.cerrar();
                return null;
            } else {
                do {
                    Usuario u = new Usuario(rs.getInt("idusuario"), rs.getString("nombre"), rs.getInt("edad"), rs.getInt("sexo"), rs.getString("password"), rs.getDouble("saldo"), rs.getString("correo"), rs.getString("rol"));
                    usuarios.add(u);
                } while (rs.next());
                ConectaDB.cerrar();
                return usuarios;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }
}
