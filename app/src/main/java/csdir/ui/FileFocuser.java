/**
 * @author Cameron Sims
 * @version 1.0
 * @date 20/02/2024
 * @purpose A side of the program
 *
 */
package csdir.ui;

import java.io.File;
import java.util.ArrayList;

public abstract class FileFocuser {
    
    private static ArrayList<ProtoPanel> tabs = new ArrayList<>();
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 20/02/2024
     * @purpose Add to the tabs
     * 
     * @param pPanel Panel we are adding
     *
     */
    public static void add(ProtoPanel pPanel) {
        tabs.add(pPanel);
    }
    
    /**
     * @author Cameron Sims
     * @version 1.0
     * @date 20/02/2024
     * @purpose File to focus
     * 
     * @param pFile
     *
     */
    public static void setFocus(File pFile) {
        for (ProtoPanel p : tabs) {
            p.setFocus(pFile);
        }
    }
}