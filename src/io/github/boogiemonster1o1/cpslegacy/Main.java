package io.github.boogiemonster1o1.cpslegacy;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    Font defaultFont;
    JMenuBar mainBar = new JMenuBar();
    JMenu cpsMenu1 = new JMenu("Program");
    JMenuItem closeItem = new JMenuItem("Close Program");
    JMenuItem visitItem = new JMenuItem("Visit Website");
    JLabel headingLabel = new JLabel("Clicks Per Second (Legacy edition)",SwingConstants.CENTER);
    JButton keepClicking = new JButton("Keep Clicking");
    int clickCount = 0;
    int numSeconds = 1;
    int start = 0;

    public Main() throws Throwable{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        this.closeItem.addActionListener(new CloseActionListener());
        this.cpsMenu1.add(visitItem);
        this.cpsMenu1.add(closeItem);
        this.mainBar.add(this.cpsMenu1);
        this.setJMenuBar(mainBar);
        this.setLayout(null);
        this.setDefaultCloseOperation(3);
        this.setSize(400,400);

        this.defaultFont = this.closeItem.getFont();

        this.headingLabel.setFont(this.closeItem.getFont().deriveFont(Font.PLAIN).deriveFont(20.0f));
        this.headingLabel.setBounds(0,10,380,25);
        this.add(headingLabel);

        this.keepClicking.setFont(this.defaultFont.deriveFont(Font.BOLD).deriveFont(30.0f));
        this.keepClicking.setBounds(10,40,360,180);
        this.keepClicking.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(keepClicking);

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
