package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                String dbPath = DatabaseConnection.class.getClassLoader()
                        .getResource("pcDatabase.db").toURI().getPath();

                String url = "jdbc:sqlite:" + dbPath;

                connection = DriverManager.getConnection(url);
                System.out.println("Conexión a SQLite establecida con éxito.");

                // Forzar sin límite en el número de filas devueltas
                Statement stmt = connection.createStatement();
//                stmt.setMaxRows(0); // Sin límite en el número de filas
//                stmt.setFetchSize(0); // Sin límite en el tamaño de recuperación
                stmt.close(); // Cerrar el Statement después de configurarlo
            } catch (Exception e) {
                System.err.println("Error al conectar a la base de datos: " + e.getMessage());
                throw new SQLException("No se pudo conectar a la base de datos", e);
            }
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión a SQLite cerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            System.out.println("Conexión probada con éxito.");
            closeConnection();
        } catch (SQLException e) {
            System.err.println("Error en la prueba de conexión: " + e.getMessage());
        }
    }
}
