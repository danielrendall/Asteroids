package uk.co.danielrendall.asteroids.display;

import uk.co.danielrendall.mathlib.geom2d.Point;

import java.awt.Graphics;


/**
 * Created by IntelliJ IDEA.
 * User: daniel
 * Date: 29-Apr-2010
 * Time: 22:59:12
 * To change this template use File | Settings | File Templates.
 */
public interface Command {

    public Point accept(Graphics g, Point last);
}
