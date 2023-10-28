package controller;

//import the following java classes
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.strategyPattern.VsComputerStrategy;
import model.strategyPattern.VsHumanStrategy;
import model.strategyPattern.VsSmartComputerStrategy;
//import our own classes
import view.ApplicationWindow;

public class StrategyButtonListener implements ActionListener 
{
    @Override
    public void actionPerformed(ActionEvent actionEvent) 
    {
        switch(actionEvent.getActionCommand()) 
        {
            case ApplicationWindow.versusHumanAction:
                Application.ticTacToeGame.setStrategy(new VsHumanStrategy(Application.ticTacToeGame));
                break;
            case ApplicationWindow.versusComputerAction:
                Application.ticTacToeGame.setStrategy(new VsComputerStrategy(Application.ticTacToeGame));
                break;
            case ApplicationWindow.versusSmartComputerAction:
                Application.ticTacToeGame.setStrategy(new VsSmartComputerStrategy(Application.ticTacToeGame));
                break;
        }
    }
}