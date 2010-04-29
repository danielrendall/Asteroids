package uk.co.danielrendall.asteroids.entities;

import uk.co.danielrendall.asteroids.display.Engine;
import uk.co.danielrendall.asteroids.entities.Entity;
import uk.co.danielrendall.asteroids.entities.Drawable;
import uk.co.danielrendall.mathlib.geom2d.BoundingBox;
import uk.co.danielrendall.mathlib.geom2d.Vec;


public interface Shape {

    public static final double TWO_PI = 2 * Math.PI;

    Drawable[] getDrawables(BoundingBox limits, Entity entity);
}
