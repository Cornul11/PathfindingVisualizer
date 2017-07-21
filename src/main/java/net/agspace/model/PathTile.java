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
        return this.traversed;
    }

    /**
     * Sets this tile as a goal.
     */
    public void setGoal(boolean value){
        this.goal = value;
        if (value){
            this.start = false;
            this.traversed = false;
        }
    }

    /**
     * Sets this tile as a start location.
     */
    public void setStart(boolean value){
        this.start = value;
        if (value){
            this.goal = false;
            this.traversed = false;
        }
    }

    /**
     * Sets this tile as traversed.
     */
    public void setTraversed(boolean value){
        this.traversed = value;
    }

}
