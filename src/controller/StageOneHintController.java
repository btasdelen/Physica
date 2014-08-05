/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;





import view.StageHintsPanel;
import view.StageOneHint;

/**
 * @author muhammet
 *
 */
public class StageOneHintController implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	
private StageOneHint soh;
	
	public StageOneHintController(StageOneHint soh) {
		this.soh = soh;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		soh.setVisible(false);
		JButton btn =(JButton) e.getSource();
		String str = btn.getText();
		JFrame frame = (JFrame) btn.getTopLevelAncestor();
		if (str.equals("BACK")){
			frame.add(new StageHintsPanel());
			frame.remove(soh);
		}
	
		
	}

}
