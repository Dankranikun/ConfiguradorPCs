/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nicop
 */
public class Psu {

    private int id_Psu;
    private String marca;
    private String modelo;
    private int potencia;
    private String certificacion;

    public Psu() {
    }

    public Psu(int potencia) {
        this.potencia = potencia;
    }

    public Psu(String marca, String modelo, int potencia, String certificacion) {
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.certificacion = certificacion;
    }

    public Psu(int id_Psu, String marca, String modelo, int potencia, String certificacion) {
        this.id_Psu = id_Psu;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.certificacion = certificacion;
    }

    public String getCertificacion() {
        return certificacion;
    }

    public void setCertificacion(String certificacion) {
        this.certificacion = certificacion;
    }

    public int getId_Psu() {
        return id_Psu;
    }

    public void setId_Psu(int id_Psu) {
        this.id_Psu = id_Psu;
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

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "Psu{" + "id_Psu=" + id_Psu + ", marca=" + marca + ", modelo=" + modelo + ", potencia=" + potencia + ", certificacion=" + certificacion + '}';
    }

}
