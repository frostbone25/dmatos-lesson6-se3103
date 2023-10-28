package view.statePattern;

import java.awt.Graphics2D;

import view.ApplicationWindow;

public interface GameState {
    void goNext(ApplicationWindow context);
    void updateWindow();
    void updateCanvas(Graphics2D g2);
}
