package io.github.boogiemonster1o1.cpslegacy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

public class VisitSourceActionListener implements ActionListener {
    public void actionPerformed(ActionEvent actionEvent) {
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.browse(new URI("https://github.com/BoogieMonster1O1/cps-legacy"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
