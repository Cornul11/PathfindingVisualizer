package net.agspace.control.actions.pathMenu;

import net.agspace.control.actions.ActionItem;
import net.agspace.model.PathMap;
import net.agspace.pathfinding.DepthFirstPathfinding;
import net.agspace.pathfinding.Pathfinding;

import java.awt.event.ActionEvent;

/**
 * @author Andrew Lalis
 * Menu Item and action for depth first search.
 */
public class DepthFirstPathAction extends ActionItem {

    private DepthFirstPathfinding dfs;

    public DepthFirstPathAction(PathMap map){
        super("Depth First");
        this.dfs = new DepthFirstPathfinding(map, Pathfinding.FIRST_SOLUTION);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Thread(this.dfs).start();
    }
}
