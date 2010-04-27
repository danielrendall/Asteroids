package uk.co.danielrendall.asteroids.game;

import uk.co.danielrendall.asteroids.entities.*;

import java.util.*;

import uk.co.danielrendall.asteroids.display.*;

import java.awt.Color;
import java.awt.Graphics;

public final class Game {

    private List<VectorDrawable> drawables;

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
                lines = new TreeSet<Line>();
                lineMap.put(d.getColor(), lines);
            }
            for (Line line : d.getLines()) {
                lines.add(line);
            }
        }
    }
}
