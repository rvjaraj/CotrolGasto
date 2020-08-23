/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

/**
 *
 * @author Vinicio
 */
public class Transaccion {
    private int id;
    private double valor;
    private String fecha;
    private String frecuencia;
    private int usario;
    private int categoria;
    private String cateogrianame;

    public Transaccion() {
    }

    public Transaccion(int id, double valor, String fecha, String frecuencia, int usario, int categoria, String cateogrianame) {
        this.id = id;
        this.valor = valor;
        this.fecha = fecha;
        this.frecuencia = frecuencia;
        this.usario = usario;
        this.categoria = categoria;
        this.cateogrianame = cateogrianame;
    }
    
    public Transaccion(int id, double valor, String fecha, String frecuencia, int usario, int categoria) {
        this.id = id;
        this.valor = valor;
        this.fecha = fecha;
        this.frecuencia = frecuencia;
        this.usario = usario;
        this.categoria = categoria;
    }
    
    
    public Transaccion(double valor, String fecha, String frecuencia, int usario, int categoria) {
        this.valor = valor;
        this.fecha = fecha;
        this.frecuencia = frecuencia;
        this.usario = usario;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public int getUsario() {
        return usario;
    }

    public void setUsario(int usario) {
        this.usario = usario;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getCateogrianame() {
        return cateogrianame;
    }

    public void setCateogrianame(String cateogrianame) {
        this.cateogrianame = cateogrianame;
    }
    
}
