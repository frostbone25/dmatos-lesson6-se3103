package view.statePattern;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import controller.Application;
import model.Marking;
import view.ApplicationWindow;

public class GameStateDone implements GameState {

    @Override
    public void goNext(ApplicationWindow context) {
        context.setGameState(new GameStatePlaying());
    }

    @Override
    public void updateWindow() {
        for (int i = 0; i < Application.ticTacToeGame.getBoard().length; i++) {
            Application.applicationWindow.markingButtons[i].setMark(Application.ticTacToeGame.getBoard()[i]);
            Application.applicationWindow.markingButtons[i].setEnabled(false);
        }

        Application.applicationWindow.newGameButton.setEnabled(true);
        Application.applicationWindow.vsHumanButton.setEnabled(true);
        Application.applicationWindow.vsComputerButton.setEnabled(true);

        Application.applicationWindow.canvas.repaint();
    }

    @Override
    public void updateCanvas(Graphics2D g2) {
        Marking winner = Application.ticTacToeGame.getWinner();
        String overMessage = winner + " has won!";
        if (winner == Marking.U) {
            overMessage = "Draw/Tie";
        }
        g2.setFont(new Font("Courier New", Font.BOLD, 16));
        g2.setColor(Color.RED);
        g2.drawString("Game Over: " + overMessage, 50, 50);
        g2.drawString("Press <New Game> to Play Again!", 50, 80);
    }

}
