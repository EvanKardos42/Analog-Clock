import java.awt.*;

/**
   A shape that can be moved around.
*/
public interface MoveableShape
{
   /**
      Draws the shape.
      @param g2 the graphics context
   */
   void draw(Graphics2D g2);
   /**
      Moves the clock hands to the current time
   */
   void translate(int second, int minutes, int hour);
}
