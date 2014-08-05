/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TimeLabelView;

/**
 * @author bilal
 *
 */
public class TimeLabelController implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	
	private TimeLabelView view;
	private int min;
	private int sec;
	
	
	public TimeLabelController(TimeLabelView view) {
		this.view = view;
		min = 0;
		sec = 0;
	}
	
	public void incrementTime() {
		//increment second and then check if necessary to increment menu
		sec++;
		if (sec == 60){
			min++;
			sec = 0;
		}
	}
	
	public void resetTime() {
		min = 0;
		sec = 0;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//update the time view
		if( !view.isPaused()) {
			incrementTime();
			view.setTime(min, sec);
		}
		view.repaint();

	}

}
