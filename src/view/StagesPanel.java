
// Stages Panel
// Author Muhammet �im�ek




package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import controller.StagesController;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class StagesPanel extends JPanel {

	private final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	private final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	
	public StagesPanel() {
		setLayout(null);
		
		ImageIcon img = new ImageIcon("backgrounds/stagesmenu.jpg");
		Image original = img.getImage();
		ImageIcon image =  new ImageIcon(original.getScaledInstance(SCREEN_WIDTH, SCREEN_HEIGHT, Image.SCALE_FAST));
		
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		
		JButton btn1 = new JButton("1");
		btn1.setBackground(new Color(153, 0, 0));
		btn1.setFont(new Font("TEN O CLOCK", Font.PLAIN, SCREEN_WIDTH/28));
		btn1.setForeground(new Color(0, 0, 0));
		btn1.setBounds(SCREEN_WIDTH/15, 2*(SCREEN_HEIGHT/7), SCREEN_WIDTH/11, SCREEN_HEIGHT/10);
		btn1.setOpaque(true);
		add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setForeground(new Color(0, 0, 0));
		btn2.setBackground(new Color(153, 0, 0));
		btn2.setFont(new Font("TEN O CLOCK", Font.PLAIN, SCREEN_WIDTH/28));
		btn2.setBounds(4*(SCREEN_WIDTH/15),2*(SCREEN_HEIGHT/7), SCREEN_WIDTH/11, SCREEN_HEIGHT/10);
		btn2.setOpaque(true);
		add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setForeground(new Color(0, 0, 0));
		btn3.setBackground(new Color(153, 0, 0));
		btn3.setFont(new Font("TEN O CLOCK", Font.PLAIN, SCREEN_WIDTH/28));
		btn3.setBounds(7*(SCREEN_WIDTH/15), 2*(SCREEN_HEIGHT/7), SCREEN_WIDTH/11, SCREEN_HEIGHT/10);
		btn3.setOpaque(true);
		add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.setForeground(new Color(0, 0, 0));
		btn4.setBackground(new Color(153, 0, 0));
		btn4.setFont(new Font("TEN O CLOCK", Font.PLAIN, SCREEN_WIDTH/28));
		btn4.setBounds(10*(SCREEN_WIDTH/15), 2*(SCREEN_HEIGHT/7), SCREEN_WIDTH/11, SCREEN_HEIGHT/10);
		btn4.setOpaque(true);
		add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setForeground(new Color(0, 0, 0));
		btn5.setBackground(new Color(153, 0, 0));
		btn5.setFont(new Font("TEN O CLOCK", Font.PLAIN, SCREEN_WIDTH/28));
		btn5.setBounds(13*(SCREEN_WIDTH/15), 2*(SCREEN_HEIGHT/7), SCREEN_WIDTH/11, SCREEN_HEIGHT/10);
		btn5.setOpaque(true);
		add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setForeground(new Color(0, 0, 0));
		btn6.setBackground(new Color(153, 0, 0));
		btn6.setFont(new Font("TEN O CLOCK", Font.PLAIN, SCREEN_WIDTH/28));
		btn6.setBounds(SCREEN_WIDTH/15, 4*(SCREEN_HEIGHT/7), SCREEN_WIDTH/11, SCREEN_HEIGHT/10);
		btn6.setOpaque(true);
		add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.setForeground(new Color(0, 0, 0));
		btn7.setBackground(new Color(153, 0, 0));
		btn7.setFont(new Font("TEN O CLOCK", Font.PLAIN, SCREEN_WIDTH/28));
		btn7.setBounds(4*(SCREEN_WIDTH/15), 4*(SCREEN_HEIGHT/7), SCREEN_WIDTH/11, SCREEN_HEIGHT/10);
		btn7.setOpaque(true);
		add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setForeground(new Color(0, 0, 0));
		btn8.setBackground(new Color(153, 0, 0));
		btn8.setFont(new Font("TEN O CLOCK", Font.PLAIN, SCREEN_WIDTH/28));
		btn8.setBounds(7*(SCREEN_WIDTH/15), 4*(SCREEN_HEIGHT/7), SCREEN_WIDTH/11, SCREEN_HEIGHT/10);
		btn8.setOpaque(true);
		add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setForeground(new Color(0, 0, 0));
		btn9.setBackground(new Color(153, 0, 0));
		btn9.setFont(new Font("TEN O CLOCK", Font.PLAIN, SCREEN_WIDTH/28));
		btn9.setBounds(10*(SCREEN_WIDTH/15), 4*(SCREEN_HEIGHT/7), SCREEN_WIDTH/11, SCREEN_HEIGHT/10);
		btn9.setOpaque(true);
		add(btn9);
		
		JButton btn10 = new JButton("10");
		btn10.setForeground(new Color(0, 0, 0));
		btn10.setBackground(new Color(153, 0, 0));
		btn10.setFont(new Font("TEN O CLOCK", Font.PLAIN, SCREEN_WIDTH/28));
		btn10.setBounds(13*(SCREEN_WIDTH/15), 4*(SCREEN_HEIGHT/7), SCREEN_WIDTH/11, SCREEN_HEIGHT/10);
		btn10.setOpaque(true);
		add(btn10);
		
		JButton btn11 = new JButton("Main Menu");
		btn11.setForeground(new Color(0, 0, 0));
		btn11.setFont(new Font("TEN O CLOCK", Font.PLAIN, SCREEN_WIDTH/40));
		btn11.setBackground(new Color(153, 0, 0));
		btn11.setBounds(SCREEN_WIDTH-250, SCREEN_HEIGHT-100, SCREEN_WIDTH/6, SCREEN_HEIGHT/15);
		btn11.setOpaque(true);
		add(btn11);
		
		JLabel background = new JLabel("");
		background.setIcon(image);
		background.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		add(background);
		
		btn1.addActionListener(new StagesController(this));
		
		btn2.addActionListener(new StagesController(this));

		btn3.addActionListener(new StagesController(this));

		btn4.addActionListener(new StagesController(this));

		btn5.addActionListener(new StagesController(this));

		btn6.addActionListener(new StagesController(this));

		btn7.addActionListener(new StagesController(this));

		btn8.addActionListener(new StagesController(this));

		btn9.addActionListener(new StagesController(this));

		btn10.addActionListener(new StagesController(this));
		
		btn11.addActionListener(new StagesController(this));

		

	}
}
