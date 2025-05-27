/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nicop
 */
public class Motherboard {

    private int id_M;
    private String marca;
    private String modelo;
    private String chipset;
    private String socket;

    public Motherboard() {
    }

    public Motherboard(String modelo) {
        this.modelo = modelo;
    }

    public Motherboard(String marca, String modelo, String chipset, String socket) {
        this.marca = marca;
        this.modelo = modelo;
        this.chipset = chipset;
        this.socket = socket;
    }

    public Motherboard(int id_M, String marca, String modelo, String chipset, String socket) {
        this.id_M = id_M;
        this.marca = marca;
        this.modelo = modelo;
        this.chipset = chipset;
        this.socket = socket;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public int getId_M() {
        return id_M;
    }

    public void setId_M(int id_M) {
        this.id_M = id_M;
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

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    @Override
    public String toString() {
        return "Motherboard{" + "id_M=" + id_M + ", marca=" + marca + ", modelo=" + modelo + ", chipset=" + chipset + ", socket=" + socket + '}';
    }

}
