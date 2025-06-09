package help;

/**
 *
 * Una aplicación tonta con dos ventanas y un menú. En ella se puede ver la
 * ayuda de JavaHelp pulsando el item de menu adecuado o la tecla F1.
 * Sirve como basico ejemplo de uso de JavaHelp.
 *
 *  @author nicop
 */
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class PruebaJavaHelp {

    /**
     * Ventana secundaria
     */
    private JDialog secundaria;

    /**
     * Ventana principal
     */
    private JFrame principal;

    /**
     * Item de menú para la ayuda
     */
    private JMenuItem itemAyuda;

    /**
     * Botón que despliega la ventana secundaria
     */
    private JButton botonMuestraSecundaria;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PruebaJavaHelp::new);
    }

    public PruebaJavaHelp() {
        creaVentanaPrincipal();
        creaVentanaSecundaria();

        botonMuestraSecundaria.addActionListener(e -> secundaria.setVisible(true));

        ponLaAyuda();
        visualizaVentanaPrincipal();
    }

    private void visualizaVentanaPrincipal() {
        principal.pack();
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
        principal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void ponLaAyuda() {
        try {
            // Carga el fichero de ayuda
            URL hsURL = getClass().getClassLoader().getResource("help/help_set.hs");

            if (hsURL == null) {
                System.out.println("No se encontró el archivo de ayuda en el classpath.");
                return;
            }

            System.out.println("Archivo de ayuda encontrado en: " + hsURL);

            // Crea el HelpSet y el HelpBroker
            HelpSet helpset = new HelpSet(null, hsURL);
            HelpBroker hb = helpset.createHelpBroker();

            // Pone ayuda a item de menú al pulsarlo y a F1 en ventanas
            hb.enableHelpOnButton(itemAyuda, "aplicacion", helpset);
            hb.enableHelpKey(principal.getContentPane(), "ventana_principal", helpset);
            hb.enableHelpKey(secundaria.getContentPane(), "ventana_secundaria", helpset);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void creaVentanaPrincipal() {
        principal = new JFrame("Ventana principal");
        JMenuBar menuBar = new JMenuBar();
        itemAyuda = new JMenuItem("Ayuda");
        menuBar.add(itemAyuda);
        botonMuestraSecundaria = new JButton("Púlsame");
        principal.setJMenuBar(menuBar);
        principal.getContentPane().setLayout(new FlowLayout());
        principal.getContentPane().add(botonMuestraSecundaria);
        principal.getContentPane().add(new JTextField(20));
    }

    private void creaVentanaSecundaria() {
        secundaria = new JDialog(principal, "Ventana secundaria");
        secundaria.getContentPane().setLayout(new FlowLayout());
        secundaria.getContentPane().add(new JLabel("Yo no hago nada"));
        secundaria.getContentPane().add(new JTextField(20));
        secundaria.pack();
        secundaria.setLocationRelativeTo(principal);
    }
}
