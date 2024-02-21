/**
 * @author Cameron Sims
 * @version 1.0
 * @date 15/02/2024
 * @purpose The entry point of the program
 *
 */
package csdir;

import csdir.ui.Window;
 
public class EntryPoint {
	
	/**
     * @author Cameron Sims
     * @version 1.0
     * @date 15/02/2024
     * @purpose The entry point of the program
     *
     */
	public static void main(String[] args) {
            final int width = 256 * 3;
            final int height = 512 + 128;
            Window window = new Window(width, height);
	}
	
}