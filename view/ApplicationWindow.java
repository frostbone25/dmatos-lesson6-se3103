package view;

//import the following java classes
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

//import our own classes
import controller.Application;
import controller.ButtonListener;
import controller.NewGameButtonListener;
import controller.StrategyButtonListener;
import model.strategyPattern.VsComputerStrategy;
import model.strategyPattern.VsHumanStrategy;
import model.strategyPattern.VsSmartComputerStrategy;
import view.statePattern.GameState;
import view.statePattern.GameStateInit;

public class ApplicationWindow extends JFrame 
{
    public static final String versusHumanAction = "vs. Human";
    public static final String versusComputerAction = "vs. Computer";
    public static final String versusSmartComputerAction = "vs. Smart Computer";

    public ApplicationCanvas canvas = new ApplicationCanvas();
    public BoardButton[] markingButtons = new BoardButton[9];
    public JButton newGameButton = new JButton("New Game");
    public JRadioButton vsHumanButton;
    public JRadioButton vsComputerButton;
    public JRadioButton vsSmartComputerButton;

    private GameState state = new GameStateInit();

    public void initalize() 
    {
        var contentPane = getContentPane();
        contentPane.add(canvas, BorderLayout.NORTH);

        ButtonListener buttonListener = new ButtonListener();

        for (int i = 0; i < markingButtons.length; i++) 
        {
            markingButtons[i] = new BoardButton(i);
            markingButtons[i].addActionListener(buttonListener);
        }

        JPanel gameBoardPanel = new JPanel();
        gameBoardPanel.setLayout(new GridLayout(3, 3));

        for (BoardButton cell: markingButtons) 
        {
            gameBoardPanel.add(cell);
        }

        contentPane.add(gameBoardPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(2, 1));
        contentPane.add(southPanel, BorderLayout.SOUTH);

        JPanel radioPanel = new JPanel();
        radioPanel.setBorder(new TitledBorder("Play strategy"));
        vsHumanButton = new JRadioButton(versusHumanAction, Application.ticTacToeGame.getStrategy() instanceof VsHumanStrategy);
        vsComputerButton = new JRadioButton(versusComputerAction, Application.ticTacToeGame.getStrategy() instanceof VsComputerStrategy);
        vsSmartComputerButton = new JRadioButton(versusSmartComputerAction, Application.ticTacToeGame.getStrategy() instanceof VsSmartComputerStrategy);
        radioPanel.add(vsHumanButton);
        radioPanel.add(vsComputerButton);
        radioPanel.add(vsSmartComputerButton);
        StrategyButtonListener strategyListener = new StrategyButtonListener();
        vsHumanButton.addActionListener(strategyListener);
        vsComputerButton.addActionListener(strategyListener);
        vsSmartComputerButton.addActionListener(strategyListener);
        ButtonGroup strategyGroup = new ButtonGroup();
        strategyGroup.add(vsHumanButton);
        strategyGroup.add(vsComputerButton);
        strategyGroup.add(vsSmartComputerButton);
        southPanel.add(radioPanel);

        JPanel actionPanel = new JPanel();
        actionPanel.setBorder(new TitledBorder("Action"));
        actionPanel.add(newGameButton);
        newGameButton.addActionListener(new NewGameButtonListener());
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        actionPanel.add(exitButton);
        southPanel.add(actionPanel);

        updateWindow();
    }

    public void goNextState() {
        state.goNext(this);
    }

    public GameState getGameState() {
        return state;
    }

    public void setGameState(GameState state) {
        this.state = state;
    }

    public void updateWindow() 
    {
        state.updateWindow();
        canvas.repaint();
    }
}