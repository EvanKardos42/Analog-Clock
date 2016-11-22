import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ClockMovable implements MoveableShape {

	int x, y, r;
	private Point2D.Double center;
	private Point2D.Double secondEndPoint = new Point2D.Double(0, 0);
	private Point2D.Double minuteEndPoint = new Point2D.Double(0, 0);
	private Point2D.Double hourEndPoint = new Point2D.Double(0, 0);

	public ClockMovable(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.r = radius;
		this.center = new Point2D.Double((x + r), (y + r));
		this.init();
	}

	/**
	 * initiates the clock to the current time.
	 */
	public void init() {
		GregorianCalendar c = (GregorianCalendar) Calendar.getInstance();
		int second = c.get(Calendar.SECOND);
		int minute = c.get(Calendar.MINUTE);
		int hour = c.get(Calendar.HOUR);

		int xsecond = (int) ((Math.cos(second * 3.14f / 30 - 3.14f / 2) * r) + r);
		int ysecond = (int) ((Math.sin(second * 3.14f / 30 - 3.14f / 2) * r) + r);
		secondEndPoint.x = xsecond;
		secondEndPoint.y = ysecond;

		int xminute = (int) (Math.cos(minute * 3.14f / 30 - 3.14f / 2) * (r*0.75) + r);
		int yminute = (int) (Math.sin(minute * 3.14f / 30 - 3.14f / 2) * (r*0.75) + r);
		minuteEndPoint.x = xminute;
		minuteEndPoint.y = yminute;

		int xhour = (int) (Math.cos((hour * 30) * 3.14f / 180 - 3.14f / 2) * (r*0.5) + r);
		int yhour = (int) (Math.sin((hour * 30) * 3.14f / 180 - 3.14f / 2) * (r*0.5) + r);
		hourEndPoint.x = xhour;
		hourEndPoint.y = yhour;

	}

	/**
	 * draws the clock to the current time every time it is called
	 */
	@Override
	public void draw(Graphics2D g2) {
		Ellipse2D.Double face = new Ellipse2D.Double(x, y, 2 * r, 2 * r);

		Line2D hour = new Line2D.Double(center, hourEndPoint);
		Line2D minute = new Line2D.Double(center, minuteEndPoint);
		Line2D.Double seconds = new Line2D.Double(center, secondEndPoint);
		g2.draw(face);
		g2.draw(hour);
		g2.draw(minute);
		g2.draw(seconds);

	}

	/**
	 * changes the position of the hour second and minute hands to the current
	 * time
	 */
	@Override
	public void translate(int second, int minute, int hour) {

		int xsecond = (int) ((Math.cos(second * 3.14f / 30 - 3.14f / 2) * r) + r);
		int ysecond = (int) ((Math.sin(second * 3.14f / 30 - 3.14f / 2) * r) + r);
		secondEndPoint.x = xsecond;
		secondEndPoint.y = ysecond;

		int xminute = (int) (Math.cos(minute * 3.14f / 30 - 3.14f / 2) * (r*0.75) + r);
		int yminute = (int) (Math.sin(minute * 3.14f / 30 - 3.14f / 2) * (r*0.75) + r);
		minuteEndPoint.x = xminute;
		minuteEndPoint.y = yminute;

		int xhour = (int) (Math.cos((hour * 30) * 3.14f / 180 - 3.14f / 2) * (r*0.5) + r);
		int yhour = (int) (Math.sin((hour * 30) * 3.14f / 180 - 3.14f / 2) * (r*0.5) + r);
		hourEndPoint.x = xhour;
		hourEndPoint.y = yhour;
	}

}
