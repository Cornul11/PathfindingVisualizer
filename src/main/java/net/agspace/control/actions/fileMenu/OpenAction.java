package net.agspace.control.actions.fileMenu;

import net.agspace.control.actions.ActionItem;
import net.agspace.model.PathMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Andrew Lalis
 */
public class OpenAction extends ActionItem {

    private PathMap map;

    public OpenAction(PathMap map){
        super("Open");
        this.map = map;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog((Component) e.getSource());
        if (result == JFileChooser.APPROVE_OPTION){
            this.map.load(fc.getSelectedFile().getPath());
        }
    }
}
