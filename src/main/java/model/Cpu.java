/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nicop
 */
public class Cpu {

    private int id_Cpu;
    private String marca;
    private String modelo;
    private int nucleos;
    private int hilos;
    private float frecuencia;
    private String socket;
    private int ano_lanzamiento;
    private int consumo_energetico;

    public Cpu() {
    }

    public Cpu(String modelo) {
        this.modelo = modelo;
    }

    public Cpu(String marca, String modelo, int nucleos, int hilos, float frecuencia, String socket, int ano_lanzamiento, int consumo_energetico) {
        this.marca = marca;
        this.modelo = modelo;
        this.nucleos = nucleos;
        this.hilos = hilos;
        this.frecuencia = frecuencia;
        this.socket = socket;
        this.ano_lanzamiento = ano_lanzamiento;
        this.consumo_energetico = consumo_energetico;
    }

    public Cpu(int id_Cpu, String marca, String modelo, int nucleos, int hilos, float frecuencia, String socket, int ano_lanzamiento, int consumo_energetico) {
        this.id_Cpu = id_Cpu;
        this.marca = marca;
        this.modelo = modelo;
        this.nucleos = nucleos;
        this.hilos = hilos;
        this.frecuencia = frecuencia;
        this.socket = socket;
        this.ano_lanzamiento = ano_lanzamiento;
        this.consumo_energetico = consumo_energetico;
    }

    public int getConsumo_energetico() {
        return consumo_energetico;
    }

    public void setConsumo_energetico(int consumo_energetico) {
        this.consumo_energetico = consumo_energetico;
    }

    public int getId_Cpu() {
        return id_Cpu;
    }

    public void setId_Cpu(int id_Cpu) {
        this.id_Cpu = id_Cpu;
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

    public int getNucleos() {
        return nucleos;
    }

    public void setNucleos(int nucleos) {
        this.nucleos = nucleos;
    }

    public int getHilos() {
        return hilos;
    }

    public void setHilos(int hilos) {
        this.hilos = hilos;
    }

    public float getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(float frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public int getAno_lanzamiento() {
        return ano_lanzamiento;
    }

    public void setAno_lanzamiento(int ano_lanzamiento) {
        this.ano_lanzamiento = ano_lanzamiento;
    }

    @Override
    public String toString() {
        return "Cpu{" + "id_Cpu=" + id_Cpu + ", marca=" + marca + ", modelo=" + modelo + ", nucleos=" + nucleos + ", hilos=" + hilos + ", frecuencia=" + frecuencia + ", socket=" + socket + ", ano_lanzamiento=" + ano_lanzamiento + ", consumo_energetico=" + consumo_energetico + '}';
    }

}
