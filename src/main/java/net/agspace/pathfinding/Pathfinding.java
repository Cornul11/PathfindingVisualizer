package net.agspace.pathfinding;

import net.agspace.model.PathMap;
import net.agspace.model.tiles.GoalTile;
import net.agspace.model.tiles.StartTile;


/**
 * @author Andrew Lalis
 * Base class for all pathfinding algorithms.
 * Each algorithm which is a subclass of Pathfinding will need to implement the method {@code step}.
 * Each algorithm signals that it is done by setting the {@code finished} flag to true.
 * Some algorithms use separate data structures, so it is not feasible to keep them here, but instead
 * each algorithm creates its own containers and lists.
 */
public abstract class Pathfinding implements Runnable {

    //Millisecond delay for pathfinding algorithm visual.
    public static final int UPDATE_DELAY = 25;

    //Constants for possible solutions.
    public static final int FIRST_SOLUTION = 1;
    public static final int ALL_SOLUTIONS = 2;

    //Map object to store data.
    protected PathMap map;
    //List of goal points.
    protected GoalTile[] goalPoints;
    //List of start points.
    protected StartTile[] startPoints;
    //Integer corresponding to constants for solution strategies.
    protected int solutionStrategy;
    //Flag to determine if the solution has been found.
    protected boolean finished = false;

    public Pathfinding(PathMap map, int solvingStrategy){
        this.map = map;
        this.solutionStrategy = solvingStrategy;
    }

    @Override
    public void run() {
        //Read start locations from the map.
        this.startPoints = map.getStartPoints();
        this.goalPoints = map.getGoalPoints();
        init();
        //Keep looping until the algorithm sets the finished flag.
        while (!finished) {
            step();
            this.map.manualNotify();
            try {
                Thread.sleep(UPDATE_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method for each individual algorithm to do their computations.
     */
    protected abstract void step();

    /**
     * Method to add initial points to the pathfinding before entering loop.
     */
    protected abstract void init();

}
