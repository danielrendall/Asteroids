package uk.co.danielrendall.asteroids.entities;

import uk.co.danielrendall.mathlib.geom2d.BoundingBox;
import uk.co.danielrendall.mathlib.geom2d.Line;

/**
 * Created by IntelliJ IDEA.
 * User: daniel
 * Date: 29-Apr-2010
 * Time: 08:11:43
 * To change this template use File | Settings | File Templates.
 */
public interface Drawable {
    Line[] getLines();

    BoundingBox getBoundingBox();
}
