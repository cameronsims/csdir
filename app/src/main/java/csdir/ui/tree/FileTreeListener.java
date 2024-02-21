/**
 * @author Cameron Sims
 * @version 1.0
 * @date 19/02/2024
 * @purpose The functionality of the file tree
 *
 */
package csdir.ui.tree;

import csdir.ui.FileFocuser;
import csdir.ui.tree.FileTreeExpansion;

import java.io.File;

import java.util.Enumeration;

import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.*;

public interface FileTreeListener {
    
    public class FileTreeEventListener {
        /**
         * @author Cameron Sims
         * @version 1.0
         * @date 20/02/2024
         * @purpose To run code in other files
         * 
         * @param pNode the Node that will be edited 
         *
         */
        public void onExpansion(FileNode pNode) {}
    
        /**
        * @author Cameron Sims
        * @version 1.0
        * @date 20/02/2024
        * @purpose To run code in other files
        * 
        * @param pNode the Node that will be edited 
        *
        */
        public void onCollapse(FileNode pNode) {}
    }
    
    public class FileTreeWillExpansionListener extends FileTreeEventListener implements TreeWillExpandListener {
        @Override
        public void treeWillExpand(TreeExpansionEvent e) {
            File file = FileTreeExpansion.getFile(e);
            FileNode node = new FileNode(file);
            onExpansion(node);
        }
        
        @Override
        public void treeWillCollapse(TreeExpansionEvent e) {
            File file = FileTreeExpansion.getFile(e);
            FileNode node = new FileNode(file);
            onCollapse(node);
        }
    }
    
    public class FileTreeExpansionListener extends FileTreeEventListener implements TreeExpansionListener {
        @Override
        public void treeExpanded(TreeExpansionEvent e) { 
            File file = FileTreeExpansion.getFile(e);
            FileNode node = new FileNode(file);
            onExpansion(node);
        }
                
        @Override
        public void treeCollapsed(TreeExpansionEvent e) {
            File file = FileTreeExpansion.getFile(e);
            FileNode node = new FileNode(file);
            
            onCollapse(node);
        }
    }
    
    public class FileTreeSelectionListener extends FileTreeEventListener implements TreeSelectionListener {
        @Override
        public void valueChanged(TreeSelectionEvent e) {
            File file = FileTreeExpansion.getFile(e);
            onClick(file);
        }
        
        public void onClick(File pFile) {
            FileFocuser.setFocus(pFile);
        }
    }
    
    public class FileTreeModelListener implements TreeModelListener {
        @Override
        public void treeStructureChanged(TreeModelEvent e) {
            System.out.println("Structure Changed: " + e.getTreePath().toString() + " " + e.getTreePath().getPathCount());
        }
            
        @Override
        public void treeNodesChanged(TreeModelEvent e) {
            System.out.println("Nodes Changed");
        }

        @Override
        public void treeNodesInserted(TreeModelEvent e) {
            System.out.println("Nodes Added");
        }
        
        @Override
        public void treeNodesRemoved(TreeModelEvent e) {
            System.out.println("Nodes Removed");
        }
    };
}