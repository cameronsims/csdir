/**
 * @author Cameron Sims
 * @version 1.0
 * @date 21/02/2024
 * @purpose To standardise how directory lists work
 *
 */
package csdir.ui.list;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class FileListFile extends FileListItem {

    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 20/02/2024
     * @purpose Set the focus to a new file
     * 
     * @param pFile The file we are going to focus on
     *
     */
    public FileListFile(File pFile) {
        super(pFile);
        if (!pFile.isFile()) {
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
    @Override
    public File onClick() {
        File f = this.getFile();
        try {
            Desktop.getDesktop().open(f);
        } catch (IOException e) {
            
        }
        return f;
    }
}