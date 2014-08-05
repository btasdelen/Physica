/**
 * 
 */
package model;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

import org.jbox2d.common.Vec2;

/**
 * @author bilal
 *
 */
public class FinishFlag extends GameObject {


	private final Image img = ImageIO.read(new File("backgrounds/flag.png"));
	
	public FinishFlag(Vec2 p) throws Exception {
		super(p, null, null);
		// TODO Auto-generated constructor stub
	}
	
	public Image getTexture() {
		return img;
	}
	
	public boolean isFinished(Vec2 p) {
		//if main ball's position overlap with flag's area decide to finish the stage
		if ((p.x >= pos.x && p.x <= pos.x + swingToBoxWidth(160)) && (p.y <= pos.y && p.y >= pos.y - swingToBoxHeight(160)))
			return true;
		return false;
	}
	


}
