package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;






import view.HintsPanel;
import view.StageFourHint;
import view.StageHintsPanel;
import view.StageOneHint;
import view.StageThreeHint;
import view.StageTwoHint;




public class StageHintsController implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	private StageHintsPanel shp;
	
	public StageHintsController(StageHintsPanel shp) {
		this.shp = shp;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		shp.setVisible(false);
		JButton btn =(JButton) e.getSource();
		String str = btn.getText();
		JFrame frame = (JFrame) btn.getTopLevelAncestor();
		if (str.equals("Main Menu")){
			frame.add(new HintsPanel());
		}
		else if (str.equals("1")){
			frame.add(new StageOneHint());
		}
		else if (str.equals("2")){
			frame.add(new StageTwoHint());
		}
		else if (str.equals("3")){
			frame.add(new StageThreeHint());
		}
		else if (str.equals("4")){
			frame.add(new StageFourHint());
		}
		
		
		
		frame.remove(shp);
		
		

	}

}