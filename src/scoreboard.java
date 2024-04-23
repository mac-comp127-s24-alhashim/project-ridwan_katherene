import edu.macalester.graphics.GraphicsText;

import java.awt.Graphics;

import edu.macalester.graphics.CanvasWindow;
public class Scoreboard {
    private int score;
    private GraphicsText scoreText;

    public int Scoreboard(){
        score = 0;
        scoreText = new GraphicsText("Score:"+ score, 10,2);
        return score;
    }
    public void incrementScore(){
        score++;
        updateScoreText();
    }
    public int getScore(){
        return score;
    }
    public void resetScore(){
        score = 0;
        updateScoreText();
    }
    private void updateScoreText(){
        scoreText.setText("Score:"+score);
        
    }
    
}
