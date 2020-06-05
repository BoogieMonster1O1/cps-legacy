package io.github.boogiemonster1o1.cpslegacy;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Font defaultFont;
    public JMenuBar mainBar = new JMenuBar();
    public JMenu cpsMenu1 = new JMenu("Program");
    public JMenuItem closeItem = new JMenuItem("Close Program");
    public JMenuItem visitItem = new JMenuItem("View on Github");
    public JMenuItem issueItem = new JMenuItem("Report issues");
    public JLabel headingLabel = new JLabel("Clicks Per Second (Legacy edition)", SwingConstants.CENTER);
    public JButton keepClicking = new JButton("Keep Clicking");
    public int clickCount = 0;
    public int numSeconds = 1;
    public int start = 0;

    public Main() throws Throwable {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        this.closeItem.addActionListener(new CloseActionListener());
        this.visitItem.addActionListener(new VisitSourceActionListener());
        this.issueItem.addActionListener(new VisitIssuesActionListener());
        this.cpsMenu1.add(visitItem);
        this.cpsMenu1.add(issueItem);
        this.cpsMenu1.addSeparator();
        this.cpsMenu1.add(closeItem);
        this.mainBar.add(this.cpsMenu1);
        this.setJMenuBar(mainBar);
        this.setLayout(null);
        this.setDefaultCloseOperation(3);
        this.setSize(400, 400);

        this.defaultFont = this.closeItem.getFont();

        this.headingLabel.setFont(this.closeItem.getFont().deriveFont(Font.PLAIN).deriveFont(20.0f));
        this.headingLabel.setBounds(0, 10, 380, 25);
        this.add(headingLabel);

        this.keepClicking.setFont(this.defaultFont.deriveFont(Font.BOLD).deriveFont(30.0f));
        this.keepClicking.setBounds(10, 40, 360, 180);
        this.keepClicking.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(keepClicking);

        this.setVisible(true);
    }


    public static void main(String[] args) {
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
