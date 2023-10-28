package view;

//import the following java classes
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

//import our own classes
import controller.Application;

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
        Application.applicationWindow.getGameState().updateCanvas(g2);
    }
}