package io.github.boogiemonster1o1.cpslegacy;

import javax.swing.*;

public class Main extends JFrame {

    JMenuBar mainMenu = new JMenuBar();
    JRootPane rootPane = new JRootPane();
    JLabel headingLabel = new JLabel();
    JMenu cpsMenu1 = new JMenu();
    JMenuItem closeItem = new JMenuItem();

    public Main(){
        this.setJMenuBar(mainMenu);
        this.setLayout(null);
        this.setDefaultCloseOperation(3);
        this.setRootPane(rootPane);
        this.setSize(256,256);
        this.closeItem.setToolTipText("Close");
        this.mainMenu.add(this.cpsMenu1);
        this.cpsMenu1.add(closeItem);
        this.setVisible(true);
    }
    public static void main(String[] args){
        System.out.println("Starting ClicksPerSecond Legacy...");
        new Main();
    }

    public JMenuBar getJMenuBar() {
        return this.mainMenu;
    }

    public JRootPane getRootPane(){
        return this.rootPane;
    }
}
