/**
 * 
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.jbox2d.common.Vec2;

import model.MainBall;

/**
 * @author bilal revised by furkan
 *
 */
public class BallController implements MouseListener {
	
	private MainBall mb;
	
	public BallController(MainBall mb) {
		this.mb = mb;
	}
	
	// Apply force to ball by clicking it with mouse
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		
		//Determine which way to apply force
		if(mb.isSelected(e.getLocationOnScreen())){
			
			if(e.getButton() == MouseEvent.BUTTON1)
			{
				mb.body.applyForceToCenter(new Vec2(1000, 0));
			}
			if(e.getButton() == MouseEvent.BUTTON3)
			{
				mb.body.applyForceToCenter(new Vec2(-1000, 0));
			}

		}
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	


}
