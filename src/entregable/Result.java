package entregable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Result extends JFrame {
    Font customFont;
    public Result(int castleRedLife, int castleBlueLife, int rounds) {
        File fontFile = new File("fonts/joystix-monospace.otf");
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
        setTitle("Fin del juego");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 500, height = 469;

        setSize(width, height);
        setResizable(false);

        ImageIcon icon = new ImageIcon("assets/castleIcon.png");
        setIconImage(icon.getImage());

        //Titulo
        JLabel titleLabel = new JLabel("Juego Finalizado!");
        titleLabel.setForeground(Color.YELLOW);
        titleLabel.setFont(customFont.deriveFont(Font.BOLD, 25));
        titleLabel.setBounds(width / 2 - 190, 30, 500, 50);


        //ExitButton
        JLabel exitLabel = createLabel("Exit", () -> System.exit(0));
        exitLabel.setBounds(width/2-30, 350, 90, 50);


        //Rondas

        JLabel roundsLabel = new JLabel("Rondas Jugadas: " + rounds);
        roundsLabel.setForeground(Color.WHITE);
        roundsLabel.setFont(customFont.deriveFont(Font.BOLD, 17));
        roundsLabel.setBounds(width/2 - 130, 280, 300, 40);


        //Resultado

        String result = "Empate!";
        JLabel resultLabel = new JLabel(result);
        resultLabel.setForeground(Color.WHITE);
        resultLabel.setBounds(width/2-65, 100, 300, 30);
        resultLabel.setFont(customFont.deriveFont(Font.BOLD, 25));

        if(castleBlueLife > 0 && castleRedLife > 0){
            JLabel lifesLabel = new JLabel("Vidas Restantes:");
            lifesLabel.setFont(customFont.deriveFont(Font.BOLD, 15));
            lifesLabel.setBounds(width/2-145, 165, 500, 30);
            lifesLabel.setForeground(Color.WHITE);

            JLabel castleBlueLabel = new JLabel("Castillo azul: " + castleBlueLife);
            castleBlueLabel.setFont(customFont.deriveFont(Font.BOLD, 14));
            castleBlueLabel.setBounds(width/2-145, 190, 300, 30);
            castleBlueLabel.setForeground(Color.BLUE);

            JLabel castleRedLabel = new JLabel("Castillo rojo: " + castleRedLife);
            castleRedLabel.setFont(customFont.deriveFont(Font.BOLD, 14));
            castleRedLabel.setBounds(width/2-145, 215, 300, 30);
            castleRedLabel.setForeground(Color.RED);

            add(lifesLabel);
            add(castleBlueLabel);
            add(castleRedLabel);
        }
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
            winnerLabel.setBounds(width/2-225, 175, 600, 40);

            resultLabel = new JLabel(result);
            resultLabel.setForeground(color);
            resultLabel.setFont(customFont.deriveFont(Font.BOLD, 16));
            resultLabel.setBounds(width/2-135, 110, 500, 30);
            add(winnerLabel);
        }

        setLayout(null);
        add(titleLabel);
        add(resultLabel);
        add(roundsLabel);
        add(exitLabel);
        setLocationRelativeTo(null);

        ImageIcon backgroundImage = new ImageIcon("assets/finalBackground.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        add(backgroundLabel);
    }

    private JLabel createLabel(String text, Runnable onClickAction) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(customFont.deriveFont(Font.BOLD, 16));

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setFont(customFont.deriveFont(Font.BOLD, 18));
                label.setForeground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setFont(customFont.deriveFont(Font.BOLD, 16));
                label.setForeground(Color.WHITE);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                onClickAction.run();
                System.exit(0);
            }
        });

        return label;
    }

}