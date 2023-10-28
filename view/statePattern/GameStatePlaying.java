package view.statePattern;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import controller.Application;
import model.Marking;
import view.ApplicationWindow;

public class GameStatePlaying implements GameState {

    @Override
    public void goNext(ApplicationWindow context) {
        context.setGameState(new GameStateDone());
    }

    @Override
    public void updateWindow() {
        Application.applicationWindow.newGameButton.setEnabled(false);
        Application.applicationWindow.vsHumanButton.setEnabled(false);
        Application.applicationWindow.vsComputerButton.setEnabled(false);

        for (int i = 0; i < Application.ticTacToeGame.getBoard().length; i++) {
            Application.applicationWindow.markingButtons[i].setMark(Application.ticTacToeGame.getBoard()[i]);
            Application.applicationWindow.markingButtons[i].setEnabled(Application.ticTacToeGame.getBoard()[i] == Marking.U);
        }

        Application.applicationWindow.canvas.repaint();
    }

    @Override
    public void updateCanvas(Graphics2D g2) {
        g2.setFont(new Font("Courier New", Font.BOLD, 16));
        g2.setColor(Color.BLUE);
        g2.drawString("Turn: " + Application.ticTacToeGame.getTurn(), 50, 90);
    }
}