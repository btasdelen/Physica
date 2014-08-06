/**
 * 
 */
package model;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyType;

/**
 * @author bilal
 *
 */
public class Rectangle extends GameObject {
	
	
	protected float width;
	
	protected float length;
	
	protected PolygonShape rs;
	
	
	public Rectangle(Vec2 p, float w, float l, Color colour, BodyType t) {
		super(p, colour, t);
		
		width = w;
		length = l;
		rs = new PolygonShape();
		rs.setAsBox(swingToBoxWidth(width), swingToBoxHeight(length));
		bd.type = t;
        bd.position.set(pos.x, pos.y);
        body = WorldPhysica.getWorld().createBody(bd);
        //create fixture
        fd.shape = rs;
        fd.density = 1f;
        fd.friction = 0.6f;
        fd.restitution = .2f;
		body.createFixture(fd);
	}
	
	@Override
	public Shape getShape() {
		return new PolygonShape();
	}
	

	
	public boolean isSelected(Point p) {
		//if selected return true
		if (p.x <= pos.x + width && p.y <= pos.y + length )
			return true;
		return false;
	}
	
	
	@Override
	public java.awt.Shape gShape() {
		//Rectangle's angle matters. So we creating shape by transforming it
		shape = new Rectangle2D.Float(boxToSwingX(pos.x-swingToBoxWidth(width)), boxToSwingY(pos.y+swingToBoxHeight(length)), width, length);
		AffineTransform at = new AffineTransform();
        at.rotate(-getAngle(), boxToSwingX(pos.x-swingToBoxWidth(width))+width/2, boxToSwingY(pos.y+swingToBoxHeight(length))+length/2);
        shape = at.createTransformedShape(shape);
		return shape;
	}
	

}
