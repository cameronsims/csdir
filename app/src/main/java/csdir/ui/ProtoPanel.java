/**
 * @author Cameron Sims
 * @version 1.0
 * @date 15/02/2024
 * @purpose A side of the program
 *
 */
package csdir.ui;

import java.awt.*;
import javax.swing.*;

import java.io.File;
import javax.swing.filechooser.FileSystemView;

public abstract class ProtoPanel extends JPanel {
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 15/02/2024
     * @purpose File System
     *
     */
    protected FileSystemView fileSystem = FileSystemView.getFileSystemView();
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 15/02/2024
     * @purpose Create a panel
     * 
     * @param pWidth Width of the Element
     * @param pHeight Height of the Element
     *
     */
    public ProtoPanel(int pWidth, int pHeight) {
        this.init(pWidth, pHeight);
        this.create();
    }
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 15/02/2024
     * @purpose Initialise the panel
     * 
     * @param pWidth Width of the Element
     * @param pHeight Height of the Element
     *
     */
    protected void init(int pWidth, int pHeight) {
        // Create file system
        fileSystem = FileSystemView.getFileSystemView();
        
        this.setLayout(new GridLayout(1,1));
        
        // Set the size of the window
        this.setPreferredSize( new Dimension(pWidth, pHeight) );
        this.setSize( new Dimension(pWidth, pHeight) );
    }
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 15/02/2024
     * @purpose Initialise the panel
     *
     */
    abstract void create();
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 19/02/2024
     * @purpose Set the focus to a new file
     * 
     * @param pFile The file we are going to focus on
     *
     */
    abstract void setFocus(File pFile);
}