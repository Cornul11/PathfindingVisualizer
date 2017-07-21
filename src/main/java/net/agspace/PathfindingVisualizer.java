package net.agspace;

import net.agspace.model.PathMap;
import net.agspace.view.Window;

/**
 * @author Andrew Lalis
 * Main class for running the program.
 */
public class PathfindingVisualizer {

    public static void main(String[] args){

        PathMap map = new PathMap(20, 20);
        Window window = new Window(map);

    }

}
