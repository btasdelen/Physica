/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import org.jdesktop.swingx.JXPanel;

/**
 * @author bilal
 *
 */



@SuppressWarnings("serial")
public class InGameMenu extends JXPanel{
	

	private Border compound;
	private final Border MARGIN = BorderFactory.createEmptyBorder(20, 20, 20, 20);

	private final Color SWEET_BLUE = new Color(91, 133, 210);
	private final Border BLUE_LINE = BorderFactory.createLineBorder(SWEET_BLUE, 15, true);
	private final Border GRAY_LINE = BorderFactory.createLineBorder(Color.GRAY, 5, true);

	private JButton resume = new JButton("Resume");
	private JButton options = new JButton("Options");
	private JButton quit = new JButton("Quit");
	private Font font = new Font("TEN O CLOCK", Font.ITALIC, 25);
	public InGameMenu(InGamePanel igp) {
		
		setLayout(new GridLayout(3, 1));
		
		setOpaque(false);
		
		
	
		setPreferredSize(new Dimension(400, 300));

		resume.setBackground(SystemColor.desktop);
		resume.setForeground(Color.ORANGE);
		resume.setOpaque(false);
		resume.setFont(font);
		
		options.setBackground(SystemColor.desktop);
		options.setForeground(Color.MAGENTA);
		options.setOpaque(false);
		options.setFont(font);


		quit.setBackground(SystemColor.desktop);
		quit.setForeground(Color.RED);
		quit.setOpaque(false);
		quit.setFont(font);

		
		resume.addActionListener(new controller.InGameMenuController(igp));
		options.addActionListener(new controller.InGameMenuController(igp));
		quit.addActionListener(new controller.InGameMenuController(igp));



		//Add a title to the blue-outlined frame.

		compound = BorderFactory.createTitledBorder(BLUE_LINE, "MENU", TitledBorder.CENTER, 
				TitledBorder.BELOW_TOP, new Font("TEN O CLOCK", Font.BOLD, 30), SWEET_BLUE);

		//Adding margin
		compound = BorderFactory.createCompoundBorder(
                compound, MARGIN);
		compound = BorderFactory.createCompoundBorder(
                GRAY_LINE, compound);

		setBorder(compound);
		add(resume);
		add(options);
		add(quit);
	
	}
}
	
