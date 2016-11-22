import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.*;

import javax.sound.sampled.Line;
import javax.swing.Icon;

public class ClockIcon implements Icon {
	private final int w;
	private final int h;
	private MoveableShape shape;

	/**
	 * creates the ClockIcon object
	 * 
	 * @param shape
	 * @param width
	 * @param height
	 */
	public ClockIcon(MoveableShape shape, int width, int height) {
		this.shape = shape;
		this.w = width;
		this.h = height;
	}

	/**
	 * paints the movable shape that the ClockIcon has
	 * 
	 * @param c
	 * @param g
	 * @param x
	 * @param y
	 */

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		shape.draw(g2);
	}

	/**
	 * returns the width of the icon
	 * 
	 * @return w
	 */
	@Override
	public int getIconWidth() {
		return w;
	}

	/**
	 * returns the height of the icon
	 * 
	 * @return h
	 */
	@Override
	public int getIconHeight() {
		return h;
	}

}
