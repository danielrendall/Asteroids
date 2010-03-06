package uk.co.danielrendall.asteroids.entities;
import java.awt.Color;
import java.util.*;
import uk.co.danielrendall.asteroids.display.*;

public final class Asteroid implements VectorDrawable {

   private final Color myColor;
   private final float xPoints[];
   private final float yPoints[];
   private final int numPoints;
   private float xPos;
   private float yPos;

   private float xVel;
   private float yVel;

   public Asteroid(int size, int numPoints, Color color) {
      myColor = color;
		this.numPoints = numPoints;
		double theta = 2 * Math.PI / (double) numPoints;
		xPoints = new float[numPoints];
		yPoints = new float[numPoints];
		for (int i=0; i<numPoints; i++) {
		   double arg = theta * (double)i;
		   xPoints[i] = (float) size * (float) Math.cos(arg) + (float)(Math.random() * 10.0d) - 5.0f;
		   yPoints[i] = (float) size * (float) Math.sin(arg) + (float)(Math.random() * 10.0d) - 5.0f;
		}
		xPos = (float)(Math.random() * (double) Engine.SCREEN_X);
		yPos = (float)(Math.random() * (double) Engine.SCREEN_Y);
		xVel = (float)(Math.random() * 10.0d) - 5.0f;
		yVel = (float)(Math.random() * 10.0d) - 5.0f;
   }

   public Color getColor() {
      return myColor;
   }

   public List<Line> getLines() {
      List<Line> lines = new ArrayList<Line>(numPoints);
      float lastX = xPos + xPoints[numPoints - 1];
      float lastY = yPos + yPoints[numPoints - 1];
      for (int i=0; i<numPoints; i++) {
         float thisX = xPos + xPoints[i];
         float thisY = yPos + yPoints[i];
         lines.add(new Line(lastX, lastY, thisX, thisY));
         lastX = thisX;
         lastY = thisY;
      }
      return lines;
   }

   public void update() {
      xPos += xVel;
      yPos += yVel;
      if (xPos < 0) xPos += Engine.SCREEN_X;
      if (xPos >= Engine.SCREEN_X) xPos -= Engine.SCREEN_X;
      if (yPos < 0) yPos += Engine.SCREEN_Y;
      if (yPos >= Engine.SCREEN_Y) yPos -= Engine.SCREEN_Y;
   }
}
