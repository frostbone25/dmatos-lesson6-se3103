package view.statePattern;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import controller.Application;
import view.ApplicationWindow;
import view.BoardButton;

public class GameStateInit implements GameState {

    @Override
    public void goNext(ApplicationWindow context) {
        context.setGameState(new GameStatePlaying());
    }

    @Override
    public void updateWindow() {
        for (BoardButton button: Application.applicationWindow.markingButtons) 
        {
            button.setEnabled(false);
        }
        Application.applicationWindow.newGameButton.setEnabled(true);
        Application.applicationWindow.vsHumanButton.setEnabled(true);
        Application.applicationWindow.vsComputerButton.setEnabled(true);

        Application.applicationWindow.canvas.repaint();
    }

    @Override
    public void updateCanvas(Graphics2D g2) {
        g2.setFont(new Font("Courier New", Font.BOLD, 16));
        g2.setColor(Color.BLUE);
        g2.drawString("Press <New Game> to Start", 50, 50);
    }
}
