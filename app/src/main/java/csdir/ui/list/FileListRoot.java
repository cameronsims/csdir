/**
 * @author Cameron Sims
 * @version 1.0
 * @date 21/02/2024
 * @purpose To standardise how directory lists work
 *
 */
package csdir.ui.list;

import java.io.File;

public class FileListRoot extends FileListFolder {
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 20/02/2024
     * @purpose Set the focus to a new file
     * 
     * @param pFile The file we are going to focus on
     *
     */
    public FileListRoot(File pFile) {
        super(pFile);
    }
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 20/02/2024
     * @purpose What name we wish to show
     *
     */
    @Override
    public String toString() {
        return "./";
    }
}