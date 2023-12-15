package entregable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InitialImage extends JFrame {

//    private Fontgcc
    public InitialImage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 469);
        setResizable(false);

        JLabel titleLabel = new JLabel("Tower");
        titleLabel.setForeground(Color.YELLOW);
        titleLabel.setFont(new Font("Joystix Monospace", Font.BOLD, 50));
        titleLabel.setBounds(70, 110, 500, 50);

        JLabel titleLabel2 = new JLabel("Defense");
        titleLabel2.setForeground(Color.YELLOW);
        titleLabel2.setFont(new Font("Joystix Monospace", Font.BOLD, 50));
        titleLabel2.setBounds(30, 160, 500, 50);

        //start button
        JLabel startLabel = createLabel("Start", () -> {
            setVisible(false);
//            Main.game();
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InitialImage();
        });
    }
}