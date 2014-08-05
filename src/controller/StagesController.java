/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import stages.*;
import view.InGamePanel;
import view.MainPanel;
import view.StagesPanel;

/**
 * @author bilal
 *
 */
public class StagesController implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	private StagesPanel sp;
	
	public StagesController(StagesPanel sp) {
		this.sp = sp;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		sp.setVisible(false);
		JButton btn =(JButton) e.getSource();
		String str = btn.getText();
		JFrame frame = (JFrame) btn.getTopLevelAncestor();
		if (str.equals("Main Menu")){
			frame.add(new MainPanel());
		}
		
		else if (str.equals("1"))
			try {
				frame.add(new InGamePanel(new StageOne()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if (str.equals("2"))
			try {
				frame.add(new InGamePanel(new StageTwo()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if (str.equals("3"))
			try {
				frame.add(new InGamePanel(new StageThree()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if (str.equals("4"))
			try {
				frame.add(new InGamePanel(new StageFour()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if (str.equals("5"))
			try {
				frame.add(new InGamePanel(new StageFive()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if (str.equals("6"))
			try {
				frame.add(new InGamePanel(new StageSix()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if (str.equals("7"))
			try {
				frame.add(new InGamePanel(new StageSeven()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if (str.equals("8"))
			try {
				frame.add(new InGamePanel(new StageEight()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if (str.equals("9"))
			try {
				frame.add(new InGamePanel(new StageNine()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		else if (str.equals("10"))
			try {
				frame.add(new InGamePanel(new StageTen()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		frame.remove(sp);

	}

}
