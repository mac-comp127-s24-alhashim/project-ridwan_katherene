import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Image;
import java.awt.Dimension;
import java.awt.Color;
import edu.macalester.graphics.events.Key;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.Pipe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class flappyBird {

    private Bird bird;
    private CanvasWindow canvas;
    private static final int WINDOW_WIDTH = 608;
    private static final int WINDOW_HEIGHT = 457;

    public flappyBird() {
        canvas = new CanvasWindow(
            "flappyBird", WINDOW_WIDTH, WINDOW_HEIGHT);

        canvas.setBackground(new Color(153, 204, 255));
        Image background = new Image(0, 0, "backgroundImage.png");
        background.setMaxHeight(WINDOW_HEIGHT);
        background.setMaxWidth(WINDOW_WIDTH);


        bird = new Bird(0,0,50, 50, new Image ("flappyBird.png"));
        canvas.add(background);
        canvas.add(bird);
        canvas.draw();
    }
   
    public static void main(String[] args) {
        new flappyBird();
    }
}
    

