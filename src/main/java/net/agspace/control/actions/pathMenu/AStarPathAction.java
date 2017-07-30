package net.agspace.control.actions.pathMenu;

import net.agspace.control.actions.ActionItem;
import net.agspace.model.PathMap;
import net.agspace.pathfinding.AStarPathfinding;
import net.agspace.pathfinding.Pathfinding;

import java.awt.event.ActionEvent;

/**
 * @author Andrew Lalis
 * Menu Item and action for A-Star pathfinding.
 */
public class AStarPathAction extends ActionItem {

    private AStarPathfinding aStar;

    public AStarPathAction(PathMap map){
        super("A-Star");
        this.aStar = new AStarPathfinding(map, Pathfinding.FIRST_SOLUTION);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Thread(this.aStar).start();
    }
}
