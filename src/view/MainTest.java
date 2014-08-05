/**
 * 
 */
package view;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;




/**
 * @author bilal
 *
 */
@SuppressWarnings("serial")
public class MainTest extends JFrame implements Runnable {

	public static void main(String[] args) {
        SwingUtilities.invokeLater(new MainTest());

    }


	@Override
	public void run() {
		setTitle("Physica");
		
		//Making fullscreen
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		setUndecorated(true); 
		setResizable(false);

		add(new MainPanel());

        pack();
		setVisible(true);
		
	}
    
    
}
