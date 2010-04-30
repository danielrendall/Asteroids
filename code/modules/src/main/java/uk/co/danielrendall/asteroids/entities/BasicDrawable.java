package uk.co.danielrendall.asteroids.entities;

import uk.co.danielrendall.mathlib.geom2d.BoundingBox;
import uk.co.danielrendall.mathlib.geom2d.Line;
import uk.co.danielrendall.mathlib.geom2d.Point;

import java.awt.Color;


/**
 * Created by IntelliJ IDEA.
 * User: daniel
 * Date: 29-Apr-2010
 * Time: 20:48:15
 * To change this template use File | Settings | File Templates.
 */
public class BasicDrawable implements Drawable{
    private final Line[] lines;
    private final BoundingBox boundingBox;
    private final Color color;

    public BasicDrawable(Line[] lines, BoundingBox boundingBox, Color color) {
        this.lines = lines;
        this.boundingBox = boundingBox;
        this.color = color;
    }

    public Line[] getLines() {
        return lines;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public Color getColor() {
        return color;
    }
}
