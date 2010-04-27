package uk.co.danielrendall.asteroids.display;

import java.awt.*;

public final class Line implements Comparable<Line> {
    private final float x1, y1, x2, y2;

    public Line(float x1, float y1, float x2, float y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void draw(Graphics g) {
        g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
    }

    public int getX1() {
        return (int) x1;
    }

    public int getY1() {
        return (int) y1;
    }

    public int getX2() {
        return (int) x2;
    }

    public int getY2() {
        return (int) y2;
    }

    public int compareTo(Line other) {
        if (this.y1 > other.y1) return 1;
        if (this.y1 < other.y1) return -1;
        if (this.x1 > other.x1) return 1;
        if (this.x1 < other.x1) return -1;
        return 0;
    }
}
