import java.awt.FlowLayout;
import java.awt.event.*;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;

public class ClockTester {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		
		final MoveableShape shape= new ClockMovable(0,0,100);
		ClockIcon icon= new ClockIcon(shape,200,200);
		
		final int width_frame = 200;
		final int height_frame = 200;

		frame.setSize(width_frame, height_frame);
		frame.setLayout(new FlowLayout());
		
		
		final JLabel label = new JLabel(icon);
	      frame.setLayout(new FlowLayout());
	      frame.add(label);
		
	      	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
	      
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				GregorianCalendar calendar= (GregorianCalendar ) Calendar.getInstance();
				shape.translate(calendar.get(Calendar.SECOND),calendar.get(Calendar.MINUTE),calendar.get(Calendar.HOUR));
				label.repaint();
			}
		};
		
		final int DELAY = 1000;
		// Milliseconds between timer ticks
		Timer t = new Timer(DELAY, listener);
		t.start();
		
	}

}
