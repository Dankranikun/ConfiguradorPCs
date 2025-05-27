/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nicop
 */
public class Discos {

    private int id_Disco;
    private String marca;
    private String modelo;
    private int capacidad;
    private String tipo;
    private String conexion;

    public Discos() {
    }

    public Discos(int capacidad) {
        this.capacidad = capacidad;
    }

    public Discos(String marca, String modelo, int capacidad, String tipo, String conexion) {
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.conexion = conexion;
    }

    public Discos(int id_Disco, String marca, String modelo, int capacidad, String tipo, String conexion) {
        this.id_Disco = id_Disco;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.conexion = conexion;
    }

    public String getConexion() {
        return conexion;
    }

    public void setConexion(String conexion) {
        this.conexion = conexion;
    }

    public int getId_Disco() {
        return id_Disco;
    }

    public void setId_Disco(int id_Disco) {
        this.id_Disco = id_Disco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Discos{" + "id_Disco=" + id_Disco + ", marca=" + marca + ", modelo=" + modelo + ", capacidad=" + capacidad + ", tipo=" + tipo + ", conexion=" + conexion + '}';
    }

}
