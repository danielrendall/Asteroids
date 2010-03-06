package uk.co.danielrendall.asteroids.display;
import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import uk.co.danielrendall.asteroids.game.*;
import java.util.*;

public final class Screen extends JFrame {

	public Screen() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setUndecorated(true);
		this.setSize(Engine.SCREEN_X, Engine.SCREEN_Y);
		this.setVisible(true);

		this.createBufferStrategy(2);
	}

   public void draw(Game game) {

		BufferStrategy bf = this.getBufferStrategy();
	Graphics g = null;

	try {
		g = bf.getDrawGraphics();

		Map<Color, SortedSet<Line>> lineMap = new HashMap<Color, SortedSet<Line>>();

		// It is assumed that mySprite is created somewhere else.
		// This is just an example for passing off the Graphics object.
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Engine.SCREEN_X, Engine.SCREEN_Y);

		game.addLines(lineMap);

		for (Color color: lineMap.keySet()) {
		   SortedSet<Line> lines = lineMap.get(color);
		   int lastX = 0;
		   int lastY = 0;
		   for (Line line : lines) {
		      g.setColor(color.darker().darker().darker().darker());
		      g.drawLine(lastX, lastY, line.getX1(), line.getY1());
			   g.setColor(color);
		    	g.drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
		    	lastX = line.getX2();
		    	lastY = line.getY2();
		   }
		}
	} catch (Exception e) {
	   e.printStackTrace();
	} finally {
		// It is best to dispose() a Graphics object when done with it.
		if (g != null) {
			g.dispose();
		}
	}

	// Shows the contents of the backbuffer on the screen.
		bf.show();

        //Tell the System to do the Drawing now, otherwise it can take a few extra ms until
        //Drawing is done which looks very jerky
        Toolkit.getDefaultToolkit().sync();
	}
}
