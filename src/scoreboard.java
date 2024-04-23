import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.CanvasWindow;
public class Scoreboard {
    private int score;
    private GraphicsText scoreText;

    public Scoreboard(CanvasWindow canvas){
        score = 0;
        scoreText = new GraphicsText("Score:"+ score, 10,20);
        canvas.add(scoreText);
        
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
