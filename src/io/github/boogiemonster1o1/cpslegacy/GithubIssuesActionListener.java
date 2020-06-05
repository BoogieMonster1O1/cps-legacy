package io.github.boogiemonster1o1.cpslegacy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GithubIssuesActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        CPSLegacy.CPS.openBrowserWindow("https://github.com/BoogieMonster1O1/cps-legacy/issues");
    }
}
