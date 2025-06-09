package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import util.DatabaseConnection;

public class ReportDataSource {

    public JRResultSetDataSource getConfigurationDataSource() throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = """
            SELECT 
                configuraciones.id AS id,
                usuarios.nombre AS User,
                cpu.modelo AS CPU,
                discos.modelo AS Disk,
                gpu.modelo AS GPU,
                motherboard.modelo AS Motherboard,
                psu.modelo AS PSU,
                ram.modelo AS RAM
            FROM configuraciones
            INNER JOIN cpu ON configuraciones.cpu_id = cpu.id
            INNER JOIN discos ON configuraciones.disco_id = discos.id
            INNER JOIN gpu ON configuraciones.gpu_id = gpu.id
            INNER JOIN motherboard ON configuraciones.motherboard_id = motherboard.id
            INNER JOIN psu ON configuraciones.psu_id = psu.id
            INNER JOIN ram ON configuraciones.ram_id = ram.id
            INNER JOIN usuarios ON configuraciones.usuario_id = usuarios.id
        """;
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        return new JRResultSetDataSource(rs);
    }
}
