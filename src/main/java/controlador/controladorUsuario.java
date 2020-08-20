/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public boolean borrar(int id) {
        int resultUpdate = 0;
        try {
            conn = ConectaDB.abrir();
            stm = conn.createStatement();
            resultUpdate = stm.executeUpdate("DELETE FROM usuario WHERE idusuario = " + id +";");
            if (resultUpdate != 0) {
                ConectaDB.cerrar();
                return true;
            } else {
                ConectaDB.cerrar();
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al borrar " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarAdmin(Usuario u) {
        try {
            conn = ConectaDB.abrir();
            stm = conn.createStatement();
            resultUpdate = stm.executeUpdate("UPDATE usuario u SET "
                    + "u.nombre = '" + u.getNombre() + "',"
                    + "u.edad = " + u.getEdad() + ", "
                    + "u.sexo = " + u.getSexo() + ", "
                    + "u.correo = '" + u.getCorreo() + "', "
                    + "u.rol = '" + u.getRol() + "' WHERE u.idusuario = " + u.getId() +");");

            if (resultUpdate != 0) {
                ConectaDB.cerrar();
                return true;
            } else {
                ConectaDB.cerrar();
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al Actualizar al Usuario");
            e.printStackTrace();
            return false;
        }
    }

    public Usuario login(String correo, String contra) {
        try {
            conn = ConectaDB.abrir();
            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT * FROM usuario u WHERE u.correo = '" + correo + "' and u.password = '" + contra + "'");
            if (!rs.next()) {
                System.out.println(" No existe usuario");
                ConectaDB.cerrar();
                guardarLogin(correo, contra, "NEGADO");
                return null;
            } else {
                guardarLogin(correo, contra, "ACCEPTADO");
                return new Usuario(rs.getInt("idusuario"), rs.getString("nombre"), rs.getInt("edad"), rs.getInt("sexo"), rs.getString("password"), rs.getDouble("saldo"), rs.getString("correo"), rs.getString("rol"));
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }

    public void guardarLogin(String correo, String contra, String estado) throws IOException {
        File archivo;
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            //archivo = new File("Registro.txt");
            archivo = new File("C:\\Users\\Vinicio\\Desktop\\Registro.txt");
            fw = new FileWriter(archivo, true);
            pw = new PrintWriter(fw);
            Date date = new Date();
            pw.println(correo + "," + contra + ","
                    + estado + "," + date);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
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
