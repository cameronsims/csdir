/**
 * @author Cameron Sims
 * @version 1.0
 * @date 21/02/2024
 * @purpose To standardise how directory lists work
 *
 */
package csdir.ui.list;

import java.io.File;

public class FileListFolder extends FileListItem {
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 20/02/2024
     * @purpose Set the focus to a new file
     * 
     * @param pFile The file we are going to focus on
     *
     */
    public FileListFolder(File pFile) {
        super(pFile);
        if (!pFile.isDirectory()) {
            this.setFile(null);
        }
    }
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 20/02/2024
     * @purpose What file we are going to go to one selected
     * 
     * @return Returns the file incased
     *
     */
    public File onClick() {
        return this.getFile();
    }
}