package io.github.boogiemonster1o1.cpslegacy;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    JMenuBar mainBar = new JMenuBar();
    JMenu cpsMenu1 = new JMenu();
    JMenuItem closeItem = new JMenuItem();
    JLabel headingLabel = new JLabel("Clicks Per Second (Legacy edition)");

    public Main() throws Throwable{
        this.closeItem.setLabel("Close");
        this.closeItem.addActionListener(new CloseActionListener());
        this.cpsMenu1.setLabel("CPS");
        this.cpsMenu1.add(closeItem);
        this.mainBar.add(this.cpsMenu1);
        this.setJMenuBar(mainBar);
        this.setLayout(null);
        this.setDefaultCloseOperation(3);
        this.setSize(400,400);

        this.headingLabel.setFont(new Font("Arial", Font.BOLD,20));
        headingLabel.setBounds(10,10,350,25);
        this.add(headingLabel);

        this.setVisible(true);
    }
    public static void main(String[] args){
        System.out.println("Starting ClicksPerSecond Legacy...");
        try {
            new Main();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.exit(1);
        }
    }

    public JMenuBar getJMenuBar() {
        return this.mainBar;
    }
}
