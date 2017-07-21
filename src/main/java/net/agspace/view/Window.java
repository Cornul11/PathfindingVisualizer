package net.agspace.view;

import net.agspace.model.PathMap;

import javax.swing.*;

/**
 * @author Andrew Lalis
 */
public class Window extends JFrame {

    private MapPanel mapPanel;

    public Window(PathMap pathMap){
        this.mapPanel = new MapPanel(pathMap);
        initFrame();
    }

    private void initFrame(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(this.mapPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setEnabled(true);
    }

}
