package io.github.boogiemonster1o1.cpslegacy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CloseActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println("Exiting Program");
        System.exit(0);
    }
}
