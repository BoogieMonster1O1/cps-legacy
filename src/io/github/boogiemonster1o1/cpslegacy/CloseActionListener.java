package io.github.boogiemonster1o1.cpslegacy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class implements <code>ActionListener</code><br>
 * This class allows closing the program
 * @author Shrish Deshpande
 * @see java.awt.event.ActionListener
 */
public class CloseActionListener implements ActionListener {
    /**
     * Exits the program
     * @param e Unused
     */
    public void actionPerformed(ActionEvent e) {
        System.out.println("Exiting Program");
        System.exit(0);
    }
}
