import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import java.awt.Dimension;

public class FlappyBird extends CanvasWindow {

    private Bird bird;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    public FlappyBird() {
        super("Flappy Bird", WINDOW_WIDTH, WINDOW_HEIGHT);

        bird = new Bird(100,200,50, 50, new Image ("flappyBird.png"));
            add(bird);
    }
    public static void main(String[] args) {
        new GameWindow();
    }
    
}
