/**
 * @author Cameron Sims
 * @version 1.0
 * @date 15/02/2024
 * @purpose The toolbar of the program
 *
 */
package csdir.ui;

import java.awt.event.*;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import csdir.FileHandler;

import java.io.File;

public class ToolBar extends JMenuBar {
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 15/02/2024
     * @purpose Creates the toolbar
     *
     */
    public ToolBar() {
        // Set file options
        JMenu file = new JMenu("File");
        
        JMenuItem directory_new = new JMenuItem("Create New Directory");
        directory_new.addActionListener( 
            new ActionListener() { 
                public void actionPerformed(ActionEvent ae) {
                    FileHandler.mkdir( new File("C:\\Users\\daemc\\OneDrive\\Desktop") );
                }
            });
        
        file.add(directory_new);
        
        this.add(file);
        
        // Set edit options
        JMenu edit = new JMenu("Edit");
        
         this.add(edit);
        
        // Set view options
        JMenu view = new JMenu("View");
        
         this.add(view);
        
        // Set options
        JMenu opts = new JMenu("Options");
        
         this.add(opts);
        
        // Set info options
        JMenu info = new JMenu("Info");
        
        this.add(info);
    }
	
}