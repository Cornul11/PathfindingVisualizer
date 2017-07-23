package net.agspace;

import net.agspace.model.PathMap;
import net.agspace.view.Window;

/**
 * @author Andrew Lalis
 * Main class for running the program.
 */
public class PathfindingVisualizer {

    public static void main(String[] args){

        PathMap map = new PathMap(40, 40);
        map.setStart(6, 8, true);
        map.setGoal(15, 15, true);
        Window window = new Window(map);

    }

}
