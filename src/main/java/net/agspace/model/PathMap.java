package net.agspace.model;

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
                tileMap[x][y] = new PathTile(false, false, false);
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

    public void setGoal(int x, int y, boolean value){
        tileMap[x][y].setGoal(value);
        this.manualNotify();
    }

    public void setStart(int x, int y, boolean value){
        tileMap[x][y].setStart(value);
        this.manualNotify();
    }

    public void setTraversed(int x, int y, boolean value){
        tileMap[x][y].setTraversed(value);
        this.manualNotify();
    }

    public void manualNotify(){
        this.setChanged();
        this.notifyObservers();
    }

}
