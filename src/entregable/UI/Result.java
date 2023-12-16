package entregable.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;


/*
* Clase encargada de mostrar el resultado del juego.
* */

public class Result extends JFrame {
    Font customFont;

    private final int WIDTH = 500;
    private final int HEIGHT = 469;

    /*
    * Constructor de la clase.
    * */
    public Result(int castleRedLife, int castleBlueLife, int rounds) {

        /*
        * Se establece el icono de la ventana y se carga la fuente personalizada.
        * */

        this.setIconImage(new ImageIcon("assets/castleIcon.jpg").getImage());
        File fontFile = new File("fonts/joystix-monospace.otf");
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }

        /*
        * Se establece el tamaño de la ventana.
        * */


        setTitle("Fin del juego");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(WIDTH, HEIGHT);
        setResizable(false);

       /*
       * Titulo
       * */

        //Titulo
        JLabel titleLabel = new JLabel("Juego Finalizado!");
        titleLabel.setForeground(Color.YELLOW);
        titleLabel.setFont(customFont.deriveFont(Font.BOLD, 25));
        titleLabel.setBounds(WIDTH / 2 - 190, 30, 500, 50);


        /*
         * ExitButton
         * */

        //ExitButton
        JButton exitButton = createButton("Exit", e -> System.exit(0));
        exitButton.setBounds(WIDTH/2-50, 350, 90, 50);


        /*
         * Rondas Jugadas
         * */

        JLabel roundsLabel = new JLabel("Rondas Jugadas: " + rounds);
        roundsLabel.setForeground(Color.WHITE);
        roundsLabel.setFont(customFont.deriveFont(Font.BOLD, 17));
        roundsLabel.setBounds(WIDTH/2 - 130, 280, 300, 40);


        /*
         * Resultado
         * */

        //Si empatan
        String result = "Empate!";
        JLabel resultLabel = new JLabel(result);
        resultLabel.setForeground(Color.WHITE);
        resultLabel.setBounds(WIDTH/2-75, 100, 300, 30);
        resultLabel.setFont(customFont.deriveFont(Font.BOLD, 25));

        if(castleBlueLife > 0 && castleRedLife > 0){
            JLabel lifesLabel = new JLabel("Vidas Restantes:");
            lifesLabel.setFont(customFont.deriveFont(Font.BOLD, 15));
            lifesLabel.setBounds(WIDTH/2-100, 165, 500, 30);
            lifesLabel.setForeground(Color.WHITE);

            JLabel castleBlueLabel = new JLabel("Castillo azul: " + castleBlueLife);
            castleBlueLabel.setFont(customFont.deriveFont(Font.BOLD, 14));
            castleBlueLabel.setBounds(WIDTH/2-100, 190, 300, 30);
            castleBlueLabel.setForeground(Color.BLUE);

            JLabel castleRedLabel = new JLabel("Castillo rojo: " + castleRedLife);
            castleRedLabel.setFont(customFont.deriveFont(Font.BOLD, 14));
            castleRedLabel.setBounds(WIDTH/2-100, 215, 300, 30);
            castleRedLabel.setForeground(Color.RED);

            add(lifesLabel);
            add(castleBlueLabel);
            add(castleRedLabel);
        }
        //Si gana algun jugador.
        else{
            Color color = Color.WHITE;
            JLabel winnerLabel;
            if (castleBlueLife == 0) {
                result = "Gano el jugador rojo!";
                winnerLabel = new JLabel("El ganador tiene " +  castleRedLife + " vida/s restante/s");
                color = Color.RED;

            } else {
                result = "Gano el jugador azul!";
                winnerLabel = new JLabel("El ganador tiene " +  castleBlueLife + " vida/s restante/s");
                color = Color.BLUE;
            }
            winnerLabel.setForeground(Color.WHITE);
            winnerLabel.setFont(customFont.deriveFont(Font.BOLD, 14));
            winnerLabel.setBounds(WIDTH/2-225, 175, 600, 40);

            resultLabel = new JLabel(result);
            resultLabel.setForeground(color);
            resultLabel.setFont(customFont.deriveFont(Font.BOLD, 16));
            resultLabel.setBounds(WIDTH/2-135, 110, 500, 30);
            add(winnerLabel);
        }

        setLayout(null);
        add(titleLabel);
        add(resultLabel);
        add(roundsLabel);
        add(exitButton);
        setLocationRelativeTo(null);

        /*
         * Se establece el fondo a utilizar.
         * */

        ImageIcon backgroundImage = new ImageIcon("assets/finalBackground.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        add(backgroundLabel);
    }

    /*
     * Metodo encargado de crear los botones del menu.
     * */

    private JButton createButton(String text, ActionListener action){
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

}