package net.agspace.model;

/**
 * @author Andrew Lalis
 * Class to represent an entire map object, which contains a two-dimensional array of tiles, and some other
 * meta-data.
 */
public class PathMap {

    //2-D map of all the tiles of the map.
    PathTile[][] tileMap;

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

}
