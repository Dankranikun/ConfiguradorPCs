/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nicop
 */
public class Ram {

    private int id_Ram;
    private String marca;
    private String modelo;
    private int capacidad;
    private int velocidad;
    private String socket;

    public Ram() {
    }

    public Ram(int capacidad) {
        this.capacidad = capacidad;
    }

    public Ram(String marca, String modelo, int capacidad, int velocidad, String socket) {
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.velocidad = velocidad;
        this.socket = socket;
    }

    public Ram(int id_Ram, String marca, String modelo, int capacidad, int velocidad, String socket) {
        this.id_Ram = id_Ram;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.velocidad = velocidad;
        this.socket = socket;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public int getId_Ram() {
        return id_Ram;
    }

    public void setId_Ram(int id_Ram) {
        this.id_Ram = id_Ram;
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

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return "Ram{" + "id_Ram=" + id_Ram + ", marca=" + marca + ", modelo=" + modelo + ", capacidad=" + capacidad + ", velocidad=" + velocidad + ", socket=" + socket + '}';
    }

}
