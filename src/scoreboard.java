import edu.macalester.graphics.GraphicsText;

import java.awt.Graphics;

import edu.macalester.graphics.CanvasWindow;
public class scoreboard {
    private int score;
    private GraphicsText scoreText;

    public int Scoreboard(){
        score = 0;
        scoreText = new GraphicsText("Score:"+ score, 10,2);
        return score;
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
