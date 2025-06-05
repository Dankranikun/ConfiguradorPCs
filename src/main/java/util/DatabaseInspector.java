package util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para inspeccionar la estructura y datos de una base de datos SQLite.
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
                List<String> columnNames = new ArrayList<>();
                try (PreparedStatement stmt = conn.prepareStatement("PRAGMA table_info(" + tableName + ");"); ResultSet columns = stmt.executeQuery()) {
                    while (columns.next()) {
                        String columnName = columns.getString("name");
                        String columnType = columns.getString("type");
                        boolean notNull = columns.getInt("notnull") == 1;
                        String defaultValue = columns.getString("dflt_value");
                        boolean isPrimaryKey = columns.getInt("pk") == 1;

                        columnNames.add(columnName);
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

                // Obtener y mostrar los datos de la tabla
                System.out.println("Datos:");
                try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + tableName)) {
                    // Asegurarse de que no haya límite en el número de filas
                    stmt.setMaxRows(0); // 0 significa sin límite
                    ResultSet data = stmt.executeQuery();
                    int rowCount = 0;
                    while (data.next()) {
                        rowCount++;
                        StringBuilder rowData = new StringBuilder();
                        for (int i = 0; i < columnNames.size(); i++) {
                            String columnName = columnNames.get(i);
                            Object value = data.getObject(i + 1);
                            if (i > 0) {
                                rowData.append(", ");
                            }
                            rowData.append(columnName).append(": ").append(value != null ? value.toString() : "NULL");
                        }
                        System.out.println("  Dato " + rowCount + ": " + rowData.toString());
                    }
                    System.out.println("  Total de registros procesados: " + rowCount);
                    if (rowCount == 0) {
                        System.out.println("  (Sin datos)");
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
