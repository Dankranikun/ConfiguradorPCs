/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.DatabaseConnection;

public class ComponentController {

    public void insertarCpu(String brand, String model, int cores, int threads, float frequency, String socket, int year, int power) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO cpu (marca, modelo, nucleos, hilos, frecuencia, socket, año_lanzamiento, consumo_energetico) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, brand);
            stmt.setString(2, model);
            stmt.setInt(3, cores);
            stmt.setInt(4, threads);
            stmt.setFloat(5, frequency);
            stmt.setString(6, socket);
            stmt.setInt(7, year);
            stmt.setInt(8, power);
            stmt.executeUpdate();
        }
    }

    public List<Map<String, Object>> obtenerCpus(int pagina) throws SQLException {
        List<Map<String, Object>> cpus = new ArrayList<>(); // Corrección implícita: ArrayList implementa List
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(
                "SELECT marca, modelo, nucleos, hilos, frecuencia, socket, año_lanzamiento, consumo_energetico FROM cpu LIMIT ? OFFSET ?")) {
            stmt.setInt(1, 10); // 10 registros por página
            stmt.setInt(2, pagina * 10); // Offset basado en la página
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Map<String, Object> cpu = new HashMap<>();
                cpu.put("marca", rs.getString("marca"));
                cpu.put("modelo", rs.getString("modelo"));
                cpu.put("nucleos", rs.getInt("nucleos"));
                cpu.put("hilos", rs.getInt("hilos"));
                cpu.put("frecuencia", rs.getFloat("frecuencia"));
                cpu.put("socket", rs.getString("socket"));
                cpu.put("año_lanzamiento", rs.getInt("año_lanzamiento"));
                cpu.put("consumo_energetico", rs.getInt("consumo_energetico"));
                cpus.add(cpu);
            }
        }
        return cpus;
    }
}
