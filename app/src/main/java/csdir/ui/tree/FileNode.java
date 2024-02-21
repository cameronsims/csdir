/**
 * @author Cameron Sims
 * @version 1.0
 * @date 19/02/2024
 * @purpose The functionality of the file tree
 *
 */
package csdir.ui.tree;

import java.io.File;
import javax.swing.tree.DefaultMutableTreeNode;

public class FileNode extends DefaultMutableTreeNode {
    private File file;

    public FileNode(File file) {
        this.file = file;
    }
    
    public File getFile() {
        return this.file;
    }
        
    @Override
    public String toString() {
        String name = file.getName();
        if (name.equals("")) {
            return file.getAbsolutePath();
        }
        return name;
    }
}