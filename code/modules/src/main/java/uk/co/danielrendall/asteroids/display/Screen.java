package uk.co.danielrendall.asteroids.display;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

import uk.co.danielrendall.asteroids.game.*;
import uk.co.danielrendall.mathlib.geom2d.Line;
import uk.co.danielrendall.mathlib.geom2d.Point;

import java.util.*;
import java.util.List;

public final class Screen extends JFrame {

    private Point last;

    public Screen() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setUndecorated(true);
        this.setSize(Engine.SCREEN_X, Engine.SCREEN_Y);
        this.setVisible(true);

        this.createBufferStrategy(2);
        last = Point.ORIGIN;
    }

    public void draw(Game game) {

        BufferStrategy bf = this.getBufferStrategy();
        Graphics g = null;

        try {
            g = bf.getDrawGraphics();

            g.setColor(Color.BLACK);
            g.fillRect(0, 0, Engine.SCREEN_X, Engine.SCREEN_Y);

            List<Command> commands = game.getDrawCommands();

            for (Command command: commands) {
                last = command.accept(g, last);
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
