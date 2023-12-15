//import javax.swing.;
//import java.awt.;
//
//public class HealthBar extends JFrame {
//    private JProgressBar healthBar;
//
//    private int maxLife;
//    private int currentLife;
//
//    public HealthBar(int maxLife, Color color) {
//        super("Health Bar");
//
//        this.maxLife = maxLife; // Set the monster's maximum life
//        currentLife = maxLife; // Set the monster's current life
//
//        // Create the health bar
//        healthBar = new JProgressBar(0, maxLife);
//        healthBar.setValue(currentLife);
//        healthBar.setStringPainted(true);
//        healthBar.setForeground(color); // Red or Blue color to indicate monster's life
//
//        // Set the layout
//        setLayout(new BorderLayout());
//        add(healthBar, BorderLayout.CENTER);
//
//        // Configure the window
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(300, 120);
//        setLocationRelativeTo(null);
//        setVisible(true);
//    }
//
//    // Method to update the health bar and label with a new value
//    public void updateHealthBar(int newValue) {
//        currentLife = newValue;
//        healthBar.setValue(currentLife);
//    }