/**
 * @author Cameron Sims
 * @version 1.0
 * @date 20/02/2024
 * @purpose The functionality of the file tree
 *
 */
package csdir.ui.tree;

import java.io.File;
import java.util.ArrayList;
import javax.swing.event.*;
import javax.swing.tree.*;

public class FileTreeExpansion {
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 17/02/2024
     * @purpose Gets file from node
     * 
     * @param pEvent The event we get the file from
     * 
     * @returns File that we wish to get
     *
     */
    public static File getFile(TreeExpansionEvent pEvent) {
        TreePath filePath = pEvent.getPath();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)filePath.getLastPathComponent();
        return getFile(filePath);
    }
    public static File getFile(TreeSelectionEvent pEvent) {
        TreePath filePath = pEvent.getPath();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)filePath.getLastPathComponent();
        return getFile(filePath);
    }
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 17/02/2024
     * @purpose Gets file from node
     * 
     * @param pTreePath The path which the node came from
     * 
     * @returns File that we wish to get
     *
     */
    public static File getFile(TreePath pTreePath) {
        String fileFullPath = "";
        // Doing this because literally every other option gives errors
        // NOTE: WE START AT 1 BECAUSE OF THE "ROOT" FILE
        for (int i = 1; i < pTreePath.getPathCount(); i++) {
            fileFullPath += pTreePath.getPathComponent(i).toString() + File.separator;
        }
                    
        File file = new File(fileFullPath);
        
        return file;
    }
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 16/02/2024
     * @purpose Create the children nodes
     * 
     * @param pNode The current node of the tree
     * @param pModel The tree model we are changing
     * @param pLayer The current layer of the tree
     *
     */
    public static DefaultTreeModel createChildren(FileNode pNode, DefaultTreeModel pModel) {
        return createChildren(pNode, pModel, 0);
    }
    
    public static DefaultTreeModel createChildren(FileNode pNode, DefaultTreeModel pModel, int pLayer) {
        // if node doesn't exist
        if (pNode == null) {
            return pModel;
        }
        // Get the root
        File root = pNode.getFile();
        File[] inDirectory;
        
        // if we aren't in a directory or file doesn't exist
        if (!root.isDirectory() || !root.exists()) {
            return pModel;
        }
        
        // List files in directory
        inDirectory = root.listFiles();
        // If there are no files, do not bother searching and creating
        if (inDirectory == null || !(inDirectory.length > 0)) {
            return pModel;
        }
        
        // If the node has children replace
        if (pNode.getChildCount() > 0) {
            // Delete ALL Nodes
            deleteChildren(pNode, pModel);
        }
        
        // Then we will create the children
        int[] inds = new int[inDirectory.length];
        
        // i scales for ALL FILES, Index scales for DIRECTORIES ONLY
        int index = 0;
        
        for (File f : inDirectory) {
            // Create a new child
            FileNode child = new FileNode(f);
            
            // NEEDS OPTIMISATION TAKES WAYYYY TOO LONG
            
            // FOR SOME REASON I CAN'T DO THIS??? ///////////////////////////
            // Add nodes if we are in the layer to do so
            if (pLayer < 1) {
                createChildren(child, pModel, pLayer + 1);
            }
            //////////////////////////////////////////////////////////////////
            
            // Add the node
            if (pModel == null) {
                pNode.add(child);
            } else {
                pModel.insertNodeInto(child, pNode, pNode.getChildCount());//index);
                pModel.reload(child);
            }
            index++;
        }
        
        return pModel;
    }
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 17/02/2024
     * @purpose Delete the children nodes
     * 
     * @param pRoot The root of the file we are deleting
     * @param pModel The tree model we are changing
     *
     */
    public static DefaultTreeModel deleteChildren(FileNode pRoot, DefaultTreeModel pModel) {
        // Check if the root would allow children
        if ((pRoot == null && 
            // if we can't give it children
            !pRoot.getAllowsChildren()) ||
            // If this is the lowest root
            pRoot.isRoot()) 
        {
            return pModel;
        }
        
        File root = pRoot.getFile();
        pRoot = new FileNode(root);
        
        for (int i = 0; i < pRoot.getChildCount(); i++) {
            // get the node to be removed
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)pRoot.getChildAt(i);
            // Banish it
            pModel.removeNodeFromParent(node);
        }
        
        return pModel;
    }
}