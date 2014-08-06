/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

/**
 * @author bilal
 *
 */
@SuppressWarnings("serial")
public class TimeLabelView extends JLabel {
	
	boolean isPaused;
	
	public TimeLabelView() {
		super("0:00");
		isPaused = false;
		setFont(new Font("Ten O Clock", Font.ITALIC, 50));
		setForeground(Color.WHITE);
		setPreferredSize(new Dimension(200, 100));

	}
	
	public void setTime(int min, int sec) {
		if (sec < 10)
			setText(min + ":0" + sec);
		else
			setText(min + ":" + sec);

	}
	
	public void pause() {
		isPaused = true;
		setForeground(Color.ORANGE);
		setText("Paused");
	}
	
	public void resume() {
		setForeground(Color.WHITE);

		isPaused = false;
	}
	
	public boolean isPaused() {
		return isPaused;
	}

}
