/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nfs://localhost:8888/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import util.DatabaseConnection;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author nicop
 */
public class AddComponentWindow extends JDialog {

    // Referencias a los JTextField de cada panel
    // CPU
    private JTextField cpuBrandField;
    private JTextField cpuModelField;
    private JTextField cpuCoresField;
    private JTextField cpuThreadsField;
    private JTextField cpuFreqField;
    private JTextField cpuSocketField;
    private JTextField cpuYearField;
    private JTextField cpuPowerField;

    // Disks
    private JTextField diskBrandField;
    private JTextField diskModelField;
    private JTextField diskStorageField;
    private JTextField diskTypeField;
    private JTextField diskConnField;

    // GPU
    private JTextField gpuBrandField;
    private JTextField gpuModelField;
    private JTextField gpuMemoryField;
    private JTextField gpuYearField;
    private JTextField gpuPowerField;

    // Motherboard
    private JTextField moboBrandField;
    private JTextField moboModelField;
    private JTextField moboChipsetField;
    private JTextField moboSocketField;

    // PSU
    private JTextField psuBrandField;
    private JTextField psuModelField;
    private JTextField psuPowerField;
    private JTextField psuCertField;

    // RAM
    private JTextField ramBrandField;
    private JTextField ramModelField;
    private JTextField ramMemoryField;
    private JTextField ramSpeedField;
    private JTextField ramSocketField;

    private JComboBox<String> cbItems; // Para acceder al componente seleccionado

