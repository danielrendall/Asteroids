package uk.co.danielrendall.asteroids.display;

import uk.co.danielrendall.mathlib.geom2d.Point;

import java.awt.*;


/**
 * Created by IntelliJ IDEA.
 * User: daniel
 * Date: 29-Apr-2010
 * Time: 23:01:30
 * To change this template use File | Settings | File Templates.
 */
public class MoveToCommand extends AbstractMovementCommand {

    private final Color endColor;

    public MoveToCommand(Point to) {
        this(to, null);
    }

    public MoveToCommand(Point to, Color endColor) {
        super(to);
        this.endColor = endColor;
    }

    public Point accept(Graphics g, Point last) {
        // ignore endColor for purposes of drawing a line
        Color current = g.getColor();
        g.setColor(current.darker().darker().darker().darker());
        g.drawLine((int) last.x(), (int)last.y(), (int)to.x(), (int)to.y());
        g.setColor(endColor != null ? endColor : current);
        return to;
    }
}
