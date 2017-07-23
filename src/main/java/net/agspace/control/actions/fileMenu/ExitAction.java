package net.agspace.control.actions.fileMenu;

import net.agspace.control.actions.ActionItem;

import java.awt.event.ActionEvent;

/**
 * @author Andrew Lalis
 * Action to exit the program.
 */
public class ExitAction extends ActionItem {

    public ExitAction(){
        super("Exit");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
