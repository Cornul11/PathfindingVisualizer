package net.agspace.control.actions.fileMenu;

import net.agspace.control.actions.ActionItem;
import net.agspace.model.PathMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * @author Andrew Lalis
 */
public class SaveAction extends ActionItem {

    private PathMap map;

    public SaveAction(PathMap map) {
        super("Save");
        this.map = map;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser();
        int result = fc.showSaveDialog((Component) e.getSource());
        if (result == JFileChooser.APPROVE_OPTION){
            File f = fc.getSelectedFile();
            this.map.save(f.getAbsolutePath());
        }
    }
}
