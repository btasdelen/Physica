/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;

import org.jdesktop.swingx.JXPanel;

import controller.WonScreenButtonControls;

/**
 * @author bilal
 *
 */
@SuppressWarnings("serial")
public class WonView extends JXPanel {
	
	private JLabel lbl = new JLabel("Congratulations!");
	private JButton btn = new JButton("Go to Stages");
	
	final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	private WonScreenButtonControls wbc = new WonScreenButtonControls();
	
	
	public WonView() {
		setOpaque(false);
		setLayout(new GridLayout(2, 1));
		btn.setForeground(Color.WHITE);
		btn.setFont(new Font("TEN O CLOCK", Font.PLAIN, 40));
		btn.setBackground(Color.WHITE);
		btn.setBounds(SCREEN_WIDTH-250, SCREEN_HEIGHT-100, 215, 60);
		btn.setOpaque(false);
		
		
		lbl.setForeground(new Color(255, 0, 0));
		lbl.setFont(new Font("TEN O CLOCK", Font.PLAIN, 72));
		lbl.setBounds(SCREEN_WIDTH/2, SCREEN_HEIGHT/2, 215, 60);
		lbl.setOpaque(false);
		
		btn.addActionListener(wbc);
		add(lbl);
		add(btn);

	}

}
