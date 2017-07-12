package net.agspace.model;

/**
 * @author Andrew Lalis
 * Class to represent one unit on a map.
 */
public class PathTile {

    //Is this tile a goal?
    boolean goal;
    //Is this tile a start location?
    boolean start;
    //Has this tile already been traversed?
    boolean traversed;

    public PathTile(boolean isStart, boolean isGoal, boolean traversed){
        this.start = isStart;
        this.goal = isGoal;
        this.traversed = traversed;
    }

    public boolean isGoal(){
        return this.goal;
    }

    public boolean isStart(){
        return this.start;
    }

    public boolean isTraversed(){
        return this.isTraversed();
    }

}
