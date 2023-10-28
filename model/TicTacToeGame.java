package model;

import model.strategyPattern.PlayStrategy;
import model.strategyPattern.VsHumanStrategy;

public class TicTacToeGame 
{
    private Marking[] board = new Marking[9];
    private Marking turn = Marking.X;
    private int moves = 0;
    private Marking winner = null;
    private PlayStrategy strategy;

    public TicTacToeGame() 
    {
        reset();
        setStrategy(new VsHumanStrategy(this)); // default
    }
    
    public void reset() 
    {
        for(int i = 0; i < board.length; i++)
        {
            board[i] = Marking.U;
        }

        turn = Marking.X;
        moves = 0;
        winner = null;
    }

    public void changeTurns()
    {
        turn = (turn == Marking.X) ? Marking.O : Marking.X;
    }

    public Marking getTurn() 
    {
        return turn;
    }

    public void incMoves() {
        ++moves;
    }

    public void play(int position) 
    {
        strategy.play(position);
    }

    public Marking getWinner() 
    {
        return winner;
    }

    public void setWinner() 
    {
        for (int i = 0; i < 3; i++)
        {
            winner = checkCol(i);

            if (winner != null) 
            {
                return;
            }

            winner = checkRow(i);

            if (winner != null) 
            {
                return;
            }
        }

        winner = checkDiagonal1();

        if (winner != null) 
            return;

        winner = checkDiagonal2();

        if (winner != null) 
            return;

        if (moves == 9) 
        {
            winner = Marking.U; // draw
            return;
        }

        winner = null;
    }

    private Marking checkRow(int n) 
    {
        int rowIndex = n * 3;

        if (board[rowIndex] != Marking.U && board[rowIndex] == board[rowIndex + 1] && board[rowIndex] == board[rowIndex + 2]) 
        {
            return board[rowIndex];
        } 
        else 
        {
            return null; // no winner
        }
    }

    private Marking checkCol(int n) 
    {
        if (board[n] != Marking.U && board[n] == board[n + 3] && board[n] == board[n + 6]) 
        {
            return board[n];
        } 
        else 
        {
            return null;
        }
    }

    private Marking checkDiagonal1() 
    {
        if(board[0] != Marking.U && board[0] == board[4] && board[0] == board[8]) 
        {
            return board[0];
        } 
        else 
        {
            return null;
        }
    }

    private Marking checkDiagonal2() 
    {
        if(board[2] != Marking.U && board[2] == board[4] && board[2] == board[6]) 
        {
            return board[2];
        } 
        else 
        {
            return null;
        }
    }

    public PlayStrategy getStrategy() 
    {
        return strategy;
    }

    public void setStrategy(PlayStrategy strategy) 
    {
        this.strategy = strategy;
    }

    public Marking[] getBoard() 
    {
        return board;
    }

    @Override
    public String toString() 
    {
        String row1 = String.format("%s %s %s\n", board[0], board[1], board[2]);
        String row2 = String.format("%s %s %s\n", board[3], board[4], board[5]);
        String row3 = String.format("%s %s %s\n", board[6], board[7], board[8]);
        String row4 = String.format("Winner: %s (moves: %d)\n", winner, moves);

        return row1 + row2 + row3 + row4;
    }
}
