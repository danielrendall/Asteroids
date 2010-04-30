package uk.co.danielrendall.asteroids.display;

import uk.co.danielrendall.asteroids.entities.Drawable;
import uk.co.danielrendall.mathlib.geom2d.Line;
import uk.co.danielrendall.mathlib.geom2d.Point;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: daniel
 * Date: 30-Apr-2010
 * Time: 08:24:37
 * To change this template use File | Settings | File Templates.
 */
public class SimpleStrategy implements DisplayStrategy {

    private final List<Command> commands;

    public SimpleStrategy() {
        commands = new ArrayList<Command>(1000);
    }

    public List<Command> getCommands(List<Drawable> drawables) {
        commands.clear();
        Color currentColor = null;
        for (Drawable d: drawables) {
            Color thisColor = d.getColor();
            Line[] lines = d.getLines();
            Point lastPoint = lines[0].getStart();
            commands.add(new MoveToCommand(lines[0].getStart()));
            if (currentColor == null || !thisColor.equals(currentColor)) {
                currentColor = thisColor;
                commands.add(new MoveToCommand(lastPoint, currentColor));
            } else {
                commands.add(new MoveToCommand(lastPoint));
            }

            for (Line line : lines) {
                if (!lastPoint.equals(line.getStart())) {
                    commands.add(new MoveToCommand(line.getStart()));
                }
                commands.add(new LineToCommand(line.getEnd()));
                lastPoint = line.getEnd();
            }
        }
        return commands;
    }

}
