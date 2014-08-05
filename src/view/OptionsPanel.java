

// Options Panel
// Author Muhammet Å�imÅŸek



package view;

import javax.swing.*;

import controller.OptionsController;

import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class OptionsPanel extends JPanel {

	private final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	private final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public OptionsPanel() {
		setLayout(null);
		
		
		ImageIcon img = new ImageIcon("backgrounds/optionsmenu.jpg");
		Image original = img.getImage();
		ImageIcon image =  new ImageIcon(original.getScaledInstance(SCREEN_WIDTH, SCREEN_HEIGHT, Image.SCALE_FAST));
		
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		
		JSlider slider = new JSlider();
		slider.setBackground(new Color(204, 0, 0));
		slider.setForeground(new Color(51, 102, 0));
		slider.setBounds(3*(SCREEN_WIDTH/7), SCREEN_HEIGHT/2, SCREEN_WIDTH/7, 24);
		slider.setOpaque(false);
		add(slider);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setForeground(new Color(255, 0, 0));
		checkBox.setBackground(new Color(204, 0, 0));
		checkBox.setBounds(9*(SCREEN_WIDTH/20), 5*(SCREEN_HEIGHT/9), 29, 35);
		checkBox.setOpaque(false);
		add(checkBox);
		
		JRadioButton rdbtnKeyboard = new JRadioButton("KEYBOARD");
		rdbtnKeyboard.setBackground(new Color(102, 102, 102));
		rdbtnKeyboard.setSelected(true);
		rdbtnKeyboard.setFont(new Font("Segoe Script", Font.BOLD, SCREEN_WIDTH/50));
		rdbtnKeyboard.setForeground(new Color(0, 255, 0));
		rdbtnKeyboard.setBounds(SCREEN_WIDTH/14, SCREEN_HEIGHT/2, SCREEN_WIDTH/6, SCREEN_HEIGHT/20);
		rdbtnKeyboard.setOpaque(false);
		add(rdbtnKeyboard);
		
		JRadioButton rdbtnMouse = new JRadioButton("MOUSE");
		rdbtnMouse.setBackground(new Color(102, 102, 102));
		rdbtnMouse.setFont(new Font("Segoe Script", Font.BOLD, SCREEN_WIDTH/50));
		rdbtnMouse.setForeground(new Color(0, 255, 0));
		rdbtnMouse.setBounds(SCREEN_WIDTH/14, 6*(SCREEN_HEIGHT/10), SCREEN_WIDTH/6, SCREEN_HEIGHT/20);
		rdbtnMouse.setOpaque(false);
		add(rdbtnMouse);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnKeyboard);
		group.add(rdbtnMouse);
		
		JComboBox<Font> comboBox = new JComboBox<Font>();
		comboBox.setToolTipText("Colours");
		comboBox.setBounds(4*(SCREEN_WIDTH/5), 2*(SCREEN_HEIGHT/5), SCREEN_WIDTH/7, SCREEN_HEIGHT/25);
		add(comboBox);
		
		JButton btn = new JButton("Main Menu");
		btn.setForeground(new Color(255, 0, 0));
		btn.setFont(new Font("TEN O CLOCK", Font.PLAIN, SCREEN_WIDTH/40));
		btn.setBackground(new Color(102, 102, 102));
		btn.setBounds(SCREEN_WIDTH-250, SCREEN_HEIGHT-100, SCREEN_WIDTH/6, SCREEN_HEIGHT/15);
		btn.setOpaque(false);
		add(btn);
		
		JLabel background = new JLabel("");
		background.setBackground(new Color(255, 255, 255));
		background.setForeground(new Color(255, 255, 255));
		background.setIcon(image);
		background.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		add(background);
		
		btn.addActionListener(new OptionsController(this));


	}
}
