package io.github.boogiemonster1o1.cpslegacy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CPSLegacy extends JFrame {
    private Font defaultFont;
    private JMenuBar mainBar = new JMenuBar();
    private JMenu cpsMenu1 = new JMenu("Program");
    private JMenuItem closeItem = new JMenuItem("Close Program");
    private JMenuItem sourceItem = new JMenuItem("Visit github page");
    private JMenuItem issuesItem = new JMenuItem("Report bugs");
    private JLabel headingLabel = new JLabel("Clicks Per Second (Legacy edition)", SwingConstants.CENTER);
    private JButton keepClicking = new JButton("Keep Clicking");
    private JLabel clickSpeed = new JLabel("CPS: 0",SwingConstants.CENTER);
    private JLabel clicks = new JLabel("Clicks: 0",SwingConstants.CENTER);
    private int clickCount = 0;
    private int numSeconds = 1;
    private int start = 0;

    private CPSLegacy(String lnf) throws Throwable {
        UIManager.setLookAndFeel(lnf);
        this.closeItem.addActionListener(new CloseActionListener());
        this.sourceItem.addActionListener(new GithubSourceActionListener());
        this.issuesItem.addActionListener(new GithubIssuesActionListener());
        this.cpsMenu1.add(this.sourceItem);
        this.cpsMenu1.add(this.issuesItem);
        this.cpsMenu1.addSeparator();
        this.cpsMenu1.add(this.closeItem);
        this.mainBar.add(this.cpsMenu1);
        this.setJMenuBar(mainBar);
        this.setLayout(null);
        this.setDefaultCloseOperation(3);
        this.setSize(400, 400);

        this.defaultFont = this.closeItem.getFont();

        this.headingLabel.setFont(this.closeItem.getFont().deriveFont(Font.PLAIN).deriveFont(20.0f));
        this.headingLabel.setBounds(0, 10, 380, 25);
        this.add(this.headingLabel);

        this.clickSpeed.setFont(this.defaultFont.deriveFont(Font.PLAIN).deriveFont(24.0f));
        this.clickSpeed.setBounds(10,240,360,30);
        this.add(this.clickSpeed);

        this.clicks.setFont(this.defaultFont.deriveFont(Font.PLAIN).deriveFont(24.0f));
        this.clicks.setBounds(10,280,360,30);
        this.add(this.clicks);

        this.keepClicking.setFont(this.defaultFont.deriveFont(Font.BOLD).deriveFont(30.0f));
        this.keepClicking.setBounds(10, 40, 360, 180);
        this.keepClicking.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(this.keepClicking);
        this.keepClicking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                clickCount++;
                start++;
                clicks.setText(modifyClicks(start));
                System.out.println("Clicked!");
            }
        });

        this.setVisible(true);

        this.loopGetClicks();

    }


    public static void main(String[] args) {
        System.out.println("Starting ClicksPerSecond Legacy...");
        try {
            CPS = new CPSLegacy(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.exit(1);
        }
    }

    static CPSLegacy CPS;

    private void loopGetClicks(){
        System.out.println("Looped");
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(numSeconds * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clickSpeed.setText(modifyClickSpeed(clickCount));
                clickCount = 0;
                loopGetClicks();
            }
        }.start();
    }

    public JMenuBar getJMenuBar() {
        return this.mainBar;
    }

    public void setResizable(boolean resizable) {
        super.setResizable(false);
    }

    private String modifyClicks(int val){
        return "Clicks: " + val;
    }
    private String modifyClickSpeed(int val){
        return "CPS: " + val;
    }

    void openBrowserWindow(String url){
        Runtime rt = Runtime.getRuntime();
        String os = System.getProperty("os.name").toLowerCase();
        try{
            if(os.indexOf("win") >= 0){
                rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
            }
            else if(os.indexOf("mac") >= 0){
                rt.exec("open " + url);
            }
            else if(os.indexOf("nix") >=0 || os.indexOf("nux") >=0){
                rt.exec("xdg-open " + url);
            }
            else{
                throw new RuntimeException("Your operating system could not be detected");
            }
        }catch(IOException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}
