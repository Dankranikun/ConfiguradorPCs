/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DatabaseConnection;

/**
 * Clase para inspeccionar la estructura de una base de datos SQLite.
 */
public class DatabaseInspector {

    public static void inspectDatabase() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Obtener metadata de la base de datos
            DatabaseMetaData metaData = conn.getMetaData();

            // Obtener todas las tablas
            System.out.println("=== Lista de Tablas ===");
            ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"});
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println("\nTabla: " + tableName);

                // Obtener columnas de la tabla usando PRAGMA table_info
                System.out.println("Columnas:");
                try (PreparedStatement stmt = conn.prepareStatement("PRAGMA table_info(" + tableName + ");"); ResultSet columns = stmt.executeQuery()) {
                    while (columns.next()) {
                        String columnName = columns.getString("name");
                        String columnType = columns.getString("type");
                        boolean notNull = columns.getInt("notnull") == 1;
                        String defaultValue = columns.getString("dflt_value");
                        boolean isPrimaryKey = columns.getInt("pk") == 1;

                        System.out.printf("  - %s: %s, Not Null: %b, Default: %s, Primary Key: %b%n",
                                columnName, columnType, notNull, defaultValue, isPrimaryKey);
                    }
                }

                // Obtener claves foráneas usando PRAGMA foreign_key_list
                System.out.println("Claves Foráneas:");
                try (PreparedStatement stmt = conn.prepareStatement("PRAGMA foreign_key_list(" + tableName + ");"); ResultSet foreignKeys = stmt.executeQuery()) {
                    boolean hasForeignKeys = false;
                    while (foreignKeys.next()) {
                        hasForeignKeys = true;
                        String fromColumn = foreignKeys.getString("from");
                        String toTable = foreignKeys.getString("table");
                        String toColumn = foreignKeys.getString("to");
                        System.out.printf("  - %s -> %s.%s%n", fromColumn, toTable, toColumn);
                    }
                    if (!hasForeignKeys) {
                        System.out.println("  (Ninguna)");
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al inspeccionar la base de datos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        inspectDatabase();
    }
}
