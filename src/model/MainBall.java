/**
 * 
 */
package model;

import java.awt.Color;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyType;

/**
 * @author bilal
 *
 */
public class MainBall extends Circle implements Controllable {

	private final static int RADIUS = 30; 
	
	private final static Color COLOUR = Color.RED;
	
	public MainBall(Vec2 p) {
		super(p, RADIUS, COLOUR, BodyType.DYNAMIC);
		radius = RADIUS;
		pos = p;
		isMain = true;

	}


	
	public TexturePaint getTexture() { 
		try {
			return new TexturePaint(ImageIO.read(new File("ball.png")), new Rectangle2D.Float(0, 0, 90, 60));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
