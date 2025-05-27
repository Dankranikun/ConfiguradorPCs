/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nicop
 */
public class Configuraciones {

    private int idConf;
    private int idUsuario;
    private int idRAM;
    private int idCPU;
    private int idGPU;
    private int idMotherBoard;
    private int idPSU;
    private int idDisco;

    public Configuraciones() {
    }

    public Configuraciones(int idUsuario, int idRAM, int idCPU, int idGPU, int idMotherBoard, int idPSU, int idDisco) {
        this.idUsuario = idUsuario;
        this.idRAM = idRAM;
        this.idCPU = idCPU;
        this.idGPU = idGPU;
        this.idMotherBoard = idMotherBoard;
        this.idPSU = idPSU;
        this.idDisco = idDisco;
    }

    public Configuraciones(int idConf, int idUsuario, int idRAM, int idCPU, int idGPU, int idMotherBoard, int idPSU, int idDisco) {
        this.idConf = idConf;
        this.idUsuario = idUsuario;
        this.idRAM = idRAM;
        this.idCPU = idCPU;
        this.idGPU = idGPU;
        this.idMotherBoard = idMotherBoard;
        this.idPSU = idPSU;
        this.idDisco = idDisco;
    }

    public int getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(int idDisco) {
        this.idDisco = idDisco;
    }

    public int getIdConf() {
        return idConf;
    }

    public void setIdConf(int idConf) {
        this.idConf = idConf;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdRAM() {
        return idRAM;
    }

    public void setIdRAM(int idRAM) {
        this.idRAM = idRAM;
    }

    public int getIdCPU() {
        return idCPU;
    }

    public void setIdCPU(int idCPU) {
        this.idCPU = idCPU;
    }

    public int getIdGPU() {
        return idGPU;
    }

    public void setIdGPU(int idGPU) {
        this.idGPU = idGPU;
    }

    public int getIdMotherBoard() {
        return idMotherBoard;
    }

    public void setIdMotherBoard(int idMotherBoard) {
        this.idMotherBoard = idMotherBoard;
    }

    public int getIdPSU() {
        return idPSU;
    }

    public void setIdPSU(int idPSU) {
        this.idPSU = idPSU;
    }

    @Override
    public String toString() {
        return "Configuraciones{" + "idConf=" + idConf + ", idUsuario=" + idUsuario + ", idRAM=" + idRAM + ", idCPU=" + idCPU + ", idGPU=" + idGPU + ", idMotherBoard=" + idMotherBoard + ", idPSU=" + idPSU + ", idDisco=" + idDisco + '}';
    }

}
