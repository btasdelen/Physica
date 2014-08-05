/**
 * 
 */
package model;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;


/**
 * @author bilal
 *
 */
public class Circle extends GameObject implements Drawable {
    
    
    protected float radius;
    protected static CircleShape cs;
    	
    public Circle(Vec2 p, float radius, Color color, BodyType t){
    	super(p , color, t);
    	this.radius = radius;
    	cs = new CircleShape();
        cs.m_radius = swingToBoxRadius(radius);  //We need to convert radius to JBox2D equivalent
    	bd.type = t;
        bd.position.set(pos.x, pos.y);
        
        //Set the fixture for circle
        FixtureDef fd = new FixtureDef();
        fd.shape = cs;
        fd.restitution = 0.6f;
        fd.friction = 0.9f;
        fd.density = 0.8f;
        body = WorldPhysica.createBody(bd);
		body.createFixture(fd);
        
   
    }

	@Override
	public boolean isSelected(Point p) {
		//check a point so if it is in the area of circle
		if (Math.sqrt(Math.pow(p.getX() - boxToSwingX(pos.x), 2) + Math.pow(p.getY()-boxToSwingY(pos.y), 2)) <= radius)
			return true;
		return false;
		
	}
    
    @Override
    public Shape getShape() {
    	return new CircleShape();
    }

	@Override
	public Ellipse2D gShape(){
		//this is the shape that will be drawn
		return new Ellipse2D.Float(boxToSwingX(pos.x-swingToBoxRadius(radius)),boxToSwingY(pos.y+swingToBoxRadius(radius)), radius*2, radius*2 );
		
	}
	
}
