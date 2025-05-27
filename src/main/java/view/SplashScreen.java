package view;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * Ventana de splash screen que muestra una introducción y redirige a
 * LoginWindow.
 *
 * @author nicop
 */
public class SplashScreen extends JFrame {

    private static final int SPLASH_TIME = 3000; // Tiempo en milisegundos (3 segundos)

    // Componente para la imagen
    private JLabel picLabel;

    /**
     * Constructor que inicializa el splash screen y redirige a LoginWindow
     * después de SPLASH_TIME (3 sec).
     */
    public SplashScreen() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(512, 512);
        setUndecorated(true);

        // Centrar la ventana
        Point centerPoint = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        setLocation(centerPoint.x - getWidth() / 2, centerPoint.y - getHeight() / 2);

        // Cargar y agregar la imagen
        try {
            BufferedImage splashLogo = ImageIO.read(getClass().getResource("/logo.png"));
            picLabel = new JLabel(new ImageIcon(splashLogo));
            add(picLabel);
        } catch (IOException e) {
            System.err.println("Error al cargar la imagen logo.png: " + e.getMessage());
            picLabel = new JLabel("Cargando..."); // Fallback si la imagen falla
            add(picLabel);
        }

        // Temporizador para cerrar el splash screen y redirigir (Con labda (lo del half-life λ) expresion)
        Timer timer = new Timer(SPLASH_TIME, e -> {
            dispose(); // Cerrar el splash screen
            redirectToLogin();
        });
        timer.setRepeats(false); // Ejecutar solo una vez
        timer.start();
    }

    /**
     * Redirige a la ventana de login.
     */
    private void redirectToLogin() {
        LoginWindow loginWindow = new LoginWindow();
        loginWindow.setVisible(true);
    }

    /**
     * Punto de entrada principal para iniciar la aplicación.
     *
     * @param args Argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        SplashScreen splash = new SplashScreen();
        splash.setVisible(true);
    }
}
