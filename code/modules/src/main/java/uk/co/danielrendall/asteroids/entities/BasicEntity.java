package uk.co.danielrendall.asteroids.entities;

import uk.co.danielrendall.asteroids.display.Engine;
import uk.co.danielrendall.asteroids.entities.Shape;
import uk.co.danielrendall.mathlib.geom2d.Point;
import uk.co.danielrendall.mathlib.geom2d.Vec;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: daniel
 * Date: 28-Apr-2010
 * Time: 23:32:07
 * To change this template use File | Settings | File Templates.
 */
public class BasicEntity implements Entity {

    protected Point location;
    protected Vec velocity;
    protected Vec acceleration;
    protected double orientation;
    protected double angularVelocity;

    protected Shape representation;
    private Color color;

    protected BasicEntity(Point location) {
        this(location, Vec.ZERO);
    }

    protected BasicEntity(Point location, Vec velocity) {
        this(location, velocity, Vec.ZERO);
    }

    protected BasicEntity(Point location, Vec velocity, Vec acceleration) {
        this(location, velocity, acceleration, 0.0d);
    }

    public BasicEntity(Point location, Vec velocity, Vec acceleration, double orientation) {
        this(location, velocity, acceleration, orientation, 0.0d);
    }

    protected BasicEntity(Point location, Vec velocity, Vec acceleration, double orientation, double angularVelocity) {
        this.location = location;
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.orientation = orientation;
        this.angularVelocity = angularVelocity;
    }

    public Point getLocation() {
        return location;
    }

    public Vec getVelocity() {
        return velocity;
    }

    public Vec getAcceleration() {
        return acceleration;
    }

    public double getOrientation() {
        return orientation;
    }

    public double getAngularVelocity() {
        return angularVelocity;
    }

    public void update() {
        location = location.displace(velocity);
        if (location.x() >= Engine.SCREEN_X) {
            location = location.displace(SCREEN_SHIFT_MINUS_X);
        } else if (location.x() < 0.0d) {
            location = location.displace(SCREEN_SHIFT_X);
        }
        if (location.y() >= Engine.SCREEN_Y) {
            location = location.displace(SCREEN_SHIFT_MINUS_Y);
        } else if (location.y() < 0.0d) {
            location = location.displace(SCREEN_SHIFT_Y);
        }

        orientation += angularVelocity;
        if (orientation >= Shape.TWO_PI) {
            orientation -= Shape.TWO_PI;
        } else if (orientation < 0.0d) {
            orientation += Shape.TWO_PI;
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setRepresentation(Shape shape) {
        this.representation = shape;
    }

    public Drawable[] getDrawables() {
        return representation.getDrawables(Engine.BOUNDS, this);
    }
}
