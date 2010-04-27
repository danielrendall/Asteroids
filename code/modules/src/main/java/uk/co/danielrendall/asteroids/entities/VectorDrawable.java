package uk.co.danielrendall.asteroids.entities;

import uk.co.danielrendall.asteroids.display.Engine;
import uk.co.danielrendall.mathlib.geom2d.Line;
import uk.co.danielrendall.mathlib.geom2d.Vec;

import java.awt.Color;
import java.util.List;


public interface VectorDrawable {

    public final static Vec SCREEN_SHIFT_X = new Vec((double) Engine.SCREEN_X, 0.0d);
    public final static Vec SCREEN_SHIFT_Y = new Vec(0.0d, (double) Engine.SCREEN_Y);
    public final static Vec SCREEN_SHIFT_MINUS_X = SCREEN_SHIFT_X.neg();
    public final static Vec SCREEN_SHIFT_MINUS_Y = SCREEN_SHIFT_Y.neg();

    public Color getColor();

    public List<Line> getLines();

    public void update();
}
