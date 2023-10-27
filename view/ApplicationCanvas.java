package view;

//import the following java classes
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

//import our own classes
import controller.Application;
import model.GameState;
import model.Marking;
import model.TicTacToeGame;

public class ApplicationCanvas extends JPanel {
    
    public static final int WIDTH = 400;
    public static final int HEIGHT = 100;

    public ApplicationCanvas() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("Courier New", Font.BOLD, 16));

        TicTacToeGame game = Application.ticTacToeGame;
        GameState gameState = game.getState();

        switch (gameState) {
            case INITAL:
                g2.setColor(Color.BLUE);
                g2.drawString("Press <New Game> to Start", 50, 50);
                break;
            case PLAYING:
                g2.setColor(Color.BLUE);
                g2.drawString("Turn: " + game.getTurn(), 50, 90);
                break;
            case OVER:
                Marking winner = game.getWinner();
                String overMessage = winner + " has won!";
                if (winner == Marking.U) {
                    overMessage = "Draw/Tie";
                }
                g2.setColor(Color.RED);
                g2.drawString("Game Over: " + overMessage, 50, 50);
                g2.drawString("Press <New Game> to Play Again!", 50, 80);
                break;
        }
    }

}
