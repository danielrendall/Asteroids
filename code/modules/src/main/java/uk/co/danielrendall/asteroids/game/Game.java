package uk.co.danielrendall.asteroids.game;

import uk.co.danielrendall.asteroids.display.Engine;
import uk.co.danielrendall.asteroids.entities.Drawable;
import uk.co.danielrendall.asteroids.entities.Entity;
import uk.co.danielrendall.asteroids.entities.EntityFactory;
import uk.co.danielrendall.asteroids.entities.Shape;
import uk.co.danielrendall.mathlib.geom2d.Line;

import java.util.*;


import java.awt.Color;

public final class Game {

    private List<Entity> entities;

    private final EntityFactory factory = new EntityFactory();

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
        entities = new ArrayList<Entity>(30);
        for (int i = 0; i < 10; i++) {
            entities.add(factory.createAsteroid(Engine.BOUNDS, EntityFactory.AsteroidSize.LARGE));
            entities.add(factory.createAsteroid(Engine.BOUNDS, EntityFactory.AsteroidSize.MEDIUM));
            entities.add(factory.createAsteroid(Engine.BOUNDS, EntityFactory.AsteroidSize.SMALL));
        }
    }

    public void update() {
        for (Entity e : entities) {
            e.update();
        }
    }

    public void addLines(Map<Color, SortedSet<Line>> lineMap) {
        for (Entity e: entities) {
            Drawable[] drawables = e.getDrawables();
            SortedSet<Line> lines = lineMap.get(e.getColor());
            for (Drawable d: drawables) {
                if (lines == null) {
                    lines = new TreeSet<Line>(comparator);
                    lineMap.put(e.getColor(), lines);
                }
                lines.addAll(Arrays.asList(d.getLines()));
            }
        }
    }
}
