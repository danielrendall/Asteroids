package uk.co.danielrendall.asteroids.display;

import uk.co.danielrendall.mathlib.geom2d.Point;

/**
 * Created by IntelliJ IDEA.
 * User: daniel
 * Date: 30-Apr-2010
 * Time: 08:11:15
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractMovementCommand implements Command {

    protected final Point to;

    public AbstractMovementCommand(Point to) {
        this.to = to;
    }
}
