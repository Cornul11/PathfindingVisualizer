package net.agspace.model.tiles;

import java.awt.*;

/**
 * @author Andrew Lalis
 * Tile which represents and endpoint of pathfinding.
 */
public class GoalTile extends PathTile {

    public static final Color COLOR = new Color(255, 144, 0);

    public GoalTile(Point point){
        super(point);
    }

}
