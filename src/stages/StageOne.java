/**
 * 
 */
package stages;

import java.awt.Color;

import model.Circle;
import model.Rectangle;
import model.StaticRect;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyType;

import controller.WorldController;

/**
 * @author bilal
 *
 */
public class StageOne extends Stage {
	


	private StaticRect rect;
	private Rectangle rect2;
	private StaticRect rect3;

	private Circle cr;
	

	public StageOne() {
		super(new Vec2(25, 70));
		
		//setMainBallPos();
		addMainBall();

		ff.setPos(new Vec2(95 ,56.5f));


		cr = new Circle(new Vec2(55, 50), 30, Color.CYAN, BodyType.STATIC);
		rect = new StaticRect(new Vec2(25, 50), 600, 15, Color.GRAY);
		rect3= new StaticRect(new Vec2(85, 50), 600, 15, Color.GRAY);

		rect2 = new Rectangle(new Vec2(54, 51), 600, 5, Color.GREEN, BodyType.DYNAMIC);

		WorldController.addObject(cr);
		WorldController.addObject(rect);
		WorldController.addObject(rect2);
		WorldController.addObject(rect3);






	}
	


}
