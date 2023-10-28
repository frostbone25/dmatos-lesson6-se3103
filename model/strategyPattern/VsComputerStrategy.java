package model.strategyPattern;

import model.Marking;
import model.TicTacToeGame;

public class VsComputerStrategy implements PlayStrategy {

    private TicTacToeGame game;

    public VsComputerStrategy(TicTacToeGame game) {
        this.game = game;
    }

    @Override
    public void play(int position) {
        game.getBoard()[position] = game.getTurn();
        game.incMoves();
        game.setWinner();
        if (game.getWinner() != null) return;

        // computer player
        game.changeTurns();
        int pos = computerPick();
        game.getBoard()[pos] = game.getTurn();
        game.incMoves();
        game.setWinner();
    }

    private int computerPick() 
    {
        int pos = -1;

        for (int i = 0; i < game.getBoard().length; i++) 
        {
            if(game.getBoard()[i] == Marking.U) 
            {
                pos = i;
                break;
            }
        }

        assert pos >= 0 : "Invalid position from computerPick()";

        return pos;
    }
}
