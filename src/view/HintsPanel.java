


// Hints Panel
// Author Muhammet �im�ek



package view;


import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;






import controller.HintsController;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;

@SuppressWarnings("serial")
public class HintsPanel extends JPanel {

	
	private HintsController hc = new HintsController(this);
	private final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	private final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	
	public HintsPanel() {
		setLayout(null);
		
		
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		
		
		ImageIcon img = new ImageIcon("backgrounds/hintsmenu.jpg");
		Image original = img.getImage();	
		ImageIcon image =  new ImageIcon(original.getScaledInstance(SCREEN_WIDTH, SCREEN_HEIGHT, Image.SCALE_FAST));
		
		
		
		JButton btn1 = new JButton("Help for Game");
		btn1.setForeground(new Color(255, 255, 255));
		btn1.setFont(new Font("TEN O CLOCK", Font.BOLD, SCREEN_WIDTH/30));
		btn1.setBackground(new Color(204, 0, 0));
		btn1.setBounds(SCREEN_WIDTH/7, 2*(SCREEN_HEIGHT/5), SCREEN_WIDTH/3, SCREEN_HEIGHT/9);
		btn1.setOpaque(true);
		add(btn1);
		
		JButton btn2 = new JButton("Stages Hints");
		btn2.setForeground(new Color(255, 255, 255));
		btn2.setFont(new Font("TEN O CLOCK", Font.BOLD, SCREEN_WIDTH/30));
		btn2.setBackground(new Color(204, 0, 0));
		btn2.setBounds(5*(SCREEN_WIDTH/9), 2*(SCREEN_HEIGHT/5), SCREEN_WIDTH/3, SCREEN_HEIGHT/9);
		btn2.setOpaque(true);
		add(btn2);
		
		JButton btn3 = new JButton("Main Menu");
		btn3.setForeground(new Color(255, 255, 255));
		btn3.setFont(new Font("TEN O CLOCK", Font.BOLD, SCREEN_WIDTH/40));
		btn3.setBackground(new Color(204, 0, 0));
		btn3.setBounds(SCREEN_WIDTH-250, SCREEN_HEIGHT-100, SCREEN_WIDTH/6, SCREEN_HEIGHT/15);
		btn3.setOpaque(true);
		add(btn3);
		
		JLabel background = new JLabel("");
		background.setIcon(image);
		background.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		add(background);
		
		
		
		btn1.addActionListener(hc);
		btn2.addActionListener(hc);
		btn3.addActionListener(hc);


	   
	   

	    
	
		  
	}	
}
