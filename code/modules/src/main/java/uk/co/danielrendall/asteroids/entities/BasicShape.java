package uk.co.danielrendall.asteroids.entities;

import uk.co.danielrendall.asteroids.entities.Drawable;
import uk.co.danielrendall.asteroids.entities.Entity;
import uk.co.danielrendall.mathlib.geom2d.BoundingBox;
import uk.co.danielrendall.mathlib.geom2d.Line;
import uk.co.danielrendall.mathlib.geom2d.Point;
import uk.co.danielrendall.mathlib.geom2d.Vec;

/**
 * Created by IntelliJ IDEA.
 * User: daniel
 * Date: 29-Apr-2010
 * Time: 08:29:01
 * To change this template use File | Settings | File Templates.
 */
public class BasicShape implements Shape {

    private final Vec[] pointDisplacements;

    public BasicShape(Vec[] pointDisplacements) {
        this.pointDisplacements = pointDisplacements;
    }

    public Drawable[] getDrawables(BoundingBox limits, Entity entity) {
        final Point[] newPoints = new Point[pointDisplacements.length];

        Point location = entity.getLocation();
        Double orientation = entity.getOrientation();
        for (int i=0; i< pointDisplacements.length; i++) {
            newPoints[i] =location.displace(pointDisplacements[i].rotate(orientation));
        }

        BoundingBox boundingBox = BoundingBox.containing(newPoints);
//        if (limits.contains(boundingBox)) {
            Drawable[] drawables = new Drawable[1];
            final Line[] lines = new Line[newPoints.length];
            Point last = newPoints[newPoints.length - 1];
            for (int i=0; i<newPoints.length; i++) {
                Point point = newPoints[i];
                lines[i] =  new Line(last, point);
                last = point;
            }
            drawables[0] = new BasicDrawable(lines, boundingBox);
//        }
        // TODO - proper clipping
        return drawables;
    }
}
