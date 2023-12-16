package entregable.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

/*
* Clase encargada de mostrar la imagen inicial del juego.
* */

public class InitialImage extends JFrame {

    private final Font customFont;
    private boolean startPressed = false;

    private final int WIDTH = 500;
    private final int HEIGHT = 469;

    /*
    * Constructor de la clase.
    * */
    public InitialImage() {

        /*
        * Se establece el tamaño de la ventana y se deshabilita la opción de cambiar el tamaño de la misma.
         */

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);

        /*
        * Se establece el icono de la ventana y se carga la fuente personalizada.
        * */

        this.setIconImage(new ImageIcon("assets/castleIcon.jpg").getImage());
        File fontFile = new File("fonts/joystix-monospace.otf");
        try {
            this.customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }

        /*
        * Se agrega el título de la ventana.
         */

        JLabel titleLabel = new JLabel("Tower");
        titleLabel.setForeground(Color.YELLOW);
        titleLabel.setFont(customFont.deriveFont(50f));
        titleLabel.setBounds(70, 110, 500, 50);

        JLabel titleLabel2 = new JLabel("Defense");
        titleLabel2.setForeground(Color.YELLOW);
        titleLabel2.setFont(customFont.deriveFont(50f));
        titleLabel2.setBounds(30, 160, 500, 50);

        /*
        Se agrega el boton de Start el cual dara comienzo al juego.
         */
        JButton startButton = createButton("Start", e -> {
            startPressed = true;
            dispose();
        });
        startButton.setBounds(125, 245, 120, 50);


        /*
        Se agrega el boton de Exit el cual cerrara la ventana.
         */

        JButton exitButton = createButton("Exit", e -> System.exit(0));
        exitButton.setBounds(130, 295, 110, 50);


        setLayout(null);
        add(titleLabel);
        add(titleLabel2);
        add(startButton);
        add(exitButton);

        /*
        * Se agrega la imagen de fondo.
         */

        ImageIcon backgroundImage = new ImageIcon("assets/towerDefense.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        add(backgroundLabel);

        setLocationRelativeTo(null); //Coloca la ventana en el centro de la pantalla
        setVisible(true);
    }

    /*
     * Metodo encargado de crear los botones del menu.
     * */

    private JButton createButton(String text, ActionListener action) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setFont(customFont.deriveFont(18f));

        /*
         * Se establece el color de fondo del boton como transparente.
         */
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setBorder(null);
        button.setFocusPainted(false);

        button.addActionListener(action);

        /*
        Se utilizan clases anonimas para cambiar el color y el tamaño de la fuente del boton cuando el mouse entra y sale del mismo.
        Las clases anonimas nos permiten sobreescribir los metodos de la clase MouseAdapter sin necesidad de crear una clase que herede de la misma.
        Al utilizar MouseAdapter en lugar de MouseListener, solo sobreescribimos los metodos que nos interesan (el resto se establecen como vacios).
         */

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setFont(customFont.deriveFont(19f));
                button.setForeground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setFont(customFont.deriveFont(18f));
                button.setForeground(Color.WHITE);
            }
        });

        return button;
    }

    public boolean isStartPressed() {
        return startPressed;
    }


    /*
    * Metodo main de la clase. Nos sirve para testear la misma.
     */

    public static void main(String[] args) {
        InitialImage initialImage = new InitialImage();
        initialImage.setVisible(true);

        // Wait until the "Start" button is pressed
        while (initialImage.isStartPressed()) {
            try {
                Thread.sleep(100); // Sleep for a short duration to avoid busy-waiting
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Start game");
    }
}
