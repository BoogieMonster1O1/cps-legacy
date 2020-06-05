package io.github.boogiemonster1o1.cpslegacy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

public class VisitIssuesActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.browse(new URI("https://github.com/BoogieMonster1O1/cps-legacy/issues"));
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
