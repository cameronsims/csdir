/**
 * @author Cameron Sims
 * @version 1.0
 * @date 15/02/2024
 * @purpose The existance of a window
 *
 */
package csdir.ui;
 
import java.awt.*;
import javax.swing.*;

import csdir.ui.FileFocuser;
 
public class Window {
	
	/**
	 * @author Cameron Sims
	 * @version 1.0
	 * @date 15/02/2024
	 * @purpose Create the window / instance
	 *
	 */
	private JFrame window;
        
        /**
	 * @author Cameron Sims
	 * @version 1.0
	 * @date 15/02/2024
	 * @purpose The top bar in the window
	 *
	 */
	private ToolBar toolbar;
        
        /**
	 * @author Cameron Sims
	 * @version 1.0
	 * @date 15/02/2024
	 * @purpose The sidebar of the program
	 *
	 */
	private SideBar sidebar;
        
        /**
	 * @author Cameron Sims
	 * @version 1.0
	 * @date 15/02/2024
	 * @purpose The list of files
	 *
	 */
	private FileTree filelist;
        
        /**
	 * @author Cameron Sims
	 * @version 1.0
	 * @date 15/02/2024
	 * @purpose The list of files
	 *
	 */
	private DirectoryPanel directorylist;
	
	/**
	 * @author Cameron Sims
	 * @version 1.0
	 * @date 15/02/2024
	 * @purpose Create the window / instance
         * 
         * @param pWidth Width of the program
         * @param pHeight Height of the program
	 *
	 */
	public Window(int pWidth, int pHeight) {
            this.init(pWidth, pHeight);
	}
	
        /**
	 * @author Cameron Sims
	 * @version 1.0
	 * @date 15/02/2024
	 * @purpose initalise the instance
         *
         * @param pWidth Width of the program
         * @param pHeight Height of the program
	 *
	 */
        private void init(int pWidth, int pHeight) {
            
            final double[] subdivs = { 0.2, 0.4, 0.4 };
            
            final int sideWidth   = (int)(pWidth * subdivs[0]),
                      treeWidth   = (int)(pWidth * subdivs[1]),
                      directWidth = (int)(pWidth * subdivs[2]),
                      height = pHeight;
            
            // Create a frame
            this.window = new JFrame();
            
            // Set so program doesn't close instantly
            this.window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            // Set the size of the window
            this.window.setPreferredSize(new Dimension(pWidth, pHeight));
            // Set the layout of the window
            this.window.setLayout(new BorderLayout()); // new GridLayout(1, 3) );
            
            // Create a Toolbar //
            this.toolbar = new ToolBar();
            this.window.setJMenuBar(this.toolbar);
            
            // The content field is where both side and file list are
            JPanel contentField = new JPanel();
            
            // Constraints and layout
            BoxLayout layout = this.getLayout(contentField);
            
            // Set the layout we are using
            contentField.setLayout(layout);
            
            // ALL FILES HERE ARE SUBJECT TO FILEFOCUSER ///////////////////////////////////////
            
            // Create a sidebar
            this.sidebar = new SideBar(sideWidth, height);
            
            // Create file tree browser //
            this.filelist = new FileTree(treeWidth, height);
            
            this.directorylist = new DirectoryPanel(directWidth, height);
            
            ////////////////////////////////////////////////////////////////////////////////////
            
            FileFocuser.add(sidebar);
            FileFocuser.add(filelist);
            FileFocuser.add(directorylist);
            
            contentField.add(this.sidebar, BorderLayout.WEST);//constraints); 
            contentField.add(this.filelist, BorderLayout.CENTER);
            contentField.add(this.directorylist, BorderLayout.EAST);
            
            this.window.add(contentField);
            
            // Create status bar //
            
            // Finalise some things 
            this.window.pack();
            this.window.setVisible(true);
        }
        
        /**
	 * @author Cameron Sims
	 * @version 1.0
	 * @date 17/02/2024
	 * @purpose Get the constraints
         *
         * @return Return the constraints we are going to use
	 *
	 */
        private GridBagConstraints getConstraints() {
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.anchor = GridBagConstraints.BOTH;
            
            return constraints;
        }
        
        /**
	 * @author Cameron Sims
	 * @version 1.0
	 * @date 17/02/2024
	 * @purpose Get the layout
         *
         * @param pPanel The Panel we are going to make the layout for
         * 
         * @return Return the layout we are going to use
	 *
	 */
        private BoxLayout getLayout(JPanel pPanel) {
            BoxLayout layout = new BoxLayout(pPanel, BoxLayout.X_AXIS);
            
            return layout;
        }
}