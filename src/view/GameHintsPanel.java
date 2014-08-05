package view;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;

import controller.GameHintsController;

@SuppressWarnings("serial")
public class GameHintsPanel extends JPanel {

	/**
	 * author muhammet
	 */
	
	private GameHintsController ghc = new GameHintsController(this);
	private final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	private final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	
	public GameHintsPanel() {
		
		
		setLayout(null);
		
		
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		
		
		ImageIcon img = new ImageIcon("backgrounds/gamehints.jpg");
		Image original = img.getImage();	
		ImageIcon image =  new ImageIcon(original.getScaledInstance(SCREEN_WIDTH, SCREEN_HEIGHT, Image.SCALE_FAST));
		
		JButton btn = new JButton("BACK");
		btn.setBackground(new Color(255, 255, 255));
		btn.setForeground(new Color(0, 255, 51));
		btn.setFont(new Font("TEN O CLOCK", Font.PLAIN, SCREEN_WIDTH/40));
		btn.setBounds(40, 40, SCREEN_WIDTH/11, SCREEN_HEIGHT/17);
		btn.setOpaque(false);
		add(btn);
		
		btn.addActionListener(ghc);
		
		JLabel background = new JLabel("");
		background.setIcon(image);
		background.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		add(background);
		

	}
}
