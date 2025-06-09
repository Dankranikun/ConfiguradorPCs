package view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;
import dao.ReportDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperExportManager;
import java.util.HashMap;
import javax.swing.JOptionPane;
import java.io.File;
import java.nio.file.Paths;
import java.sql.SQLException;

/**
 *
 * @author nicop
 */
public class ReportWindow extends JDialog {

    private final JCheckBox cbPdf;
    private final JCheckBox cbHtml;
    private final JButton botonGenerar;

    public ReportWindow(java.awt.Frame parent) {
        super(parent, "Report Generation", true);
        setSize(200, 150);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Usar GridLayout con 3 filas y 1 columna
        setLayout(new GridLayout(3, 1, 10, 10)); // 3 filas, 1 columna, con espacio de 10px entre componentes

        cbPdf = new JCheckBox("PDF");
        cbHtml = new JCheckBox("HTML");
        botonGenerar = new JButton("Generate");

        add(cbPdf);
        add(cbHtml);
        add(botonGenerar);

        // Añadir acción al botón "Generate"
        botonGenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                boolean generatePDF = cbPdf.isSelected();
                boolean generateHTML = cbHtml.isSelected();

                // Si no se selecciona ningún formato, mostrar mensaje
                if (!generatePDF && !generateHTML) {
                    JOptionPane.showMessageDialog(ReportWindow.this, "Select at least one format.", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Cerrar el diálogo
                dispose();

                // Generar el informe
                try {
                    // Cargar el archivo .jasper con verificación
                    java.io.InputStream reportStream = getClass().getResourceAsStream("/reports/buildsReport.jasper");
                    if (reportStream == null) {
                        throw new JRException("File buildsReport.jasper not found. Verify the path in src/main/resources/reports/");
                    }
                    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportStream);

                    // Obtener el datasource desde ReportDataSource
                    ReportDataSource reportDataSource = new ReportDataSource();
                    net.sf.jasperreports.engine.JRResultSetDataSource dataSource = reportDataSource.getConfigurationDataSource();

                    // Generar el informe
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), dataSource);

                    // Determinar la carpeta de salida (relativa al proyecto)
                    String basePath = Paths.get(".").toAbsolutePath().normalize().toString();
                    String outputPath = basePath + "/src/main/reports";
                    String pdfPath = outputPath + "/ReporteConfiguraciones.pdf";
                    String htmlPath = outputPath + "/ReporteConfiguraciones.html";

                    // Crear directorios si no existen
                    new File(outputPath).mkdirs();

                    // Exportar según las opciones seleccionadas
                    StringBuilder successMessage = new StringBuilder("Report generated in ");
                    if (generatePDF) {
                        JasperExportManager.exportReportToPdfFile(jasperPrint, pdfPath);
                        successMessage.append("PDF (").append(pdfPath).append(")");
                    }
                    if (generateHTML) {
                        if (generatePDF) {
                            successMessage.append(" and ");
                        }
                        JasperExportManager.exportReportToHtmlFile(jasperPrint, htmlPath);
                        successMessage.append("HTML (").append(htmlPath).append(")");
                    }
                    JOptionPane.showMessageDialog(ReportWindow.this, successMessage.toString(), "Success", JOptionPane.INFORMATION_MESSAGE);

                    // Mostrar el informe en un visor
                    JasperViewer viewer = new JasperViewer(jasperPrint, false);
                    viewer.setVisible(true);

                } catch (JRException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ReportWindow.this, "Error generating report: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Método para mostrar el diálogo (puedes usarlo si lo llamas desde MainWindow)
    public void showDialog() {
        setVisible(true);
    }
}
