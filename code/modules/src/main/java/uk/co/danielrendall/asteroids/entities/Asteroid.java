package uk.co.danielrendall.asteroids.entities;

import java.awt.Color;
import java.util.*;

import uk.co.danielrendall.asteroids.display.Engine;
import uk.co.danielrendall.mathlib.geom2d.Line;
import uk.co.danielrendall.mathlib.geom2d.Point;
import uk.co.danielrendall.mathlib.geom2d.Vec;

public final class Asteroid implements VectorDrawable {

    private final Color myColor;
    private final Vec[] pointDisplacements;
    private final int numPoints;
    private Point pos;

    private Vec vel;

    
    public Asteroid(int size, int numPoints, Color color) {
        myColor = color;
        this.numPoints = numPoints;
        double theta = 2 * Math.PI / (double) numPoints;
        pointDisplacements = new Vec[numPoints];
        for (int i = 0; i < numPoints; i++) {
            double arg = theta * (double) i;
            pointDisplacements[i] = new Vec((double) size * Math.cos(arg) + (Math.random() * 10.0d) - 5.0d,
                    (double) size *  Math.sin(arg) + (Math.random() * 10.0d) - 5.0d);
        }
        pos = new Point(Math.random() * (double) Engine.SCREEN_X, Math.random() * (double) Engine.SCREEN_Y);
        vel = new Vec((Math.random() * 10.0d) - 5.0f, (Math.random() * 10.0d) - 5.0f);
    }

    public Color getColor() {
        return myColor;
    }

    public List<Line> getLines() {
        List<Line> lines = new ArrayList<Line>(numPoints);

        Point lastPos = pos.displace(pointDisplacements[numPoints - 1]);

        for (int i = 0; i < numPoints; i++) {
            Point thisPos = pos.displace(pointDisplacements[i]);
            lines.add(new Line(lastPos, thisPos));
            lastPos = thisPos;
        }
        return lines;
    }

    public void update() {
        pos = pos.displace(vel);
        if (pos.x() < 0.0d) {
            pos = pos.displace(SCREEN_SHIFT_X);
        } else if (pos.x() > Engine.SCREEN_X) {
            pos = pos.displace(SCREEN_SHIFT_MINUS_X);
        }
        if (pos.y() < 0.0d) {
            pos = pos.displace(SCREEN_SHIFT_Y);
        } else if (pos.y() > Engine.SCREEN_Y) {
            pos = pos.displace(SCREEN_SHIFT_MINUS_Y);
        }
    }
}
