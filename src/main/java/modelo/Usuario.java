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
public class Usuario {
    private int id;
    private String nombre;
    private int edad;
    private int sexo;
    private String contrasenia;
    private double saldo;
    private String correo;
    private String rol;

    public Usuario() {
    }

    public Usuario(int id, String nombre, int edad, int sexo, String contrasenia, double saldo, String correo, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.contrasenia = contrasenia;
        this.saldo = saldo;
        this.correo = correo;
        this.rol = rol;
    }
    public Usuario(int id, String nombre, int edad, int sexo, String contrasenia, String correo, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.rol = rol;
    }

    public Usuario(String nombre, int edad, int sexo, String contrasenia, String correo, String rol) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.rol = rol;
    }

   

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
    
    @Override
    public String toString() {
        return "usuario{" + "id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + ", contrasenia=" + contrasenia + ", saldo=" + saldo + '}';
    }
    
    
}
