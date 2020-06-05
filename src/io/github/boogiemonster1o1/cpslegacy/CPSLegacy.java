package io.github.boogiemonster1o1.cpslegacy;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

@SuppressWarnings("all")
public class CPSLegacy extends JFrame {
    Font defaultFont;
    JMenuBar mainBar = new JMenuBar();
    JMenu cpsMenu1 = new JMenu("Program");
    JMenuItem closeItem = new JMenuItem("Close Program");
    JMenuItem sourceItem = new JMenuItem("Visit github page");
    JMenuItem issuesItem = new JMenuItem("Report bugs");
    JLabel headingLabel = new JLabel("Clicks Per Second (Legacy edition)", SwingConstants.CENTER);
    JButton keepClicking = new JButton("Keep Clicking");
    int clickCount = 0;
    int numSeconds = 1;
    int start = 0;

    private CPSLegacy(String lnf) throws Throwable {
        UIManager.setLookAndFeel(lnf);
        this.closeItem.addActionListener(new CloseActionListener());
        this.sourceItem.addActionListener(new GithubSourceActionListener());
        this.issuesItem.addActionListener(new GithubIssuesActionListener());
        this.cpsMenu1.add(sourceItem);
        this.cpsMenu1.add(issuesItem);
        this.cpsMenu1.addSeparator();
        this.cpsMenu1.add(closeItem);
        this.cpsMenu1.addSeparator();
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
            CPS = new CPSLegacy(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.exit(1);
        }
    }

    public static CPSLegacy CPS;

    public JMenuBar getJMenuBar() {
        return this.mainBar;
    }

    public void openBrowserWindow(String url){
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
