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
        GridLayout gridLayout = new GridLayout(10,3);
        panelList.forEach(SegundaEvaluacionUI.this::add);

        setLayout(gridLayout);
        setLocationRelativeTo(null);
        return this;
    }

   //retorna el boton de la lista DE BOTONES, no de paneles
    public JLabel getButton(int index) {
        return buttons.get(index);
    }

    /*
     Inicializa los espacios para las imagenes de los monsturos en el tablero
    * */
    private void addButtons() {


        JLabel button6 = new JLabel();
        panelList.get(6).setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelList.get(6).add(button6);
        button6.setVisible(false);
        buttons.add(button6);
//        button6.setHorizontalAlignment(SwingConstants.RIGHT);
//        button6.setAlignmentX(Component.RIGHT_ALIGNMENT);

//        JProgressBar healthBar = new JProgressBar(0, 500);
//        healthBar.setValue(200);
//        healthBar.setPreferredSize(new Dimension(80, 9));
//        healthBar.setMaximumSize(new Dimension(80, 9));
//        healthBar.setAlignmentX(Component.RIGHT_ALIGNMENT);
//        healthBar.setStringPainted(true);
//        healthBar.setForeground(Color.RED);
//        panelList.get(6).add(healthBar);
       //

        JLabel button8 = new JLabel();
        panelList.get(8).setLayout(new FlowLayout(FlowLayout.LEFT));
        panelList.get(8).add(button8);
        button8.setVisible(false);
        buttons.add(button8);

        JLabel button12 = new JLabel();
        panelList.get(12).setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelList.get(12).add(button12);
        button12.setVisible(false);
        buttons.add(button12);

        JLabel button14 = new JLabel();
        panelList.get(14).setLayout(new FlowLayout(FlowLayout.LEFT));
        panelList.get(14).add(button14);
        button14.setVisible(false);
        buttons.add(button14);

        JLabel button18 = new JLabel();
        panelList.get(18).setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelList.get(18).add(button18);
        button18.setVisible(false);
        buttons.add(button18);

        JLabel button20 = new JLabel();
        panelList.get(20).setLayout(new FlowLayout(FlowLayout.LEFT));
        panelList.get(20).add(button20);
        button20.setVisible(false);
        buttons.add(button20);

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
        JPanel redPanel = panelList.get(0);
        redPanel.setLayout(new FlowLayout(FlowLayout.LEFT,4,5));
        JLabel hpLabel1 = new JLabel("Vidas:");
        hpLabel1.setFont(customFont);
        redPanel.add(hpLabel1);
        this.labels1 = new JLabel[3];
        for (int i = 0; i < labels1.length; i++) {
            labels1[i] = new JLabel();
            labels1[i].setIcon(imageIcon);
            redPanel.add(labels1[i]);
        }

        JPanel bluePanel = panelList.get(27);
        bluePanel.setLayout(new FlowLayout(FlowLayout.LEFT,4,50));
        this.labels2 = new JLabel[3];
        JLabel hpLabel2 = new JLabel("Vidas:");
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
        for(int i=0; i < 30; i++) {
            JPanel panel = new JPanel();
            panel.setOpaque(true);
            panel.setBackground(new Color(0,0,0,0));
//            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panelList.add(panel);
        }
    }
}