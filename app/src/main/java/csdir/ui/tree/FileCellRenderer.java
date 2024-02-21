/**
 * @author Cameron Sims
 * @version 1.0
 * @date 19/02/2024
 * @purpose Makes the file node look nice
 *
 */
package csdir.ui.tree;

import java.awt.Color;
import java.io.File;
import java.awt.Component;
import java.net.URL;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.tree.TreeCellRenderer;

public class FileCellRenderer extends DefaultTreeCellRenderer implements TreeCellRenderer {
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 19/02/2024
     * @purpose Constructs the renderer
     *
     */
    public FileCellRenderer() {
        
    }
    
    // Java Non-Sense
    @Override
    public Component getTreeCellRendererComponent(JTree tree,
                                                  Object value,
                                                  boolean selected,
                                                  boolean expanded,
                                                  boolean leaf,
                                                  int row,
                                                  boolean hasFocus) 
    {
        // Set temporary value
        Component temp = super.getTreeCellRendererComponent(tree, value, leaf, expanded, leaf, row, hasFocus);
        
        if (value instanceof FileNode) {
            
            FileNode node = (FileNode)value;
            File file = node.getFile();
            
            // If the file is a directory we will set its icon to a closed folder
            if (file.isDirectory()) {
                UIManager.put("Tree.closedIcon", value);
                UIManager.put("Tree.openIcon", value);
                UIManager.put("Tree.leafIcon", value);
            }
            
            // Set when we're selecting item
            this.setTextSelectionColor(Color.BLACK);
            this.setBackgroundSelectionColor( Color.ORANGE );
            
            // Set when we're not selecting item
            this.setTextNonSelectionColor(Color.BLACK);
            this.setBackgroundNonSelectionColor( Color.WHITE);
            
        }
        
        return temp;
    }
    
}