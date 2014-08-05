package view;

import java.awt.Color;
import java.awt.Point;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyType;

import model.Circle;
import model.GameObject;
import model.Rectangle;
import stages.Stage;
import controller.SidePanelController;
import controller.WorldController;

/**
 * @author furkan revised by Bilal
 *
 */

public class DrawObject 
{
	private SidePanelController sideControl;
	private Stage test;
	private InGamePanel igp;

	public DrawObject( SidePanelController sideControl, Stage test, InGamePanel igp)
	{
		this.sideControl = sideControl;
		this.test = test;
		this.igp = igp;
	}
	
	public void draw( Point p1, Point p2)
	{
		if( (sideControl).getSelected() == 0)
		{
			drawCircle( p1, p2);
		}
		
		if( sideControl.getSelected() == 1)
		{
			drawRectangle( p1, p2);
		}
		//sideControl.setSelected(-1); 
	}
	public void drawCircle( Point p1, Point p2)
	{
		float radius = (float) p1.distance(p2);
		float pX = GameObject.swingToBoxX(Math.min(p1.x, p2.x)+radius/2);
		float pY = GameObject.swingToBoxY(Math.min(p1.y, p2.y)+radius/2);
		test.getWorldController();
		WorldController.addObject( new Circle(new Vec2(pX, pY), radius/2, Color.BLUE, BodyType.DYNAMIC));
	}
	
	public void drawRectangle( Point p1, Point p2)
	{
		float width = Math.abs(p1.x - p2.x);
		float height = Math.abs(p1.y - p2.y);
		float pX = GameObject.swingToBoxX(Math.min(p1.x, p2.x) + width/2);
		float pY = GameObject.swingToBoxY(Math.min(p1.y, p2.y) + height/2);
		test.getWorldController();
		WorldController.addObject( new Rectangle(new Vec2(pX, pY), width, height, Color.GREEN, BodyType.DYNAMIC));
	}
	
	public void show(Point p1, Point p2) {
		if( (sideControl).getSelected() == 0)
		{
			igp.showCircle( Math.min(p1.x, p2.x), Math.min(p1.y, p2.y), (int) p1.distance(p2));
		}
		
		if( sideControl.getSelected() == 1)
		{
			igp.showRectangle( Math.min(p1.x, p2.x), Math.min(p1.y, p2.y), Math.abs(p1.x - p2.x), Math.abs(p1.y - p2.y));
		}
	}
	

}
