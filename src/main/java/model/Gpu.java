/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nicop
 */
public class Gpu {

    private int id_Gpu;
    private String marca;
    private String modelo;
    private int memoria;
    private int ano_lanzamiento;
    private int consumo_energetico;

    public Gpu() {
    }

    public Gpu(String modelo) {
        this.modelo = modelo;
    }

    public Gpu(String marca, String modelo, int memoria, int ano_lanzamiento, int consumo_energetico) {
        this.marca = marca;
        this.modelo = modelo;
        this.memoria = memoria;
        this.ano_lanzamiento = ano_lanzamiento;
        this.consumo_energetico = consumo_energetico;
    }

    public Gpu(int id_Gpu, String marca, String modelo, int memoria, int ano_lanzamiento, int consumo_energetico) {
        this.id_Gpu = id_Gpu;
        this.marca = marca;
        this.modelo = modelo;
        this.memoria = memoria;
        this.ano_lanzamiento = ano_lanzamiento;
        this.consumo_energetico = consumo_energetico;
    }

    public int getConsumo_energetico() {
        return consumo_energetico;
    }

    public void setConsumo_energetico(int consumo_energetico) {
        this.consumo_energetico = consumo_energetico;
    }

    public int getId_Gpu() {
        return id_Gpu;
    }

    public void setId_Gpu(int id_Gpu) {
        this.id_Gpu = id_Gpu;
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

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public int getAno_lanzamiento() {
        return ano_lanzamiento;
    }

    public void setAno_lanzamiento(int ano_lanzamiento) {
        this.ano_lanzamiento = ano_lanzamiento;
    }

    @Override
    public String toString() {
        return "Gpu{" + "id_Gpu=" + id_Gpu + ", marca=" + marca + ", modelo=" + modelo + ", memoria=" + memoria + ", ano_lanzamiento=" + ano_lanzamiento + ", consumo_energetico=" + consumo_energetico + '}';
    }

}
