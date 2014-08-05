/**
 * 
 */
package view;

import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author bilal
 *
 */
@SuppressWarnings("serial")
public class InGameMenuButton extends JButton {
	public InGameMenuButton() {
		setOpaque(false);
		setIcon(new ImageIcon("backgrounds/gear.png"));
		setBackground(SystemColor.desktop);
		setBounds(600, 500, 0, 0);
	
	}
	
	public void addActionListener(InGamePanel igp, InGameMenu igm) {
		addActionListener(new controller.InGameMenuButtonController(igp, igm));

	}
}
