import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.CanvasWindow;
public class scoreboard {
    private int score;
    private GraphicsText scoreText;

    public Scoreboard(){
        score = 0;
        scoreText = new GraphicsText("Score:"+ score, 10,2)
    }
    public void increment(){
        score++;
    }
    public int getScore(){
        return score;
    }
    public void resetScore(){
        score = 0;
    }
    public void draw(Graphics g){
        g.drawString("Score:"+ score, 10, 20);
    }
}
