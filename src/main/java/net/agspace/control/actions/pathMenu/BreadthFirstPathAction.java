package net.agspace.control.actions.pathMenu;

import net.agspace.control.actions.ActionItem;
import net.agspace.model.PathMap;
import net.agspace.pathfinding.BreadthFirstPathfinding;
import net.agspace.pathfinding.Pathfinding;

import java.awt.event.ActionEvent;

/**
 * @author Andrew Lalis
 * Menu Item and action for a Breadth first search.
 */
public class BreadthFirstPathAction extends ActionItem {

    private BreadthFirstPathfinding bfs;

    public BreadthFirstPathAction(PathMap map){
        super("Breadth First");
        this.bfs = new BreadthFirstPathfinding(map, Pathfinding.FIRST_SOLUTION);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Thread(this.bfs).start();
    }

}
