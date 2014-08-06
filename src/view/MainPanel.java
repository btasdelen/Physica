

// Main Panel
// Author Muhammet �im�ek



package view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import controller.MainPanelController;

import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {

	
	private final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	private final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	private MainPanelController mpc = new MainPanelController(this);
	
	
	public MainPanel() {


		setLayout(null);
		
		ImageIcon img = new ImageIcon("backgrounds/mainmenu.jpg");
		Image original = img.getImage();
		ImageIcon image =  new ImageIcon(original.getScaledInstance(SCREEN_WIDTH, SCREEN_HEIGHT, Image.SCALE_FAST));


		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		
		JButton btn1 = new JButton("Select Stage");
		btn1.setBackground(new Color(210, 180, 140));
		btn1.setForeground(new Color(255, 255, 255));
		btn1.setFont(new Font("TEN O CLOCK", Font.PLAIN, SCREEN_WIDTH/35));
		btn1.setBounds(SCREEN_WIDTH/15, SCREEN_HEIGHT/10, SCREEN_WIDTH/5, SCREEN_HEIGHT/10);
		btn1.setOpaque(false);
		add(btn1);
		
		JButton btn2 = new JButton("Hints");
		btn2.setBackground(new Color(210, 180, 140));
		btn2.setForeground(new Color(255, 255, 255));
		btn2.setFont(new Font("TEN O CLOCK", Font.PLAIN, SCREEN_WIDTH/35));
		btn2.setBounds(SCREEN_WIDTH/15, 3*(SCREEN_HEIGHT/10), SCREEN_WIDTH/5, SCREEN_HEIGHT/10);
		btn2.setOpaque(false);
		add(btn2);
		
		JButton btn3 = new JButton("Options");
		btn3.setBackground(new Color(210, 180, 140));
		btn3.setFont(new Font("TEN O CLOCK", Font.PLAIN, SCREEN_WIDTH/35));
		btn3.setForeground(new Color(255, 255, 255));
		btn3.setBounds(SCREEN_WIDTH/15, 5*(SCREEN_HEIGHT/10), SCREEN_WIDTH/5, SCREEN_HEIGHT/10);
		btn3.setOpaque(false);
		add(btn3);
		
		JButton btn4 = new JButton("Quit");
		btn4.setBackground(new Color(210, 180, 140));
		btn4.setForeground(new Color(204, 0, 51));
		btn4.setFont(new Font("TEN O CLOCK", Font.PLAIN, SCREEN_WIDTH/35));
		btn4.setBounds(SCREEN_WIDTH/15, 7*(SCREEN_HEIGHT/10), SCREEN_WIDTH/5, SCREEN_HEIGHT/10);
		btn4.setOpaque(false);
		add(btn4);
		
		JLabel background = new JLabel("");
		background.setIcon(image);
		background.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		add(background);
		
		btn1.addActionListener(mpc);
		
		btn2.addActionListener(mpc);
		
		btn3.addActionListener(mpc);

		btn4.addActionListener(mpc);

	}
}
