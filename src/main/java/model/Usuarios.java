/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nicop
 */
public class Usuarios {

    private int id_u;
    private String nombre;
    private String contrasena;
    private boolean sesionIniciada;

    public Usuarios() {
    }

    public Usuarios(String nombre) {
        this.nombre = nombre;
    }

    public Usuarios(String nombre, boolean sesionIniciada) {
        this.nombre = nombre;
        this.sesionIniciada = sesionIniciada;
    }

    public Usuarios(int id_u, String nombre, String contrasena, boolean sesionIniciada) {
        this.id_u = id_u;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.sesionIniciada = sesionIniciada;
    }

    public boolean isSesionIniciada() {
        return sesionIniciada;
    }

    public void setSesionIniciada(boolean sesionIniciada) {
        this.sesionIniciada = sesionIniciada;
    }

    public int getId_u() {
        return id_u;
    }

    public void setId_u(int id_u) {
        this.id_u = id_u;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "id_u=" + id_u + ", nombre=" + nombre + ", contrasena=" + contrasena + ", sesionIniciada=" + sesionIniciada + '}';
    }

}
