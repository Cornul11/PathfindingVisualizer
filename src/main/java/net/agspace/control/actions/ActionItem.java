package net.agspace.control.actions;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author Andrew Lalis
 * Template for creation of menu items with corresponding actions.
 */
public abstract class ActionItem extends JMenuItem implements ActionListener {

    public ActionItem(String displayString){
        super(displayString);
        this.addActionListener(this);
    }

}
