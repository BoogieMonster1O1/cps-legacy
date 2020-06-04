package io.github.boogiemonster1o1.cpslegacy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

public class CloseActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        exit(0);
    }
}
