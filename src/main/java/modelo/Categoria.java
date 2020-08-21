/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Vinicio
 */
public class Categoria {
    private int id;
    private String descripcion;
    private int tipo;
    private int estado;

    public Categoria() {
    }

    public Categoria(int id, String descripcion, int tipo, int estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.estado = estado;
    }

    public Categoria(String descripcion, int tipo, int estado) {
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
