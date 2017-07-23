package net.agspace.model.tiles;

import java.awt.*;

/**
 * @author Andrew Lalis
 * Tile which cannot be traversed by a pathfinding algorithm.
 */
public class ObstacleTile extends PathTile {

    public static final Color COLOR = new Color(103, 103, 103);

    public ObstacleTile(Point point){
        super(point);
    }

}
