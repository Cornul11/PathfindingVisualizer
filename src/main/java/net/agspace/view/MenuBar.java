package net.agspace.view;

import net.agspace.control.actions.fileMenu.ExitAction;
import net.agspace.control.actions.fileMenu.NewAction;
import net.agspace.control.actions.fileMenu.OpenAction;
import net.agspace.control.actions.fileMenu.SaveAction;
import net.agspace.control.actions.pathMenu.AStarPathAction;
import net.agspace.control.actions.pathMenu.BreadthFirstPathAction;
import net.agspace.control.actions.pathMenu.ClearAction;
import net.agspace.control.actions.pathMenu.DepthFirstPathAction;
import net.agspace.model.PathMap;

import javax.swing.*;

/**
 * @author Andrew Lalis
 */
public class MenuBar extends JMenuBar {

    public MenuBar(PathMap map, Window window){
        //File Menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(new NewAction(map));
        fileMenu.add(new SaveAction(map));
        fileMenu.add(new OpenAction(map));
        fileMenu.add(new ExitAction());
        this.add(fileMenu);
        //Path Menu
        JMenu pathMenu = new JMenu("Path");
        pathMenu.add(new BreadthFirstPathAction(map));
        pathMenu.add(new DepthFirstPathAction(map));
        pathMenu.add(new AStarPathAction(map));
        pathMenu.add(new ClearAction(map));
        this.add(pathMenu);
    }

}
