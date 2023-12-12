package entregable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Result extends JFrame {


    public Result() {

    }

    public void showResult(int castleRedLife, int castleBlueLife, int rounds) {
        setTitle("Fin del juego");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 500, height = 250;

        setSize(width, height);
        setResizable(false);

        ImageIcon icon = new ImageIcon("assets/castleIcon.png");
        setIconImage(icon.getImage());

        //Titulo

        JLabel titleLabel = new JLabel("Juego Finalizado!");
        titleLabel.setFont(new Font("Montserrat", Font.BOLD, 24));
        titleLabel.setBounds(width / 2 - 90, 10, 500, 50);

        //Rondas

        JLabel roundsLabel = new JLabel("Rondas: " + rounds);
        roundsLabel.setFont(new Font("Montserrat", Font.BOLD, 14));
        roundsLabel.setBounds(290, 170, 300, 40);

        //Resultado

        String result = "Empate";
        ImageIcon castleImage = new ImageIcon("assets/tieCastle.png");
        JLabel resultLabel = new JLabel(result);
        resultLabel.setBounds(297, 60, 200, 30);
        resultLabel.setFont(new Font("Montserrat", Font.BOLD, 18));

        if(castleBlueLife > 0 && castleRedLife > 0){
            JLabel lifesLabel = new JLabel("Información de vidas:");
            lifesLabel.setFont(new Font("Montserrat", Font.BOLD, 14));
            lifesLabel.setBounds(250, 100, 200, 30);

            JLabel castleBlueLabel = new JLabel("Castillo azul: " + castleBlueLife);
            castleBlueLabel.setFont(new Font("Montserrat", Font.BOLD, 12));
            castleBlueLabel.setBounds(250, 120, 200, 30);

            JLabel castleRedLabel = new JLabel("Castillo rojo: " + castleRedLife);
            castleRedLabel.setFont(new Font("Montserrat", Font.BOLD, 12));
            castleRedLabel.setBounds(250, 140, 200, 30);

            add(lifesLabel);
            add(castleBlueLabel);
            add(castleRedLabel);
        }
        else{
            JLabel winnerLabel;
            if (castleBlueLife == 0) {
                result = "Gano el jugador rojo!";
                castleImage = new ImageIcon("assets/redCastle.png");
                winnerLabel = new JLabel("El castillo ganador tiene " + castleRedLife + " vida/s restante/s");

            } else {
                result = "Gano el jugador azul!";
                castleImage = new ImageIcon("assets/blueCastle.png");
                winnerLabel = new JLabel("El castillo ganador tiene " + castleBlueLife + " vida/s restante/s");

            }
            winnerLabel.setFont(new Font("Montserrat", Font.BOLD, 14));
            winnerLabel.setBounds(170, 120, 340, 40);

            resultLabel = new JLabel(result);
            resultLabel.setBounds(260, 80, 200, 30);
            resultLabel.setFont(new Font("Montserrat", Font.BOLD, 16));

            add(winnerLabel);
        }


        JLabel castleImageLabel = new JLabel(castleImage);
        castleImageLabel.setBounds(40, 50, 128, 148);

        setLayout(null);
        add(titleLabel);
        add(resultLabel);
        add(castleImageLabel);
        add(roundsLabel);

        setLocationRelativeTo(null);
        setVisible(true);
    }


    public static void main (String[] args){
        Result result = new Result();
        result.showResult(0, 1, 20);
        //System.exit(0);
    }
}