    public AddComponentWindow(JFrame parent) {
        super(parent, "Añadir componente", true); // true hace que sea modal
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Cerrar y liberar recursos
        setLayout(new BorderLayout());
        setSize(400, 450);
        setLocationRelativeTo(parent); // Centrar respecto a la ventana padre

        cbItems = new JComboBox<>();
        cbItems.addItem("CPU");
        cbItems.addItem("Disks");
        cbItems.addItem("GPU");
        cbItems.addItem("Motherboard");
        cbItems.addItem("PSU");
        cbItems.addItem("RAM");

        add(cbItems, BorderLayout.NORTH);

        JPanel panelPadre = new JPanel(new CardLayout());
        // Definir cada panel con GridBagLayout
        JPanel panelCpu = new JPanel(new GridBagLayout());
        JPanel panelDisk = new JPanel(new GridBagLayout());
        JPanel panelGpu = new JPanel(new GridBagLayout());
        JPanel panelMoBo = new JPanel(new GridBagLayout());
        JPanel panelPsu = new JPanel(new GridBagLayout());
        JPanel panelRam = new JPanel(new GridBagLayout());

        panelPadre.add(panelCpu, "CPU");
        panelPadre.add(panelDisk, "Disks");
        panelPadre.add(panelGpu, "GPU");
        panelPadre.add(panelMoBo, "Motherboard");
        panelPadre.add(panelPsu, "PSU");
        panelPadre.add(panelRam, "RAM");
        add(panelPadre, BorderLayout.CENTER);

        cbItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sel = (String) cbItems.getSelectedItem();
                CardLayout card = (CardLayout) panelPadre.getLayout();
                card.show(panelPadre, sel);
            }
        });

        // Añadir botón "Guardar"
        JButton saveButton = new JButton("Guardar");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveComponent();
            }
        });

        // Añadir botón "Clear"
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearAllFields();
            }
        });

        // Panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(clearButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Configurar GridBagConstraints para todos los paneles
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Componentes del panel de info de la CPU
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        panelCpu.add(new JLabel("Brand:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        cpuBrandField = new JTextField(15);
        cpuBrandField.setPreferredSize(new Dimension(150, 25));
        panelCpu.add(cpuBrandField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        panelCpu.add(new JLabel("Model:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        cpuModelField = new JTextField(15);
        cpuModelField.setPreferredSize(new Dimension(150, 25));
        panelCpu.add(cpuModelField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        panelCpu.add(new JLabel("Cores:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        cpuCoresField = new JTextField(15);
        cpuCoresField.setPreferredSize(new Dimension(150, 25));
        panelCpu.add(cpuCoresField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        panelCpu.add(new JLabel("Threads:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        cpuThreadsField = new JTextField(15);
        cpuThreadsField.setPreferredSize(new Dimension(150, 25));
        panelCpu.add(cpuThreadsField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        panelCpu.add(new JLabel("Frequency (GHz):"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        cpuFreqField = new JTextField(15);
        cpuFreqField.setPreferredSize(new Dimension(150, 25));
        panelCpu.add(cpuFreqField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.NONE;
        panelCpu.add(new JLabel("Socket:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        cpuSocketField = new JTextField(15);
        cpuSocketField.setPreferredSize(new Dimension(150, 25));
        panelCpu.add(cpuSocketField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.NONE;
        panelCpu.add(new JLabel("Release Year:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        cpuYearField = new JTextField(15);
        cpuYearField.setPreferredSize(new Dimension(150, 25));
        panelCpu.add(cpuYearField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.NONE;
        panelCpu.add(new JLabel("Power Consumption (W):"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        cpuPowerField = new JTextField(15);
        cpuPowerField.setPreferredSize(new Dimension(150, 25));
        panelCpu.add(cpuPowerField, gbc);

        // Componentes del panel de info del disco
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        panelDisk.add(new JLabel("Brand:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        diskBrandField = new JTextField(15);
        diskBrandField.setPreferredSize(new Dimension(150, 25));
        panelDisk.add(diskBrandField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        panelDisk.add(new JLabel("Model:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        diskModelField = new JTextField(15);
        diskModelField.setPreferredSize(new Dimension(150, 25));
        panelDisk.add(diskModelField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        panelDisk.add(new JLabel("Storage (GB):"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        diskStorageField = new JTextField(15);
        diskStorageField.setPreferredSize(new Dimension(150, 25));
        panelDisk.add(diskStorageField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        panelDisk.add(new JLabel("Type:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        diskTypeField = new JTextField(15);
        diskTypeField.setPreferredSize(new Dimension(150, 25));
        panelDisk.add(diskTypeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        panelDisk.add(new JLabel("Connection:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        diskConnField = new JTextField(15);
        diskConnField.setPreferredSize(new Dimension(150, 25));
        panelDisk.add(diskConnField, gbc);

        // Componentes del panel de info de la GPU
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        panelGpu.add(new JLabel("Brand:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gpuBrandField = new JTextField(15);
        gpuBrandField.setPreferredSize(new Dimension(150, 25));
        panelGpu.add(gpuBrandField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        panelGpu.add(new JLabel("Model:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gpuModelField = new JTextField(15);
        gpuModelField.setPreferredSize(new Dimension(150, 25));
        panelGpu.add(gpuModelField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        panelGpu.add(new JLabel("Memory (GB):"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gpuMemoryField = new JTextField(15);
        gpuMemoryField.setPreferredSize(new Dimension(150, 25));
        panelGpu.add(gpuMemoryField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        panelGpu.add(new JLabel("Release Year:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gpuYearField = new JTextField(15);
        gpuYearField.setPreferredSize(new Dimension(150, 25));
        panelGpu.add(gpuYearField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        panelGpu.add(new JLabel("Power Consumption (W):"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gpuPowerField = new JTextField(15);
        gpuPowerField.setPreferredSize(new Dimension(150, 25));
        panelGpu.add(gpuPowerField, gbc);

        // Componentes del panel de info de la placa base
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        panelMoBo.add(new JLabel("Brand:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        moboBrandField = new JTextField(15);
        moboBrandField.setPreferredSize(new Dimension(150, 25));
        panelMoBo.add(moboBrandField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        panelMoBo.add(new JLabel("Model:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        moboModelField = new JTextField(15);
        moboModelField.setPreferredSize(new Dimension(150, 25));
        panelMoBo.add(moboModelField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        panelMoBo.add(new JLabel("Chipset:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        moboChipsetField = new JTextField(15);
        moboChipsetField.setPreferredSize(new Dimension(150, 25));
        panelMoBo.add(moboChipsetField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        panelMoBo.add(new JLabel("Socket:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        moboSocketField = new JTextField(15);
        moboSocketField.setPreferredSize(new Dimension(150, 25));
        panelMoBo.add(moboSocketField, gbc);

        // Componentes del panel de info de la PSU
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        panelPsu.add(new JLabel("Brand:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        psuBrandField = new JTextField(15);
        psuBrandField.setPreferredSize(new Dimension(150, 25));
        panelPsu.add(psuBrandField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        panelPsu.add(new JLabel("Model:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        psuModelField = new JTextField(15);
        psuModelField.setPreferredSize(new Dimension(150, 25));
        panelPsu.add(psuModelField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        panelPsu.add(new JLabel("Power (W):"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        psuPowerField = new JTextField(15);
        psuPowerField.setPreferredSize(new Dimension(150, 25));
        panelPsu.add(psuPowerField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        panelPsu.add(new JLabel("Certification:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        psuCertField = new JTextField(15);
        psuCertField.setPreferredSize(new Dimension(150, 25));
        panelPsu.add(psuCertField, gbc);

        // Componentes del panel de info de la RAM
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        panelRam.add(new JLabel("Brand:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        ramBrandField = new JTextField(15);
        ramBrandField.setPreferredSize(new Dimension(150, 25));
        panelRam.add(ramBrandField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        panelRam.add(new JLabel("Model:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        ramModelField = new JTextField(15);
        ramModelField.setPreferredSize(new Dimension(150, 25));
        panelRam.add(ramModelField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        panelRam.add(new JLabel("Memory (GB):"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        ramMemoryField = new JTextField(15);
        ramMemoryField.setPreferredSize(new Dimension(150, 25));
        panelRam.add(ramMemoryField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        panelRam.add(new JLabel("Speed (MHz):"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        ramSpeedField = new JTextField(15);
        ramSpeedField.setPreferredSize(new Dimension(150, 25));
        panelRam.add(ramSpeedField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        panelRam.add(new JLabel("Socket:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        ramSocketField = new JTextField(15);
        ramSocketField.setPreferredSize(new Dimension(150, 25));
        panelRam.add(ramSocketField, gbc);
    }

    private void saveComponent() {
        String selectedComponent = (String) cbItems.getSelectedItem();
        try {
            switch (selectedComponent) {
                case "CPU":
                    saveCpu();
                    break;
                case "Disks":
                    saveDisk();
                    break;
                case "GPU":
                    saveGpu();
                    break;
                case "Motherboard":
                    saveMotherboard();
                    break;
                case "PSU":
                    savePsu();
                    break;
                case "RAM":
                    saveRam();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione un componente válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
            }
            JOptionPane.showMessageDialog(null, "Componente guardado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            clearFields(selectedComponent);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el componente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveCpu() throws SQLException {
        String brand = cpuBrandField.getText().trim();
        String model = cpuModelField.getText().trim();
        String coresText = cpuCoresField.getText().trim();
        String threadsText = cpuThreadsField.getText().trim();
        String freqText = cpuFreqField.getText().trim();
        String socket = cpuSocketField.getText().trim();
        String yearText = cpuYearField.getText().trim();
        String powerText = cpuPowerField.getText().trim();

        if (brand.isEmpty() || model.isEmpty() || coresText.isEmpty() || threadsText.isEmpty() ||
            freqText.isEmpty() || socket.isEmpty() || yearText.isEmpty() || powerText.isEmpty()) {
            throw new IllegalArgumentException("Todos los campos son obligatorios.");
        }

        int cores, threads, year, power;
        float frequency;
        try {
            cores = Integer.parseInt(coresText);
            threads = Integer.parseInt(threadsText);
            frequency = Float.parseFloat(freqText);
            year = Integer.parseInt(yearText);
            power = Integer.parseInt(powerText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Cores, Threads, Frequency, Release Year y Power Consumption deben ser valores numéricos.");
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO cpu (marca, modelo, nucleos, hilos, frecuencia, socket, año_lanzamiento, consumo_energetico) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
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

    private void saveDisk() throws SQLException {
        String brand = diskBrandField.getText().trim();
        String model = diskModelField.getText().trim();
        String storageText = diskStorageField.getText().trim();
        String type = diskTypeField.getText().trim();
        String connection = diskConnField.getText().trim();

        if (brand.isEmpty() || model.isEmpty() || storageText.isEmpty() || type.isEmpty() || connection.isEmpty()) {
            throw new IllegalArgumentException("Todos los campos son obligatorios.");
        }

        int storage;
        try {
            storage = Integer.parseInt(storageText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Storage debe ser un valor numérico.");
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO discos (marca, modelo, capacidad, tipo, conexion) " +
                     "VALUES (?, ?, ?, ?, ?)")) {
            stmt.setString(1, brand);
            stmt.setString(2, model);
            stmt.setInt(3, storage);
            stmt.setString(4, type);
            stmt.setString(5, connection);
            stmt.executeUpdate();
        }
    }

    private void saveGpu() throws SQLException {
        String brand = gpuBrandField.getText().trim();
        String model = gpuModelField.getText().trim();
        String memoryText = gpuMemoryField.getText().trim();
        String yearText = gpuYearField.getText().trim();
        String powerText = gpuPowerField.getText().trim();

        if (brand.isEmpty() || model.isEmpty() || memoryText.isEmpty() || yearText.isEmpty() || powerText.isEmpty()) {
            throw new IllegalArgumentException("Todos los campos son obligatorios.");
        }

        int memory, year, power;
        try {
            memory = Integer.parseInt(memoryText);
            year = Integer.parseInt(yearText);
            power = Integer.parseInt(powerText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Memory, Release Year y Power Consumption deben ser valores numéricos.");
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO gpu (marca, modelo, memoria, año_lanzamiento, consumo_energetico) " +
                     "VALUES (?, ?, ?, ?, ?)")) {
            stmt.setString(1, brand);
            stmt.setString(2, model);
            stmt.setInt(3, memory);
            stmt.setInt(4, year);
            stmt.setInt(5, power);
            stmt.executeUpdate();
        }
    }

    private void saveMotherboard() throws SQLException {
        String brand = moboBrandField.getText().trim();
        String model = moboModelField.getText().trim();
        String chipset = moboChipsetField.getText().trim();
        String socket = moboSocketField.getText().trim();

        if (brand.isEmpty() || model.isEmpty() || chipset.isEmpty() || socket.isEmpty()) {
            throw new IllegalArgumentException("Todos los campos son obligatorios.");
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO motherboard (marca, modelo, chipset, socket) " +
                     "VALUES (?, ?, ?, ?)")) {
            stmt.setString(1, brand);
            stmt.setString(2, model);
            stmt.setString(3, chipset);
            stmt.setString(4, socket);
            stmt.executeUpdate();
        }
    }

    private void savePsu() throws SQLException {
        String brand = psuBrandField.getText().trim();
        String model = psuModelField.getText().trim();
        String powerText = psuPowerField.getText().trim();
        String certification = psuCertField.getText().trim();

        if (brand.isEmpty() || model.isEmpty() || powerText.isEmpty() || certification.isEmpty()) {
            throw new IllegalArgumentException("Todos los campos son obligatorios.");
        }

        int power;
        try {
            power = Integer.parseInt(powerText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Power debe ser un valor numérico.");
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO psu (marca, modelo, potencia, certificacion) " +
                     "VALUES (?, ?, ?, ?)")) {
            stmt.setString(1, brand);
            stmt.setString(2, model);
            stmt.setInt(3, power);
            stmt.setString(4, certification);
            stmt.executeUpdate();
        }
    }

    private void saveRam() throws SQLException {
        String brand = ramBrandField.getText().trim();
        String model = ramModelField.getText().trim();
        String memoryText = ramMemoryField.getText().trim();
        String speedText = ramSpeedField.getText().trim();
        String socket = ramSocketField.getText().trim();

        if (brand.isEmpty() || model.isEmpty() || memoryText.isEmpty() || speedText.isEmpty() || socket.isEmpty()) {
            throw new IllegalArgumentException("Todos los campos son obligatorios.");
        }

        int memory, speed;
        try {
            memory = Integer.parseInt(memoryText);
            speed = Integer.parseInt(speedText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Memory y Speed deben ser valores numéricos.");
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO ram (marca, modelo, capacidad, velocidad, socket) " +
                     "VALUES (?, ?, ?, ?, ?)")) {
            stmt.setString(1, brand);
            stmt.setString(2, model);
            stmt.setInt(3, memory);
            stmt.setInt(4, speed);
            stmt.setString(5, socket);
            stmt.executeUpdate();
        }
    }

    private void clearFields(String component) {
        switch (component) {
            case "CPU":
                cpuBrandField.setText("");
                cpuModelField.setText("");
                cpuCoresField.setText("");
                cpuThreadsField.setText("");
                cpuFreqField.setText("");
                cpuSocketField.setText("");
                cpuYearField.setText("");
                cpuPowerField.setText("");
                break;
            case "Disks":
                diskBrandField.setText("");
                diskModelField.setText("");
                diskStorageField.setText("");
                diskTypeField.setText("");
                diskConnField.setText("");
                break;
            case "GPU":
                gpuBrandField.setText("");
                gpuModelField.setText("");
                gpuMemoryField.setText("");
                gpuYearField.setText("");
                gpuPowerField.setText("");
                break;
            case "Motherboard":
                moboBrandField.setText("");
                moboModelField.setText("");
                moboChipsetField.setText("");
                moboSocketField.setText("");
                break;
            case "PSU":
                psuBrandField.setText("");
                psuModelField.setText("");
                psuPowerField.setText("");
                psuCertField.setText("");
                break;
            case "RAM":
                ramBrandField.setText("");
                ramModelField.setText("");
                ramMemoryField.setText("");
                ramSpeedField.setText("");
                ramSocketField.setText("");
                break;
        }
    }

    private void clearAllFields() {
        // Limpiar campos de CPU
        cpuBrandField.setText("");
        cpuModelField.setText("");
        cpuCoresField.setText("");
        cpuThreadsField.setText("");
        cpuFreqField.setText("");
        cpuSocketField.setText("");
        cpuYearField.setText("");
        cpuPowerField.setText("");

        // Limpiar campos de Disks
        diskBrandField.setText("");
        diskModelField.setText("");
        diskStorageField.setText("");
        diskTypeField.setText("");
        diskConnField.setText("");

        // Limpiar campos de GPU
        gpuBrandField.setText("");
        gpuModelField.setText("");
        gpuMemoryField.setText("");
        gpuYearField.setText("");
        gpuPowerField.setText("");

        // Limpiar campos de Motherboard
        moboBrandField.setText("");
        moboModelField.setText("");
        moboChipsetField.setText("");
        moboSocketField.setText("");

        // Limpiar campos de PSU
        psuBrandField.setText("");
        psuModelField.setText("");
        psuPowerField.setText("");
        psuCertField.setText("");

        // Limpiar campos de RAM
        ramBrandField.setText("");
        ramModelField.setText("");
        ramMemoryField.setText("");
        ramSpeedField.setText("");
        ramSocketField.setText("");
    }
}