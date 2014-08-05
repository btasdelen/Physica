/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import view.GameHintsPanel;
import view.HintsPanel;

/**
 * @author muhammet
 *
 */
public class GameHintsController implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	
private GameHintsPanel ghp;
	
	public GameHintsController(GameHintsPanel ghp) {
		this.ghp = ghp;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		ghp.setVisible(false);
		JButton btn =(JButton) e.getSource();
		String str = btn.getText();
		JFrame frame = (JFrame) btn.getTopLevelAncestor();
		if (str.equals("BACK")){
			frame.add(new HintsPanel());
			frame.remove(ghp);
		}
	
		
	}

}
