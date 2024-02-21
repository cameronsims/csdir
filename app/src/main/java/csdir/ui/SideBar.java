/**
 * @author Cameron Sims
 * @version 1.0
 * @date 15/02/2024
 * @purpose The side of the program, lists files that we have pinned
 *
 */
package csdir.ui;

import csdir.ui.list.*;

import java.awt.*;
import javax.swing.*;

import java.io.File;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileSystemView;
 
public class SideBar extends ProtoPanel {
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 15/02/2024
     * @purpose The list of pinned files
     *
     */
    DefaultListModel<FileListFolder> model;
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 15/02/2024
     * @purpose The list of pinned files
     *
     */
    ArrayList<FileListFolder> pinned;
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 15/02/2024
     * @purpose Construct the class
     * 
     * @param pWidth Width of the Element
     * @param pHeight Height of the Element
     *
     */
    public SideBar(int pWidth, int pHeight) {
        super(pWidth, pHeight);
    }
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 15/02/2024
     * @purpose Assign all vector elements to the list
     *
     */
    @Override
    void create() {
        // Create the vector
        this.pinned = new ArrayList<>();
        
        // Add pinned to the pinned vector
        this.getPinned();
        
        // Remove all elements
        this.model = new DefaultListModel<>();
        // Assign pins to list
        for (FileListFolder f : pinned) {
            // Add it to the vector
            model.addElement(f);
        }
        
        // Create the jlist
        JList<FileListFolder> list = new JList<>(this.model);
        
        list.addListSelectionListener(
            new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    JList list = (JList)e.getSource();
                    FileListFolder item = (FileListFolder)list.getSelectedValue();
                    if (item != null) {
                        FileFocuser.setFocus(item.onClick());
                    }
                }
            }
        );
        
        this.add(list);
    }
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 18/02/2024
     * @purpose Gets all items from a list
     *
     */
    private void getPinned() {
        // Add important files like 
        this.pinned = new ArrayList<>();
        for (File f : fileSystem.getHomeDirectory().listFiles()) {
            if (f.isDirectory()) {
                this.pinned.add( new FileListFolder(f) );
            }
        }
        // Read a file full of pins
    }
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 19/02/2024
     * @purpose Set the focus to a new file
     * 
     * @param pFile The file we are going to focus on
     *
     */
    void setFocus(File pFile) {
        // Add to "recently accessed"
    }
}