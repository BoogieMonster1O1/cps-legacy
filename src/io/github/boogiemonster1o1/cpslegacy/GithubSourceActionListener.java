package io.github.boogiemonster1o1.cpslegacy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class implements <code>ActionListener</code><br>
 * This class opens this program's source on Github
 * @author Shrish Deshpande
 * @see java.awt.event.ActionListener
 */
public class GithubSourceActionListener implements ActionListener {
    /**
     * Opens the source code on Github
     * @param actionEvent Unused
     */
    public void actionPerformed(ActionEvent actionEvent) {
        CPSLegacy.CPS.openBrowserWindow("https://github.com/BoogieMonster1O1/cps-legacy");
    }
}
