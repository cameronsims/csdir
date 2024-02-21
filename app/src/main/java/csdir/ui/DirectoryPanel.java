/**
 * @author Cameron Sims
 * @version 1.0
 * @date 15/02/2024
 * @purpose This is where are the files are shown
 *
 */
package csdir.ui;

import csdir.ui.list.*;

import java.awt.*;
import javax.swing.*;

import java.io.File;
import javax.swing.event.*;
import javax.swing.filechooser.*;

public class DirectoryPanel extends ProtoPanel {
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 19/02/2024
     * @purpose The directory in focus
     * 
     * 
     *
     */
    private File directory;
    
    private DefaultListModel<FileListItem> model;
    
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
    public DirectoryPanel(int pWidth, int pHeight) {
        super(pWidth, pHeight);
    }
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 15/02/2024
     * @purpose Initialise the panel
     *
     */
    @Override
    void create() {
        // Get the directory we start at
        this.fileSystem = FileSystemView.getFileSystemView();
        this.directory = fileSystem.getHomeDirectory();
        
        this.model = new DefaultListModel<>();
        
        // If the directory somehow isn't a directory do nothing
        if (!this.directory.isDirectory()) {
            return;
        }
        
        // Get the files in the directory
        this.resetLocation();
        
        JList<FileListItem> list = new JList<>(model);
        
        list.addListSelectionListener(
            new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    JList list = (JList)e.getSource();
                    FileListItem item = (FileListItem)list.getSelectedValue();
                    if (item != null) {
                        setFocus(item.onClick());
                        resetLocation();
                    }
                }
            }
        );
       
        
        JScrollPane listScroll = new JScrollPane(list);
        
        this.add(listScroll);
    }
    
    public void update() {
        // Get the files in the directory
        this.resetLocation();
    }
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 15/02/2024
     * @purpose To update the list
     *
     */
    private void resetLocation() {
        File[] files = this.directory.listFiles();
        FileListItem item;
        model.removeAllElements();
        
        // If the file isn't the root file
        File parent = this.directory.getParentFile();
        if (parent != null) {
            model.addElement(new FileListRoot( parent ));
        }
        
        for (File f : files) {
            // Set the list item in the list
            if (f.isDirectory()) {
                item = new FileListFolder(f);
            }
            else {
                item = new FileListFile(f);
            }
            // The element we are adding
            model.addElement(item);
        }
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
    @Override
    void setFocus(File pFile) {
        this.directory = pFile;
        
        this.resetLocation();
        
        this.revalidate();
        this.repaint();
    }
}