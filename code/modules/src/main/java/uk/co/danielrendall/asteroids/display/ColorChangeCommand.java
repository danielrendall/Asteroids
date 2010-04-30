package uk.co.danielrendall.asteroids.display;

import uk.co.danielrendall.mathlib.geom2d.Point;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: daniel
 * Date: 30-Apr-2010
 * Time: 08:19:57
 * To change this template use File | Settings | File Templates.
 */
public class ColorChangeCommand implements Command {

    private final Color endColor;

    public ColorChangeCommand(Color endColor) {
        this.endColor = endColor;
    }

    public Point accept(Graphics g, Point last) {
        g.setColor(endColor);
        return last;
    }
}
