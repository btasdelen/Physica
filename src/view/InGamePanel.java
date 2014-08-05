/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.Timer;

import stages.Stage;
import controller.DrawController;
import controller.InGameController;
import controller.KeyboardController;
import controller.LauncherController;
import controller.SidePanelController;
import controller.WonController;
import model.GameObject;

/**
 * @author bilal revised by furkan
 * 
 */
@SuppressWarnings("serial")
public class InGamePanel extends JPanel {
	

	private Timer time;

	private final Image backgroundImage = javax.imageio.ImageIO.read(new File("backgrounds/back.jpg"));
    
	private final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	private final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	private WonController wc = new WonController(new WonView());
	private InGameSidePanel panel = new InGameSidePanel();
	private InGameMenuButton button = new InGameMenuButton();
	private InGameMenu igm = new InGameMenu(this);
	private TimeLabelView timeLabel = new TimeLabelView();
	private Stage st;
	private SidePanelController sideController = new SidePanelController( panel);
	private RectangularShape shp;
	private LauncherController lc;
	DrawController dc;
		
	public InGamePanel(Stage st) throws Exception{
		this.st = st;
		setLayout(null);
		
		//set component positions and sizes on screen with respect to screen sizes
		Dimension size = panel.getPreferredSize();
		panel.setBounds(-9 , ( SCREEN_HEIGHT - size.height)/2,
		             size.width, size.height);
		
		size = button.getPreferredSize();
		button.setBounds(SCREEN_WIDTH - 100 , SCREEN_HEIGHT -100,
		             size.width, size.height);
		
		size = igm.getPreferredSize();
		igm.setBounds((SCREEN_WIDTH - size.width)/2 , (SCREEN_HEIGHT - size.height)/2, size.width, size.height );
		
		size = timeLabel.getPreferredSize();
		timeLabel.setBounds(SCREEN_WIDTH - 160 , 50, size.width, size.height );
		
		
		//add listeners and components
		button.addActionListener(this, igm);
		
		addMouseListener(new controller.BallController(st.getMainBall()));


		add(panel);
		add(button);
		add(timeLabel);
		dc = new DrawController(st, new DrawObject(sideController, st, this), this);
		addMouseListener(dc);

		addMouseMotionListener( dc);

		addKeyListener(new KeyboardController(st.getMainBall()));

		setFocusable(true);
		requestFocusInWindow();

		//set timer and start
		time = new Timer(5, new InGameController( this, st));
		time.start();

	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//render background image and finish flag

		g.drawImage(backgroundImage, 0, 0, null);
		g.drawImage(st.getFlag().getTexture(), (int)GameObject.boxToSwingX((st.getFlag().getPos()).x), 
				(int)GameObject.boxToSwingY((st.getFlag().getPos()).y), null);
		
		//if stage has launcher, draw it
		if (st.haveLauncher() != null)
			g.drawImage(st.haveLauncher().getTexture(), (int)GameObject.boxToSwingX((st.haveLauncher().getPos()).x), 
					(int)GameObject.boxToSwingY((st.haveLauncher().getPos()).y), null);

		//for quality
		Graphics2D g2 = ((Graphics2D) g);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		          RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING,
		          RenderingHints.VALUE_RENDER_QUALITY);
		
		//fill every object by using their properties
		for (GameObject obj: st.getWorldController().getObjects()) {
			g2.setPaint(obj.getColour());
			g2.fill(obj.gShape());
		}
		
		//for drawing object
		if (shp != null) {
			g2.setPaint(Color.RED);
			g2.fill(shp);
		}
		
	}
	
	public Stage getStage() {
		return st;
	}
	
	//pauses the game by pausing mechanism
	public void pause() {
		time.stop();
		panel.pause();
		button.setEnabled(false);
		dc.pause();
		timeLabel.pause();
	}
	
	//resumes the game by resuming mechanism

	public void resume() {
		time.start();
		panel.resume();
		button.setEnabled(true);
		timeLabel.resume();
		dc.resume();
		repaint();
	}
	
	public void won() {
		wc.won(this);
	}
	
	//show if user drawing
	public void showRectangle(int x, int y, int w, int h) {
		shp = new Rectangle2D.Float(x, y, w, h);
	}
	
	public void showCircle(int x, int y, int radius) {
		shp = new Ellipse2D.Float(x, y, radius, radius);
		
	}
	
	public void setShowNull() {
		shp = null;
		
	}
	
	//destroy the world
	public void destroyWorld() {
		st.destroyWorld();
	}
	
	//trigger the launcher mechanism
	public void launch() {
		lc = new LauncherController(this, st.getMainBall());
		addMouseListener(lc);

	}


	
	



}
