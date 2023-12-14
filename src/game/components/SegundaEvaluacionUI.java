package game.components;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SegundaEvaluacionUI extends JFrame {

    private List<JPanel> panelList = new ArrayList<>();

    private List<JLabel> buttons = new ArrayList<>();

    private JLabel label1;

    private JLabel label2;

    public SegundaEvaluacionUI init() {
        this.initPanels();
        this.addButtons();
        setContentPane(new BackgroundPanel());
        setTitle("Segunda Evaluacion");
        setSize(600, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout gridLayout = new GridLayout(12,3);
        panelList.forEach(SegundaEvaluacionUI.this::add);

        setLayout(gridLayout);
        setLocationRelativeTo(null);
        return this;
    }

    public JLabel getButton(int index) {
        return buttons.get(index);
    }

    private void addButtons() {

        //SETEO DE BOTONES/JLABEL

        JLabel button15 = new JLabel();
        panelList.get(6).setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelList.get(6).add(button15);
        button15.setVisible(false);
        buttons.add(button15);

        JLabel button17 = new JLabel();
        panelList.get(8).setLayout(new FlowLayout(FlowLayout.LEFT));
        panelList.get(8).add(button17);
        button17.setVisible(false);
        buttons.add(button17);

        JLabel button27 = new JLabel();
        panelList.get(12).setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelList.get(12).add(button27);
        button27.setVisible(false);
        buttons.add(button27);

        JLabel button29 = new JLabel();
        panelList.get(14).setLayout(new FlowLayout(FlowLayout.LEFT));
        panelList.get(14).add(button29);
        button29.setVisible(false);
        buttons.add(button29);

        JLabel button39 = new JLabel();
        panelList.get(18).setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelList.get(18).add(button39);
        button39.setVisible(false);
        buttons.add(button39);

        JLabel button41 = new JLabel();
        panelList.get(20).setLayout(new FlowLayout(FlowLayout.LEFT));
        panelList.get(20).add(button41);
        button41.setVisible(false);
        buttons.add(button41);


        //SETEO DE VIDAS

        label1 = new JLabel();
        label1.setText("Vidas: 3");
        label1.setForeground(Color.RED);
        label1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        panelList.get(0).setLayout(new FlowLayout(FlowLayout.LEFT));
        panelList.get(0).add(label1);

        label2 = new JLabel();
        label2.setText("Vidas: 3");
        label2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        label2.setForeground(Color.BLUE);
        panelList.get(33).setLayout(new FlowLayout(FlowLayout.LEFT));
        panelList.get(33).add(label2);
    }

    public JLabel getVidasPlayerOneLabel() {
        return label1;
    }

    public JLabel getVidasPlayerTwoLabel() {
        return label2;
    }

    public void refresh() {
        this.revalidate();
        this.repaint();
    }

    private void initPanels() {
        for(int i=0; i < 36; i++) {
            JPanel panel = new JPanel();
            panel.setOpaque(true);
            panel.setBackground(new Color(0,0,0,0));
            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panelList.add(panel);
        }
    }

    public void showResultMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }
}