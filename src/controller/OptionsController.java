/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import view.MainPanel;
import view.OptionsPanel;

/**
 * @author bilal
 *
 */
public class OptionsController implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	private OptionsPanel op;
	
	public OptionsController(OptionsPanel op) {
		this.op = op;
	}
	
	// Controls option screen
	@Override
	public void actionPerformed(ActionEvent e) {
		op.setVisible(false);
		JButton btn =(JButton) e.getSource();
		String str = btn.getText();
		JFrame frame = (JFrame) btn.getTopLevelAncestor();
		if (str.equals("Main Menu")){
			frame.add(new MainPanel());
			frame.remove(op);
		}
		
	}

}
