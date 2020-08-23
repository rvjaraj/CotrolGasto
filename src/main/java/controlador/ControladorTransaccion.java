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
import modelo.Transaccion;

/**
 *
 * @author Vinicio
 */
public class ControladorTransaccion {

    private Connection conn = null;
    private Statement stm;
    private ResultSet rs;
    private int resultUpdate = 0;

    public boolean ingresar(Transaccion u) {
        try {
            conn = ConectaDB.abrir();
            stm = conn.createStatement();
            resultUpdate = stm.executeUpdate("insert into transaccion values(0," + u.getValor()
                    + ",'" + u.getFecha() + "','" + u.getFrecuencia() + "'," + u.getUsario() + "," + u.getCategoria() + ");");
            if (resultUpdate != 0) {
                ConectaDB.cerrar();
                return true;
            } else {
                ConectaDB.cerrar();
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al ingresar al Transaccion");
            e.printStackTrace();
            return false;
        }
    }

    public boolean borrar(int id) {
        int resultUpdate = 0;
        try {
            conn = ConectaDB.abrir();
            stm = conn.createStatement();
            resultUpdate = stm.executeUpdate("DELETE FROM transaccion WHERE idtransaccion = " + id + ";");
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

    public ArrayList<Transaccion> leeTodos() {
        ArrayList<Transaccion> transaccions = new ArrayList<Transaccion>();
        try {
            conn = ConectaDB.abrir();
            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT * FROM transaccion");
            if (!rs.next()) {
                System.out.println(" No se encontraron registros");
                ConectaDB.cerrar();
                return null;
            } else {
                do {
                    Transaccion t = new Transaccion(rs.getInt("idtransaccion"), rs.getDouble("valor"), rs.getString("fecha"), rs.getString("frecuencia"), rs.getInt("usuario_id"), rs.getInt("categoria_id"));
                    transaccions.add(t);
                } while (rs.next());
                ConectaDB.cerrar();
                return transaccions;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Transaccion> leeIngresos(int id) {
        ArrayList<Transaccion> transaccions = new ArrayList<Transaccion>();
        try {
            conn = ConectaDB.abrir();
            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT * FROM transaccion t, categoria c WHERE c.idcategoria = t.categoria_id and c.tipo = 1 and t.usuario_id = " +id);
            if (!rs.next()) {
                System.out.println(" No se encontraron registros");
                ConectaDB.cerrar();
                return null;
            } else {
                do {
                    Transaccion t = new Transaccion(rs.getInt("idtransaccion"), rs.getDouble("valor"), rs.getString("fecha"), rs.getString("frecuencia"), rs.getInt("usuario_id"), rs.getInt("categoria_id"), rs.getString("descripcion"));
                    transaccions.add(t);
                } while (rs.next());
                ConectaDB.cerrar();
                return transaccions;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Transaccion> leeEgresos(int id) {
        ArrayList<Transaccion> transaccions = new ArrayList<Transaccion>();
        try {
            conn = ConectaDB.abrir();
            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT * FROM transaccion t, categoria c WHERE c.idcategoria = t.categoria_id and c.tipo = 2 and t.usuario_id = " +id);
            if (!rs.next()) {
                System.out.println(" No se encontraron registros");
                ConectaDB.cerrar();
                return null;
            } else {
                do {
                    Transaccion t = new Transaccion(rs.getInt("idtransaccion"), rs.getDouble("valor"), rs.getString("fecha"), rs.getString("frecuencia"), rs.getInt("usuario_id"), rs.getInt("categoria_id"), rs.getString("descripcion"));
                    transaccions.add(t);
                } while (rs.next());
                ConectaDB.cerrar();
                return transaccions;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }
}
