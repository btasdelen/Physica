/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;





import view.StageFourHint;
import view.StageHintsPanel;


/**
 * @author muhammet
 *
 */
public class StageFourHintController implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	
private StageFourHint sfh;
	
	public StageFourHintController(StageFourHint sfh) {
		this.sfh = sfh;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		sfh.setVisible(false);
		JButton btn =(JButton) e.getSource();
		String str = btn.getText();
		JFrame frame = (JFrame) btn.getTopLevelAncestor();
		if (str.equals("BACK")){
			frame.add(new StageHintsPanel());
			frame.remove(sfh);
		}
	
		
	}

}