package uk.co.danielrendall.asteroids.entities;

import uk.co.danielrendall.asteroids.display.Engine;
import uk.co.danielrendall.asteroids.entities.Shape;
import uk.co.danielrendall.mathlib.geom2d.Point;
import uk.co.danielrendall.mathlib.geom2d.Vec;

import java.awt.*;
import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User: daniel
 * Date: 28-Apr-2010
 * Time: 23:28:31
 * To change this template use File | Settings | File Templates.
 */
public interface Entity {

    public final static Vec SCREEN_SHIFT_X = new Vec((double) Engine.SCREEN_X, 0.0d);
    public final static Vec SCREEN_SHIFT_Y = new Vec(0.0d, (double) Engine.SCREEN_Y);
    public final static Vec SCREEN_SHIFT_MINUS_X = SCREEN_SHIFT_X.neg();
    public final static Vec SCREEN_SHIFT_MINUS_Y = SCREEN_SHIFT_Y.neg();

    public Point getLocation();

    public Vec getVelocity();

    public Vec getAcceleration();

    // -PI <= orientation < PI, 0 = to the right
    public double getOrientation();

    // radians / unit time
    public double getAngularVelocity();

    public Color getColor();

    public void update();

    public void setColor(Color color);
    public void setRepresentation(Shape shape);

    public Drawable[] getDrawables();

}
