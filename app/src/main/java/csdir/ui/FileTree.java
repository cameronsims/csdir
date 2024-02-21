/**
 * @author Cameron Sims
 * @version 1.0
 * @date 15/02/2024
 * @purpose The side of the program
 *
 */
package csdir.ui;

import csdir.ui.tree.*;

import java.io.File;
import java.util.ArrayList;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.*;
import javax.swing.tree.*;

public class FileTree extends ProtoPanel {
    
     /**
     * @author Cameron Sims
     * @version 1.0
     * @date 17/02/2024
     * @purpose File System
     *
     */
    private DefaultTreeModel model;
    
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
    public FileTree(int pWidth, int pHeight) {
        super(pWidth, pHeight);
    }
    
     /**
     * @author Cameron Sims
     * @version 1.0
     * @date 15/02/2024
     * @purpose Display all the files
     * 
     * @param pPanel The panel we are adding the content to
     *
     */
    @Override
    void create() {
        this.createRoot();
        
        // The JTree we will place
        JTree tree = new JTree(this.model);
        
        tree.setRootVisible(false);
        tree.setShowsRootHandles(true);
        
        // The Scroll of the JTree
        JScrollPane treeScroll = new JScrollPane(tree);
        this.add(treeScroll);
        
        // Tree functionality //
        
        tree.setCellRenderer(new FileCellRenderer());
        tree.addTreeExpansionListener(new FileTreeListener.FileTreeExpansionListener());
        tree.addTreeWillExpandListener(new FileTreeListener.FileTreeWillExpansionListener() {
            @Override
            public void onExpansion(FileNode pNode) {
                model = FileTreeExpansion.createChildren(pNode, model);
                model.reload(pNode);
            }
            
            @Override
            public void onCollapse(FileNode pNode) {
                FileTreeExpansion.deleteChildren(pNode, model);
            }
        });
        tree.addTreeSelectionListener(new FileTreeListener.FileTreeSelectionListener());
        
        this.model.addTreeModelListener(new FileTreeListener.FileTreeModelListener());
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
        //TreePath path = (TreePath)pFile.toPath();
    }
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 16/02/2024
     * @purpose Creates the roots nodes
     *
     */
    private File[] getRoots() {
         // Get the root of the system
        ArrayList<File> roots = new ArrayList<File>();
        
        // Add all the roots that the computer has
        for (File root : File.listRoots()) {
            roots.add(root);
        }
        // Also add the home directories
        //roots.add( fileSystem.getDefaultDirectory() );
        
        File[] returnRoots = new File[roots.size()];
        returnRoots = roots.toArray(returnRoots);
        
        // Cast and return
        return returnRoots;
    }
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 16/02/2024
     * @purpose Create the children nodes
     *
     */
    public void createRoot() {
         // Get the root of the system
        File[] roots = this.getRoots();
        
        // Create the new file nodes which represent one for each pFile
        DefaultMutableTreeNode startRoot = new DefaultMutableTreeNode("Root");
        this.model = new DefaultTreeModel(startRoot);
        
        // For each file, add it to the nodes
        for (int i = 0; i < roots.length; i++) {
            FileNode newNode = new FileNode( roots[i]);
            FileTreeExpansion.createChildren(newNode, this.model);
            startRoot.add( newNode );
        }
    }
    
}