package entregable.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import game.components.Game;

public class InitialImage extends JFrame {

    private Font customFont;
    public InitialImage() {
        this.setIconImage(new ImageIcon("assets/castleIcon.jpg").getImage());
        File fontFile = new File("fonts/joystix-monospace.otf");
        try {
            this.customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 469);
        setResizable(false);

        JLabel titleLabel = new JLabel("Tower");
        titleLabel.setForeground(Color.YELLOW);
        titleLabel.setFont(customFont.deriveFont(50f));
        titleLabel.setBounds(70, 110, 500, 50);

        JLabel titleLabel2 = new JLabel("Defense");
        titleLabel2.setForeground(Color.YELLOW);
        titleLabel2.setFont(customFont.deriveFont(50f));
        titleLabel2.setBounds(30, 160, 500, 50);

        //start button
        JLabel startLabel = createLabel("Start", () -> {
            Game.game();
            setVisible(false);
        });

        startLabel.setBounds(145, 245, 120, 50);

        //exit button
        JLabel exitLabel = createLabel("Exit", () -> System.exit(0));
        exitLabel.setBounds(150, 295, 90, 50);


        setLayout(null);
        add(titleLabel);
        add(titleLabel2);
        add(startLabel);
        add(exitLabel);

        ImageIcon backgroundImage = new ImageIcon("assets/towerDefense.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        add(backgroundLabel);

        setLocationRelativeTo(null);
//        setVisible(true);
    }
    private  JLabel createLabel(String text, Runnable onClickAction) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(customFont.deriveFont(18f));


        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setFont(customFont.deriveFont(19f));
                label.setForeground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setFont(customFont.deriveFont(18f));
                label.setForeground(Color.WHITE);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                onClickAction.run();
            }
        });
        return label;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InitialImage();
        });
    }
}