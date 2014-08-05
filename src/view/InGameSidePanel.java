/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.Border;

/**
 * @author bilal
 *
 */
@SuppressWarnings("serial")
public class InGameSidePanel extends JPanel {
	JToggleButton cr = new JToggleButton();
	JToggleButton rct = new JToggleButton();
	JLabel lbl = new JLabel(" Shape");
	private final Color SWEET_BLUE = new Color(91, 133, 210);
	private final Border BLUE_LINE = BorderFactory.createLineBorder(SWEET_BLUE, 5, true);

	
	public InGameSidePanel() {
		setPreferredSize(new Dimension(90, 210));
		setOpaque(false);
		setLayout(new GridLayout(3, 1));
		lbl.setOpaque(false);
		lbl.setFont(new Font("TEN O CLOCK", Font.BOLD, 23));
		lbl.setForeground(SWEET_BLUE);
		cr.setIcon(new ImageIcon("backgrounds/circle.png"));
		cr.setBackground(SystemColor.LIGHT_GRAY);
		rct.setIcon(new ImageIcon("backgrounds/rectangle.png"));
		rct.setBackground(SystemColor.LIGHT_GRAY);
		
		setBorder(BLUE_LINE);
		add(lbl);
		add(cr);
		add(rct);

	}
	
	public ArrayList<JToggleButton> getButtons() { 
		ArrayList<JToggleButton> buttons = new ArrayList<JToggleButton>(); 
		buttons.add(cr); 
		buttons.add(rct); 
		return buttons; 
	}
	
	
	public void pause() {
		cr.setEnabled(false);
		rct.setEnabled(false);

		
	}
	
	public void resume() {
		cr.setEnabled(true);
		rct.setEnabled(true);

	}


}
