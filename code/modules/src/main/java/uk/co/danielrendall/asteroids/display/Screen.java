package uk.co.danielrendall.asteroids.display;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

import uk.co.danielrendall.asteroids.game.*;
import uk.co.danielrendall.mathlib.geom2d.Line;
import uk.co.danielrendall.mathlib.geom2d.Point;

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

            g.setColor(Color.BLACK);
            g.fillRect(0, 0, Engine.SCREEN_X, Engine.SCREEN_Y);

            game.addLines(lineMap);

            for (Color color : lineMap.keySet()) {
                SortedSet<Line> lines = lineMap.get(color);
                Point last = new Point(0.0d, 0.0d);
                for (Line line : lines) {
                    Point start = line.getStart();
                    Point end = line.getEnd();
                    g.setColor(color.darker().darker().darker().darker());
                    g.drawLine((int) last.x(), (int)last.y(), (int)start.x(), (int)start.y());
                    g.setColor(color);
                    g.drawLine((int)start.x(), (int)start.y(), (int)end.x(), (int)end.y());
                    last = end;
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
