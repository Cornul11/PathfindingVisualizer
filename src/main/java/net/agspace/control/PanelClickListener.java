package net.agspace.control;

import net.agspace.model.PathMap;
import net.agspace.model.tiles.GoalTile;
import net.agspace.model.tiles.ObstacleTile;
import net.agspace.model.tiles.PathTile;
import net.agspace.model.tiles.StartTile;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static net.agspace.view.MapPanel.BORDER_SIZE;
import static net.agspace.view.MapPanel.TILE_SIZE;

/**
 * @author Andrew Lalis
 */
public class PanelClickListener implements MouseListener {

    private PathMap map;

    public PanelClickListener(PathMap map){
        this.map = map;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int tileX = e.getX()/(TILE_SIZE+BORDER_SIZE);
        int tileY = e.getY()/(TILE_SIZE+BORDER_SIZE);
        if (tileX < map.getWidth() && tileY < map.getHeight()) {
            PathTile tile = map.getTile(tileX, tileY);
            switch (e.getButton()) {
                case 2:
                    if (map.getTile(tileX, tileY) instanceof  GoalTile){
                        map.setTile(new PathTile(tileX, tileY));
                    } else {
                        map.setTile(new GoalTile(tileX, tileY));
                    }
                    break;
                case 1:
                    if (map.getTile(tileX, tileY) instanceof ObstacleTile){
                        map.setTile(new PathTile(tileX, tileY));
                    } else {
                        map.setTile(new ObstacleTile(tileX, tileY));
                    }
                    break;
                case 3:
                    if (map.getTile(tileX, tileY) instanceof  StartTile){
                        map.setTile(new PathTile(tileX, tileY));
                    } else {
                        map.setTile(new StartTile(tileX, tileY));
                    }
                    break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
