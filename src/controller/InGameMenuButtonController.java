/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.BlurEffect;
import view.InGameMenu;
import view.InGamePanel;

/**
 * @author bilal
 *
 */
public class InGameMenuButtonController implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	private InGamePanel igp;
	private InGameMenu igm;
	
	public InGameMenuButtonController(InGamePanel igp, InGameMenu igm) {
		
		this.igp = igp;
		this.igm = igm;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Animate blur and pause the game
		BlurEffect be = new BlurEffect(igm);
		igp.pause();
		igp.add(be);
		be.fadeIn();

	}

}
