package controller;

//import the following java classes
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import our own classes

public class NewGameButtonListener implements ActionListener 
{
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        Application.ticTacToeGame.reset();
        Application.applicationWindow.goNextState();
        Application.applicationWindow.updateWindow();
    }
}