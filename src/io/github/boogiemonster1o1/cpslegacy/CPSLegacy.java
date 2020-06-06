package io.github.boogiemonster1o1.cpslegacy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * This is the main class. The Swing window is opened by this class' constructor. This class also handles opening browser windows. <br>
 * The JFrame class is extended as its much easier than making an object of the class.
 * @see javax.swing.JFrame
 * @author Shrish Deshpande
 */
public class CPSLegacy extends JFrame {

    /**
     * Stores the default font provided by the System Look and Feel
     */
    private Font defaultFont;

    /**
     * Creates a JMenuBar which currently allows you to visit this program's source, report issues and close the program
     */
    private JMenuBar mainBar = new JMenuBar();

    /**
     * Creates a JMenu which stores the three menu Items
     */
    private JMenu cpsMenu1 = new JMenu("Program");

    /**
     * Menu Item thaat allows you to close the program
     */
    private JMenuItem closeItem = new JMenuItem("Close Program");

    /**
     * Menu Item that allows you to visit the github page
     */
    private JMenuItem sourceItem = new JMenuItem("Visit github page");

    /**
     * Menu Item that allows you to report bugs in the github issue tracker
     */
    private JMenuItem issuesItem = new JMenuItem("Report bugs");

    /**
     * Stores the heading of the JFrame (not the program)
     */
    private JLabel headingLabel = new JLabel("Clicks Per Second (Legacy edition)", SwingConstants.CENTER);

    /**
     * The Button which the user must keep clicking on!
     */
    private JButton keepClicking = new JButton("Keep Clicking");

    /**
     * Stores the value of the Click speed
     */
    private JLabel clickSpeed = new JLabel("CPS: 0",SwingConstants.CENTER);

    /**
     * Stores the total number of clicks on the JButton <code>keepClicking</code>
     */
    private JLabel clicks = new JLabel("Clicks: 0",SwingConstants.CENTER);

    /**
     * Stores the click speed
     */
    private int clickCount = 0;

    /**
     * Stores the amount(in seconds) that click speed must be calculated for. Default is 1
     */
    private int numSeconds = 1;

    /**
     * Stores the total number of clicks
     */
    private int start = 0;

    /**
     * This is the main constructor, which sets up the Swing Window and opens it
     * @param lnf Stores the Look and Feel provided the the main method
     * @throws Throwable Setting the look and feel throws an exception if it fails, so adding it in the method signature is best
     */
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


    /**
     * This is the main method
     * @param args Allows the method to be run
     */
    public static void main(String[] args) {
        System.out.println("Starting ClicksPerSecond Legacy...");
        try {
            CPS = new CPSLegacy(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Object which allows other classes to access these methods. This is also the object which opens the swing window.
     */
    static CPSLegacy CPS;

    /**
     * This is the method that calculates the user's click speed in real time. It does this by creating a thread which sleeps after a number of seconds of inactivity(in this case, 1).
     * The number of seconds decide the time period for which the click speed is calculated.
     */
    private void loopGetClicks(){
        System.out.println("Looped");
        new Thread() {
            /**
             * Calculates the click speed
             */
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

    /**
     * Overriden method
     * @return Returns the menu bar <code>mainBar</code>
     */
    public JMenuBar getJMenuBar() {
        return this.mainBar;
    }

    /**
     * Sets the JFrame as non-resizable
     * @param resizable Unused
     */
    public void setResizable(boolean resizable) {
        super.setResizable(false);
    }

    /**
     * Modifies the text
     * @param val The total number of clicks
     * @return Returns a String that contains <code>val</code>
     */
    private String modifyClicks(int val){
        return "Clicks: " + val;
    }

    /**
     * Modifies the text
     * @param val The click speed
     * @return Returns a String that contains <code>val</code>
     */
    private String modifyClickSpeed(int val){
        return "CPS: " + val;
    }

    /**
     * This method allows opening browser windows. Since <code>Desktop</code> isn't present in J2SE 1.2, the only way to open browser windows is by running a command on the command line that opens it.
     * Currently, this supports Mac OS, Linux and Windows. Throws a <code>RuntimeException</code> if the operating system could not be defined.
     * This is the only native-like code in the entire program
     * @param url The URL that needs to open
     */
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
