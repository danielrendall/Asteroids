package uk.co.danielrendall.asteroids.display;

import uk.co.danielrendall.asteroids.entities.Drawable;
import uk.co.danielrendall.mathlib.geom2d.*;
import uk.co.danielrendall.mathlib.geom2d.Point;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: daniel
 * Date: 30-Apr-2010
 * Time: 08:23:35
 * To change this template use File | Settings | File Templates.
 */
public class LineSortStrategy implements DisplayStrategy {

    private final List<Command> commands;
    private final Map<Color, List<Line>> linesMap;
    private final Map<Color, List<Drawable>> drawablesMap;

    private final Comparator<Line> lineComparator = new Comparator<Line>() {
        public int compare(Line o1, Line o2) {
            Point p1 = o1.getStart();
            Point p2 = o2.getStart();

            int i = Double.compare(p1.y(), p2.y());
            if (i != 0) return i;
            return Double.compare(p1.x(), p2.x());
        }
    };

    public LineSortStrategy() {
        commands = new ArrayList<Command>(1000);
        linesMap = new HashMap<Color, List<Line>>();
        drawablesMap = new HashMap<Color, List<Drawable>>();
    }

    public List<Command> getCommands(List<Drawable> drawables) {
        commands.clear();
        // empty existing lists for each color
        for (Color color : drawablesMap.keySet()) {
            drawablesMap.get(color).clear();
            linesMap.get(color).clear();
        }

        // Split drawables up by color, put them into lists in the drawablesMap
        for (Drawable d: drawables) {
            Color thisColor = d.getColor();
            List<Drawable> forColor = drawablesMap.get(thisColor);
            if (forColor == null) {
                forColor = new ArrayList<Drawable>(1000);
                drawablesMap.put(thisColor, forColor);
            }
            forColor.add(d);
        }

        // Add all the lines for each color to the appropriate list
        for (Color color : drawablesMap.keySet()) {
            List<Line> forColor = linesMap.get(color);
            if (forColor == null) {
                forColor = new ArrayList<Line>(1000);
                linesMap.put(color, forColor);
            }
            for (Drawable d: drawablesMap.get(color)) {
                Collections.addAll(forColor, d.getLines());
            }
        }
        Point last = null;
        for (Color color : linesMap.keySet()) {
            commands.add(new ColorChangeCommand(color));
            List<Line> forColor = linesMap.get(color);
            Collections.sort(forColor, lineComparator);
            if (forColor.size() > 0) {
                Line firstLine = forColor.get(0);
                boolean wasFirst = false;
                if (last == null) {
                    last = firstLine.getStart();
                    wasFirst = true;
                }
                for(Line line: forColor) {
                    if (!last.equals(line.getStart()) || wasFirst) {
                        commands.add(new MoveToCommand(line.getStart()));
                    }
                    last = line.getEnd();
                    commands.add(new LineToCommand(last));
                }
            }
        }
        return commands;
    }
}
