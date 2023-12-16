package game.components;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JComponent {

    private ImageIcon background = new ImageIcon("assets/pxArt.png");

    @Override
    protected void paintComponent(Graphics g) {
        System.out.println("Estoy en paintComponent");
        super.paintComponent(g);
        g.drawImage(background.getImage(), 0, 0, this);
    }
}
