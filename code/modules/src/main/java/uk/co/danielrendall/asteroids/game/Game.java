package uk.co.danielrendall.asteroids.game;

import uk.co.danielrendall.asteroids.entities.*;
import uk.co.danielrendall.mathlib.geom2d.Line;

import java.util.*;


import java.awt.Color;

public final class Game {

    private List<VectorDrawable> drawables;

    private final Comparator<Line> comparator = new Comparator<Line>() {

        public int compare(Line l1, Line l2) {
            if (l1.getStart().y() > l2.getStart().y()) return 1;
            if (l1.getStart().y() < l2.getStart().y()) return -1;
            if (l1.getStart().x() > l2.getStart().x()) return 1;
            if (l1.getStart().x() < l2.getStart().x()) return -1;
            return 0;
        }
    };

    public Game() {
        drawables = new ArrayList<VectorDrawable>(30);
        for (int i = 0; i < 10; i++) {
            drawables.add(new Asteroid(20, i + 5, Color.GREEN));
            drawables.add(new Asteroid(10, i + 5, Color.BLUE));
            drawables.add(new Asteroid(5, i + 5, Color.RED));
        }
    }

    public void update() {
        for (VectorDrawable d : drawables) {
            d.update();
        }
    }

    public void addLines(Map<Color, SortedSet<Line>> lineMap) {
        for (VectorDrawable d : drawables) {
            SortedSet<Line> lines = lineMap.get(d.getColor());
            if (lines == null) {
                lines = new TreeSet<Line>(comparator);
                lineMap.put(d.getColor(), lines);
            }
            for (Line line : d.getLines()) {
                lines.add(line);
            }
        }
    }
}
