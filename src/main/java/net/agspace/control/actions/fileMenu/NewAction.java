package net.agspace.control.actions.fileMenu;

import net.agspace.control.actions.ActionItem;
import net.agspace.model.PathMap;

import java.awt.event.ActionEvent;

/**
 * @author Andrew Lalis
 */
public class NewAction extends ActionItem {

    private PathMap map;

    public NewAction(PathMap map){
        super("New");
        this.map = map;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.map.clear();
        this.map.manualNotify();
    }
}
