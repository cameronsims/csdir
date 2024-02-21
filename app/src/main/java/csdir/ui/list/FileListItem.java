/**
 * @author Cameron Sims
 * @version 1.0
 * @date 21/02/2024
 * @purpose To standardise how directory lists work
 *
 */
package csdir.ui.list;

import java.io.File;

public abstract class FileListItem {
        
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 20/02/2024
     * @purpose The file which is represented by the item
     *
     */
    File file;
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 20/02/2024
     * @purpose Set the focus to a new file
     * 
     * @param pFile The file we are going to focus on
     *
     */
    public FileListItem(File pFile) {
        this.setFile(pFile);
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
        return this.file.getName();
    }
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 21/02/2024
     * @purpose Get the file this refers to
     * 
     * @return Returns the file incased
     *
     */
    public File getFile() {
        return this.file;
    }
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 21/02/2024
     * @purpose Get the file this refers to
     * 
     * @param pFile file we are setting
     *
     */
    public void setFile(File pFile) {
        this.file = pFile;
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
    abstract public File onClick();
}