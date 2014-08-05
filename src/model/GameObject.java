/**
 * 
 */
package model;

import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;

import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

/**
 * @author bilal
 *
 */

public class GameObject implements Drawable, Controllable{
	
	
	protected boolean isMain;
	protected Vec2 pos;
	protected float angle;
    protected Color colour;
    protected BodyType type;
    protected BodyDef bd = new BodyDef();
    public Body body;
    protected final static int RATIO = Toolkit.getDefaultToolkit().getScreenSize().width;
    protected final static int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    protected final static int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    protected java.awt.Shape shape;
    protected FixtureDef fd = new FixtureDef();
    
    public GameObject(Vec2 p, Color colour, BodyType t) {
    	isMain = false;
    	pos = p;
    	this.colour = colour;
    	angle = 0;

    }
    
    public BodyDef getBodyDef() {
    	return bd;
    }
    
    public void setPos(Vec2 p) {
    	pos.set(p.x, p.y);
    }
    
    public void rotate(float ang) {
    	angle = ang;
    }
    
    public java.awt.Shape rotateShape() {return null;}
    
    public float getAngle() {
    	return angle;
    }
    
    public Vec2 getPos() {
    	return pos;
    }
    
    public boolean isSelected(Point p) {
		return true;
	}
    
    public boolean isInside() {
		if ((pos.x < SCREEN_WIDTH && pos.x > 0) && (pos.y < SCREEN_HEIGHT && pos.y > 0))
			return true;
		return false;
    	
    }
    
    public boolean isMain() {
    	return isMain;
    }
 
    
    public Shape getShape() {return null;}


	public java.awt.Shape gShape(){
		return null;
	}
	
	public Color getColour() {
		return colour;
	}
	
	//Convert a JBox2D x coordinate to a swing pixel x coordinate
	public static float boxToSwingX(float posX) {
	    float x = RATIO*posX / 100.0f;
	    return x;
	}
	 
	//Convert a swing pixel x coordinate to a JBox2D x coordinate
	public static float swingToBoxX(float posX) {
	    float x =   (posX*100.0f*1.0f)/RATIO;
	    return x;
	}
	 
	//Convert a JBox2D y coordinate to a swing pixel y coordinate
	public static float boxToSwingY(float posY) {
	    float y = RATIO - 1.0f*RATIO * posY / 100.0f;
	    return y;
	}
	 
	//Convert a swing pixel y coordinate to a JBox2D y coordinate
	public static float swingToBoxY(float posY) {
	    float y = 100.0f - ((posY * 100*1.0f) /RATIO) ;
	    return y;
	}
	 
	//Convert a pixel width to JBox2D width
	public static float swingToBoxWidth(float width) {
	    return 100f*width / (RATIO*2);
	}
	 
	//Convert a pixel height to JBox2D height
	public static float swingToBoxHeight(float height) {
	    return 100.f*height/(RATIO*2);
	}
	
	//Convert a pixel radius to JBox2D radius
	public static float swingToBoxRadius(float radius) {
		return 100.f*radius/(RATIO);
	}


}
