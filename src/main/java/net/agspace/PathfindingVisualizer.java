package net.agspace;

import net.agspace.model.PathMap;
import net.agspace.model.tiles.GoalTile;
import net.agspace.model.tiles.ObstacleTile;
import net.agspace.model.tiles.StartTile;
import net.agspace.view.Window;

/**
 * @author Andrew Lalis
 * Main class for running the program.
 */
public class PathfindingVisualizer {

    public static void main(String[] args){

        PathMap map = new PathMap(40, 40);
        map.setTile(new StartTile(3, 3));
        map.setTile(new GoalTile(15, 15));
        map.setTile(new ObstacleTile(5, 8));
        map.save("C:/Users/AndrewComputer/Documents/out.txt");
        Window window = new Window(map);

    }

}
