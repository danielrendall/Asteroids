package uk.co.danielrendall.asteroids.display;

import uk.co.danielrendall.mathlib.geom2d.Point;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: daniel
 * Date: 30-Apr-2010
 * Time: 08:15:55
 * To change this template use File | Settings | File Templates.
 */
public class LineToCommand extends AbstractMovementCommand {

    public LineToCommand(Point to) {
        super(to);
    }

    public Point accept(Graphics g, Point last) {
        g.drawLine((int) last.x(), (int)last.y(), (int)to.x(), (int)to.y());
        return to;
    }
}
