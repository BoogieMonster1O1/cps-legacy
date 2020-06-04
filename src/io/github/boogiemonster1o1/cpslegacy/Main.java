package io.github.boogiemonster1o1.cpslegacy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

public class Main extends JFrame {

    JRootPane rootPane = new JRootPane();
    JMenuBar mainBar = new JMenuBar();
    JMenu cpsMenu1 = new JMenu();
    JMenuItem closeItem = new JMenuItem();

    public Main(){
        this.closeItem.setLabel("Close");
        this.closeItem.addActionListener(new CloseActionListener());
        this.cpsMenu1.setLabel("CPS");
        this.cpsMenu1.add(closeItem);
        this.mainBar.add(this.cpsMenu1);
        this.setJMenuBar(mainBar);
        this.setLayout(null);
        this.setDefaultCloseOperation(3);
        this.setRootPane(rootPane);
        this.setSize(400,400);
        this.setVisible(true);
    }
    public static void main(String[] args){
        System.out.println("Starting ClicksPerSecond Legacy...");
        new Main();
    }

    public JMenuBar getJMenuBar() {
        return this.mainBar;
    }

    public JRootPane getRootPane(){
        return this.rootPane;
    }
}
