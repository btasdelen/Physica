package model;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyType;

public class StaticRect extends Rectangle {

	public StaticRect(Vec2 p, float w, float l, Color colour) {
		super(p, w, l, colour, BodyType.STATIC);
		// TODO Auto-generated constructor stub
	}

	@Override
	public java.awt.Shape gShape() {
		return shape = new Rectangle2D.Float(boxToSwingX(pos.x-swingToBoxWidth(width)), boxToSwingY(pos.y+swingToBoxHeight(length)), width, length);
		
	}
}
