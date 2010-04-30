package uk.co.danielrendall.asteroids.display;

import uk.co.danielrendall.asteroids.entities.Drawable;

import java.util.ArrayList;
import java.util.List;

public interface DisplayStrategy {

    public List<Command> getCommands(List<Drawable> drawables);
}
