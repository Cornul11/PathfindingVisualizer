package net.agspace.model.tiles;

import java.awt.*;

/**
 * @author Andrew Lalis
 * Tile which represents a starting point for pathfinding.
 */
public class StartTile extends PathTile {

    public static final Color COLOR = new Color(0, 192, 5);

    public StartTile(Point point){
        super(point);
    }

}
