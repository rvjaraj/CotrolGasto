/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Categoria;

/**
 *
 * @author Vinicio
 */
public class ControladorCategoria {

    private Connection conn = null;
    private Statement stm;
    private ResultSet rs;
    private int resultUpdate = 0;

    public boolean ingresar(Categoria u) {
        try {
            conn = ConectaDB.abrir();
            stm = conn.createStatement();
            resultUpdate = stm.executeUpdate("insert into categoria values(0,'" + u.getDescripcion()
                    + "'," + u.getTipo() + "," + u.getEstado() + ");");
            if (resultUpdate != 0) {
                ConectaDB.cerrar();
                return true;
            } else {
                ConectaDB.cerrar();
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al ingresar al Categoria");
            e.printStackTrace();
            return false;
        }
    }

    public boolean borrar(int id) {
        int resultUpdate = 0;
        try {
            conn = ConectaDB.abrir();
            stm = conn.createStatement();
            resultUpdate = stm.executeUpdate("DELETE FROM categoria WHERE idcategoria = " + id + ";");
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

    public boolean actualizarEstado(int estado, int id) {
        try {
            conn = ConectaDB.abrir();
            stm = conn.createStatement();
            resultUpdate = stm.executeUpdate("UPDATE categoria u SET "
                    + "u.estado = " + estado + " WHERE u.idcategoria = " + id + ";");
            System.out.println(resultUpdate);
            if (resultUpdate != 0) {
                ConectaDB.cerrar();
                return true;
            } else {
                ConectaDB.cerrar();
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al Actualizar al Categoria");
            e.printStackTrace();
            return false;
        }
    }

    public Categoria buscarID(int id) {
        try {
            conn = ConectaDB.abrir();
            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT * FROM categoria u WHERE u.idcategoria = " + id + ";");
            if (!rs.next()) {
                System.out.println(" No existe usuario");
                ConectaDB.cerrar();
                return null;
            } else {
                return new Categoria(rs.getInt("idcategoria"), rs.getString("descripcion"), rs.getInt("tipo"), rs.getInt("estado"));
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Categoria> leeTodos() {
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();
        try {
            conn = ConectaDB.abrir();
            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT * FROM categoria");
            if (!rs.next()) {
                System.out.println(" No se encontraron registros");
                ConectaDB.cerrar();
                return null;
            } else {
                do {
                    Categoria u = new Categoria(rs.getInt("idcategoria"), rs.getString("descripcion"), rs.getInt("tipo"), rs.getInt("estado"));
                    categorias.add(u);
                } while (rs.next());
                ConectaDB.cerrar();
                return categorias;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }
}
