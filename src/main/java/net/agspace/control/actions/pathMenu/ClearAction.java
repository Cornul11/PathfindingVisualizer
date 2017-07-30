package net.agspace.control.actions.pathMenu;

import net.agspace.control.actions.ActionItem;
import net.agspace.model.PathMap;

import java.awt.event.ActionEvent;

/**
 * @author Andrew Lalis
 */
public class ClearAction extends ActionItem {

    private PathMap map;

    public ClearAction(PathMap map) {
        super("Clear");
        this.map = map;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.map.clearPaths();
    }
}
