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
import view.MainPanel;
import view.StageHintsPanel;

/**
 * @author bilal
 *
 */
public class HintsController implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	
private HintsPanel hp;
	
	public HintsController(HintsPanel hp) {
		this.hp = hp;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		hp.setVisible(false);
		JButton btn =(JButton) e.getSource();
		String str = btn.getText();
		JFrame frame = (JFrame) btn.getTopLevelAncestor();
		if (str.equals("Main Menu")){
			frame.add(new MainPanel());
			frame.remove(hp);
		}
		if (str.equals("Help for Game")){
			frame.add(new GameHintsPanel());
			frame.remove(hp);
		}
		else if (str.equals("Stages Hints")){
			frame.add(new StageHintsPanel());
			frame.remove(hp);
		}
		
	}

}
