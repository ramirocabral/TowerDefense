package entregable;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Result extends JFrame {
    public Result(int castleRedLife, int castleBlueLife, int rounds) {
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
        titleLabel.setFont(new Font("Joystix Monospace", Font.BOLD, 25));
        titleLabel.setBounds(width / 2 - 190, 30, 500, 50);


        //ExitButton
        JLabel exitLabel = createLabel("Exit", () -> System.exit(0));
        exitLabel.setBounds(width/2-23, 350, 90, 50);


        //Rondas

        JLabel roundsLabel = new JLabel("Rondas Jugadas: " + rounds);
        roundsLabel.setForeground(Color.WHITE);
        roundsLabel.setFont(new Font("Joystix Monospace", Font.BOLD, 14));
        roundsLabel.setBounds(width/2 - 100, 280, 300, 40);


        //Resultado

        String result = "Empate!";
        //ImageIcon castleImage = new ImageIcon("assets/tieCastle.png");
        JLabel resultLabel = new JLabel(result);
        resultLabel.setForeground(Color.WHITE);
        resultLabel.setBounds(width/2-40, 100, 300, 30);
        resultLabel.setFont(new Font("ArcadeClassic", Font.BOLD, 25));

        if(castleBlueLife > 0 && castleRedLife > 0){
            JLabel lifesLabel = new JLabel("Informacion de vidas:");
            lifesLabel.setFont(new Font("Joystix Monospace", Font.BOLD, 14));
            lifesLabel.setBounds(width/2-140, 150, 500, 30);
            lifesLabel.setForeground(Color.WHITE);

            JLabel castleBlueLabel = new JLabel("Castillo azul: " + castleBlueLife);
            castleBlueLabel.setFont(new Font("Joystix Monospace", Font.BOLD, 12));
            castleBlueLabel.setBounds(width/2-140, 180, 300, 30);
            castleBlueLabel.setForeground(Color.BLUE);

            JLabel castleRedLabel = new JLabel("Castillo rojo: " + castleRedLife);
            castleRedLabel.setFont(new Font("Joystix Monospace", Font.BOLD, 12));
            castleRedLabel.setBounds(width/2-140, 200, 300, 30);
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
                //castleImage = new ImageIcon("assets/redCastle.png");
                winnerLabel = new JLabel("El castillo rojo tiene " +  castleRedLife + " vida/s restante/s");
                color = Color.RED;

            } else {
                result = "Gano el jugador azul!";
                //castleImage = new ImageIcon("assets/blueCastle.png");
                winnerLabel = new JLabel("El castillo azul tiene " +  castleBlueLife + " vida/s restante/s");
                color = Color.BLUE;
            }
            winnerLabel.setForeground(Color.WHITE);
            winnerLabel.setFont(new Font("Joystix Monospace", Font.BOLD, 12));
            winnerLabel.setBounds(width/2-215, 175, 600, 40);

            resultLabel = new JLabel(result);
            resultLabel.setForeground(color);
            resultLabel.setFont(new Font("Joystix Monospace", Font.BOLD, 16));
            resultLabel.setBounds(width/2-135, 110, 500, 30);
            add(winnerLabel);
        }

        //JLabel castleImageLabel = new JLabel(castleImage);
        //castleImageLabel.setBounds(30, 40, 128, 148);


        setLayout(null);
        add(titleLabel);
        add(resultLabel);
        //add(castleImageLabel);
        add(roundsLabel);
        add(exitLabel);
        setLocationRelativeTo(null);

        ImageIcon backgroundImage = new ImageIcon("assets/finalBackground.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        add(backgroundLabel);
    }

    private static JLabel createLabel(String text, Runnable onClickAction) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Joystix Monospace", Font.BOLD, 16));

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setFont(new Font("Joystix Monospace", Font.BOLD, 22));
                label.setForeground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setFont(new Font("Joystix Monospace", Font.BOLD, 16));
                label.setForeground(Color.WHITE);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                onClickAction.run();
            }
        });

        return label;
    }

    public static void main (String[] args) {
        Result result = new Result(1, 1, 9);
        result.setVisible(true);
        //System.exit(0);
    }
}