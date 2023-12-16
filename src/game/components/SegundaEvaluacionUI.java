package game.components;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SegundaEvaluacionUI extends JFrame {

    private List<JPanel> panelList = new ArrayList<>();

    private List<JLabel> buttons = new ArrayList<>();
    private List<JProgressBar> healthBars = new ArrayList<>();

    private JLabel[] labels1;

    private JLabel[] labels2;

    public SegundaEvaluacionUI init() {
        this.setIconImage(new ImageIcon("assets/castleIcon.jpg").getImage());
        this.initPanels();
        this.addButtons();
        setContentPane(new BackgroundPanel());
        setTitle("Tower Defense");
        setSize(600, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout gridLayout = new GridLayout(5,3);
        panelList.forEach(SegundaEvaluacionUI.this::add);

        setLayout(gridLayout);
        setLocationRelativeTo(null);
        return this;
    }

   //retorna el boton de la lista DE BOTONES, no de paneles
    public JLabel getButton(int index) {
        return buttons.get(index);
    }

    public JProgressBar getHealthBar(int index) {
        return healthBars.get(index);
    }

    /*
     Inicializa los espacios para las imagenes de los monsturos en el tablero
    * */
    private void addButtons() {

        //button 3
        JLabel button3 = new JLabel();
        panelList.get(3).setLayout(new BoxLayout(panelList.get(3), BoxLayout.Y_AXIS));
        panelList.get(3).add(button3);
        button3.setVisible(false);
        button3.setHorizontalAlignment(SwingConstants.RIGHT);
        button3.setAlignmentX(Component.RIGHT_ALIGNMENT);
        button3.setVerticalAlignment(SwingConstants.TOP);
        buttons.add(button3);

        JProgressBar healthBar3 = new JProgressBar();
        healthBar3.setPreferredSize(new Dimension(90, 13));
        healthBar3.setMaximumSize(new Dimension(90, 13));
        healthBar3.setAlignmentX(button3.getAlignmentX());
        panelList.get(3).add(healthBar3);
        healthBar3.setVisible(false);
        healthBars.add(healthBar3);

       //button 5

        JLabel button5 = new JLabel();
        panelList.get(5).setLayout(new BoxLayout(panelList.get(5), BoxLayout.Y_AXIS));
        button5.setHorizontalAlignment(SwingConstants.LEFT);
        button5.setAlignmentX(Component.LEFT_ALIGNMENT);
        button5.setVerticalAlignment(SwingConstants.TOP);
        button5.setVisible(false);
        buttons.add(button5);
        panelList.get(5).add(button5);

        JProgressBar healthBar5 = new JProgressBar();
        healthBar5.setPreferredSize(new Dimension(90, 13));
        healthBar5.setMaximumSize(new Dimension(90, 13));
        healthBar5.setAlignmentX(button5.getAlignmentX());
        panelList.get(5).add(healthBar5);
        healthBar5.setVisible(false);
        healthBars.add(healthBar5);


        //button 6
        JLabel button6 = new JLabel();
        panelList.get(6).setLayout(new BoxLayout(panelList.get(6), BoxLayout.Y_AXIS));
        button6.setHorizontalAlignment(SwingConstants.RIGHT);
        button6.setAlignmentX(Component.RIGHT_ALIGNMENT);
        button6.setVerticalAlignment(SwingConstants.TOP);
        panelList.get(6).add(button6);
        button6.setVisible(false);
        buttons.add(button6);

        JProgressBar healthBar6 = new JProgressBar();
        healthBar6.setPreferredSize(new Dimension(90, 13));
        healthBar6.setMaximumSize(new Dimension(90, 13));
        healthBar6.setAlignmentX(button6.getAlignmentX());
        panelList.get(6).add(healthBar6);
        healthBar6.setVisible(false);
        healthBars.add(healthBar6);


        //button 8
        JLabel button8 = new JLabel();
        panelList.get(8).setLayout(new BoxLayout(panelList.get(8), BoxLayout.Y_AXIS));
        button8.setHorizontalAlignment(SwingConstants.LEFT);
        button8.setAlignmentX(Component.LEFT_ALIGNMENT);
        button8.setVerticalAlignment(SwingConstants.TOP);
        panelList.get(8).add(button8);
        button8.setVisible(false);
        buttons.add(button8);

        JProgressBar healthBar8 = new JProgressBar();
        healthBar8.setPreferredSize(new Dimension(90, 13));
        healthBar8.setMaximumSize(new Dimension(90, 13));
        healthBar8.setAlignmentX(button8.getAlignmentX());
        panelList.get(8).add(healthBar8);
        healthBar8.setVisible(false);
        healthBars.add(healthBar8);

        //button 9
        JLabel button9 = new JLabel();
        panelList.get(9).setLayout(new BoxLayout(panelList.get(9), BoxLayout.Y_AXIS));
        button9.setHorizontalAlignment(SwingConstants.RIGHT);
        button9.setAlignmentX(Component.RIGHT_ALIGNMENT);
        button9.setVerticalAlignment(SwingConstants.TOP);
        panelList.get(9).add(button9);
        button9.setVisible(false);
        buttons.add(button9);

        JProgressBar healthBar9 = new JProgressBar();
        healthBar9.setPreferredSize(new Dimension(90, 13));
        healthBar9.setMaximumSize(new Dimension(90, 13));
        healthBar9.setAlignmentX(button9.getAlignmentX());
        panelList.get(9).add(healthBar9);
        healthBar9.setVisible(false);
        healthBars.add(healthBar9);

        //button 11
        JLabel button11 = new JLabel();
        panelList.get(11).setLayout(new BoxLayout(panelList.get(11), BoxLayout.Y_AXIS));
        button11.setHorizontalAlignment(SwingConstants.LEFT);
        button11.setAlignmentX(Component.LEFT_ALIGNMENT);
        button11.setVerticalAlignment(SwingConstants.TOP);
        panelList.get(11).add(button11);
        button11.setVisible(false);
        buttons.add(button11);

        JProgressBar healthBar11 = new JProgressBar();
        healthBar11.setPreferredSize(new Dimension(90, 13));
        healthBar11.setMaximumSize(new Dimension(90, 13));
        healthBar11.setAlignmentX(button11.getAlignmentX());
        panelList.get(11).add(healthBar11);
        healthBar11.setVisible(false);
        healthBars.add(healthBar11);


        //borders
//        for (JLabel label : buttons) {
//            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        }

        initLifeLabels();
    }

    /**
     * Inicializa los labels de las vidas de los castillos
     */
    public void initLifeLabels(){
        File file = new File("fonts/joystix-monospace.otf");
        Font customFont;
        try {
             customFont = Font.createFont(Font.TRUETYPE_FONT, file).deriveFont(17f);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
        ImageIcon imageIcon = new ImageIcon("assets/heart.png");

       // red panel
        JPanel redPanel = panelList.get(0);
        redPanel.setLayout(new FlowLayout(FlowLayout.LEFT,4,5));
        redPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        JLabel hpLabel1 = new JLabel("Vidas:");
        hpLabel1.setForeground(Color.BLACK);
        hpLabel1.setFont(customFont);
        redPanel.add(hpLabel1);
        this.labels1 = new JLabel[3];
        for (int i = 0; i < labels1.length; i++) {
            labels1[i] = new JLabel();
            labels1[i].setIcon(imageIcon);
            redPanel.add(labels1[i]);
        }

        //blue panel

        JPanel bluePanel = panelList.get(12);
        bluePanel.setLayout(new FlowLayout(FlowLayout.LEFT,4,130));
        bluePanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        this.labels2 = new JLabel[3];
        JLabel hpLabel2 = new JLabel("Vidas:");
        hpLabel2.setForeground(Color.BLACK);
        hpLabel2.setVerticalAlignment(SwingConstants.BOTTOM);
        hpLabel2.setFont(customFont);
        bluePanel.add(hpLabel2);
        for (int i = 0; i < labels2.length; i++) {
            labels2[i] = new JLabel();
            labels2[i].setIcon(imageIcon);
            bluePanel.add(labels2[i]);
        }
    }

    public JLabel[] getVidasPlayerOneLabel() {
        return labels1;
    }

    public JLabel[] getVidasPlayerTwoLabel() {
        return labels2;
    }

    public void refresh() {
        this.revalidate();
        this.repaint();
    }


    private void initPanels() {
        for(int i=0; i < 15; i++) {
            JPanel panel = new JPanel();
            panel.setOpaque(true);
            panel.setBackground(new Color(0,0,0,0));
//            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panelList.add(panel);
        }
    }
}