package uk.co.danielrendall.asteroids.display;

import uk.co.danielrendall.asteroids.game.*;
import uk.co.danielrendall.mathlib.geom2d.BoundingBox;

import javax.swing.*;

public final class Engine {

    public final static int SCREEN_X = 1200;
    public final static int SCREEN_Y = 960;
    public final static BoundingBox BOUNDS = new BoundingBox(0, SCREEN_X, 0, SCREEN_Y);

    private final Screen screen;
    private final Game game;

    private Engine() {
        screen = new Screen();
        game = new Game();
    }

    private static Engine instance = null;

    public static Engine getInstance() {
        if (instance == null) {
            instance = new Engine();
        }
        return instance;
    }

    public static void main(String[] args) throws Exception {
        Engine.getInstance().run();
    }

    private void run() {
        mainLoop();
    }


    private void mainLoop() {
        System.out.println("Hello world");
        while (true) {
            screen.draw(game);
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            game.update();
        }
    }
}
