package net.agspace.model;

import net.agspace.model.tiles.GoalTile;
import net.agspace.model.tiles.PathTile;
import net.agspace.model.tiles.StartTile;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * @author Andrew Lalis
 * Class to represent an entire map object, which contains a two-dimensional array of tiles, and some other
 * meta-data.
 */
public class PathMap extends Observable {

    //2-D map of all the tiles of the map.
    private PathTile[][] tileMap;

    public PathMap(int width, int height){
        tileMap = new PathTile[width][height];
        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                tileMap[x][y] = new PathTile(new Point(x,y));
            }
        }
    }

    /**
     * Gets the path tile at a specific coordinate.
     * @param x The x-coordinate of the tile.
     * @param y The y-coordinate of the tile.
     * @return The tile that exists at these coordinates, or an exception if the coordinates are out of bounds.
     */
    public PathTile getTile(int x, int y){
        return this.tileMap[x][y];
    }

    /**
     * Gets the path tile at a specific coordinate.
     * @param p The Point of the tile.
     * @return The tile that exists at this coordinates.
     */
    public PathTile getTile(Point p){
        return this.tileMap[p.x][p.y];
    }

    /**
     * Returns the width of the map: the number of tiles on the x-axis.
     * @return Integer value depicting number of tiles on the x-axis.
     */
    public int getWidth(){
        return this.tileMap.length;
    }

    /**
     * Returns the height of the map.
     * @return Integer value depicting the number of tiles on the y-axis.
     */
    public int getHeight(){
        return this.tileMap[0].length;
    }

    /**
     * Sets a tile as a goal.
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @param value True if a goal, false otherwise.
     */
    public void setGoal(int x, int y, boolean value){
        if (value){
            tileMap[x][y] = new GoalTile(new Point(x,y));
        } else {
            tileMap[x][y] = new PathTile(new Point(x,y));
        }
        this.manualNotify();
    }

    /**
     * Sets a tile as a start.
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @param value True if a start, false otherwise.
     */
    public void setStart(int x, int y, boolean value){
        if (value){
            tileMap[x][y] = new StartTile(new Point(x,y));
        } else {
            tileMap[x][y] = new PathTile(new Point(x,y));
        }
        this.manualNotify();
    }

    /**
     * Sets a tile as traversed.
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @param value Set as either true or false.
     */
    public void setTraversed(int x, int y, boolean value){
        tileMap[x][y].setTraversed(value);
        this.manualNotify();
    }

    public void manualNotify(){
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Gets a list of starting points in a map. These are locations that a pathfinding algorithm should start from.
     * @return An array of Points.
     */
    public StartTile[] getStartPoints(){
        List<StartTile> points = new ArrayList<>();
        for (int x = 0; x < this.getWidth(); x++){
            for (int y = 0; y < this.getHeight(); y++){
                if (this.tileMap[x][y] instanceof StartTile){
                    points.add((StartTile)this.tileMap[x][y]);
                }
            }
        }
        StartTile[] pointsArray = new StartTile[points.size()];
        points.toArray(pointsArray);
        return pointsArray;
    }

    /**
     * Gets a list of goal points in a map. These are locations that a pathfinding algorithm should go to.
     * @return An array of Points.
     */
    public GoalTile[] getGoalPoints(){
        List<GoalTile> points = new ArrayList<>();
        for (int x = 0; x < this.getWidth(); x++){
            for (int y = 0; y < this.getHeight(); y++){
                if (this.tileMap[x][y] instanceof GoalTile){
                    points.add((GoalTile)this.tileMap[x][y]);
                }
            }
        }
        GoalTile[] pointsArray = new GoalTile[points.size()];
        points.toArray(pointsArray);
        return pointsArray;
    }

    /**
     * Determines if a point is valid for this map, so that there are no out of bounds errors.
     * @param p The point.
     * @return True if it is safe to index this point.
     */
    boolean isValidPoint(Point p){
        return (p.x >= 0 && p.x < this.getWidth() && p.y >= 0 && p.y < this.getHeight());
    }

    /**
     * Gets a list of tiles adjacent to this tile. That is, up, down, left, and right of this tile.
     * @param originTile The tile to get adjacent tiles to.
     * @return A list of path tiles adjacent to a given tile.
     */
    public List<PathTile> getAdjacentTiles(PathTile originTile){
        List<PathTile> tiles = new ArrayList<>();
        Point originPoint = originTile.getPoint();
        Point up = new Point(originPoint);
        up.translate(0, -1);
        if (isValidPoint(up))
            tiles.add(this.getTile(up));
        Point right = new Point(originPoint);
        right.translate(1, 0);
        if (isValidPoint(right))
            tiles.add(this.getTile(right));
        Point down = new Point(originPoint);
        down.translate(0, 1);
        if (isValidPoint(down))
            tiles.add(this.getTile(down));
        Point left = new Point(originPoint);
        left.translate(-1, 0);
        if (isValidPoint(left))
            tiles.add(this.getTile(left));
        return tiles;
    }

}
