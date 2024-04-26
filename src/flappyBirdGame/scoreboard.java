package flappyBirdGame;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;


import edu.macalester.graphics.CanvasWindow;




public class scoreboard {
    private int score;
    private GraphicsText scoreText;
    private Rectangle background;
    //private flappyBird game;

    public scoreboard(CanvasWindow canvas){
        //this.game = game;
        score = 0;
        scoreText = new GraphicsText("Score:"+ score, 10,2);
        canvas.add(scoreText);
        background = new Rectangle(10,10,150,80);
        background.setFillColor(Color.LIGHT_GRAY);
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
        scoreText.setPosition(20,30);
        
    }
    
}
