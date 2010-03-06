package uk.co.danielrendall.asteroids.entities;
import java.awt.Color;
import java.util.List;
import uk.co.danielrendall.asteroids.display.*;

public interface VectorDrawable {

   public Color getColor();
   public List<Line> getLines();
   public void update();
}
