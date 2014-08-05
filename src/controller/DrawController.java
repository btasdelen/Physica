package controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import stages.Stage;
import view.DrawObject;
import view.InGamePanel;
import model.GameObject;

/**
 * @author furkan revised by bilal
 *
 */

public class DrawController implements MouseListener, MouseMotionListener{
	
	private Stage test;
	private Point p1;
	private Point p2;
	private boolean valid;
	private DrawObject drawer;
	private InGamePanel panel;
	private boolean isPaused;
	
	public DrawController(Stage test, DrawObject drawer, InGamePanel panel)
	{
		this.test = test;
		this.drawer = drawer;
		this.panel = panel;
		valid = false;
		isPaused = false;
	}
	
	// Takes first point
	@Override
	public void mousePressed(MouseEvent e) 
	{
		valid = false;
		boolean isOut = true;
		Point pressed = e.getLocationOnScreen();
		ArrayList<GameObject> objects = test.getWorldController().getObjects();
		 
		// is clicked on another object
		for(int i = 0; i < objects.size() && isOut; i++)
		{
			if( objects.get(i).isSelected(pressed))
			{
				isOut = false;
			}
		}
		
		// holds the point if it is proper one
		if( isOut && !isPaused)
		{
			valid = true;
			p1 = pressed;
		}
	}

	// takes second point
	@Override
	public void mouseReleased(MouseEvent e) 
	{
		
		//if not overlapping and not
		Point pressed = e.getLocationOnScreen();
		if( valid && (!p1.equals(pressed)) && !isPaused)
		{
			p2 = pressed;
			drawer.draw(p1, p2);

		}
		
		panel.setShowNull();
		panel.repaint();
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point pressed = e.getLocationOnScreen();
		if( valid && (!p1.equals(pressed)))
		{
			p2 = pressed;
			drawer.show(p1, pressed);

		}

		panel.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void pause() {
		isPaused = true;
	}
	
	public void resume() {
		isPaused = false;
	}
	
}
