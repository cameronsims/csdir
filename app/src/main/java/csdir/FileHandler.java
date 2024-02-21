/**
 * @author Cameron Sims
 * @version 1.0
 * @date 18/02/2024
 * @purpose This is where files are created, renamed, deleted, etc
 *
 */
package csdir;

import java.io.File;
import javax.swing.*;

public interface FileHandler {
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 18/02/2024
     * @purpose Create a directory
     * 
     * @param pDirectory The place which we are making the file in
     *
     */
    public static File mkdir(File pDirectory) {
        // If we are not in a directory, do not bother making a file
        if (!pDirectory.isDirectory()) {
            return null;
        }
        
        // Get the name of the file we are creating
        JPopupMenu nameMenu = new JPopupMenu("Get Name");
        
        nameMenu.setVisible(true);
        
        File newFile = new File("C:\\");
        
        return newFile;
    }
}