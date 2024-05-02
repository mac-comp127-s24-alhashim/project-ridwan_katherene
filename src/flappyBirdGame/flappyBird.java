package flappyBirdGame;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import java.awt.Color;
import edu.macalester.graphics.events.Key;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class FlappyBird {

    private Bird bird;
    private Bird bird2;
    private scoreboard scoreboard;
    private CanvasWindow canvas;
    private int WINDOW_WIDTH = 600;
    private int WINDOW_HEIGHT = 600;
    // private static final int PIPES_INTERVAL = 250;
    // private Image topPipeImage;
    private Image backgroundImage;
    private List<UpwardPipe> pipes = new ArrayList<>();
    private boolean isStartScreen;

    public FlappyBird() {
        this.isStartScreen = true;
        backgroundImage = new Image(0, 0, "backgroundImage.png");
        WINDOW_WIDTH = (int)backgroundImage.getWidth();
        WINDOW_HEIGHT = (int)backgroundImage.getHeight();

        canvas = new CanvasWindow("By Ridwan Osman and Katherene Lugo", WINDOW_WIDTH, WINDOW_HEIGHT);
        canvas.setBackground(new Color(153, 204, 255));
        // canvas.onKeyDown(event -> onKeyPress(event));
        backgroundImage.setMaxHeight(WINDOW_HEIGHT);
        backgroundImage.setMaxWidth(WINDOW_WIDTH);
        canvas.add(backgroundImage);
     
        bird = new Bird(canvas.getWidth() * 0.5,canvas.getHeight() * 0.5, 50,50);
        bird.setCenter(canvas.getWidth() * 0.5,canvas.getHeight() * 0.5 );
        canvas.add(bird);
        canvas.onKeyDown(event -> { 
            if (event.getKey().equals(Key.SPACE)) {
                isStartScreen = false;
                System.out.println("Hello");
            }
        });
        canvas.animate(() -> gameLoop());
    }


    public void startScreen(){
        Image startScreenBackground = new Image(WINDOW_WIDTH, WINDOW_HEIGHT, "backgroundImage.png");
        Image startScreenBanner = new Image(0, 0, "flappyBirdBanner.png");
        startScreenBanner.setMaxWidth(WINDOW_WIDTH);
        startScreenBanner.setMaxHeight(WINDOW_HEIGHT);
        startScreenBanner.setScale(WINDOW_WIDTH*0.0008, WINDOW_HEIGHT*0.0008);
        Image startButtonImage = new Image("startButton.png");
        startButtonImage.setMaxWidth(WINDOW_WIDTH);
        startButtonImage.setMaxHeight(WINDOW_HEIGHT);
        startButtonImage.setScale(WINDOW_WIDTH*0.0008, WINDOW_HEIGHT*0.0008);
        startButtonImage.setCenter(WINDOW_WIDTH*0.5, WINDOW_HEIGHT*0.7);
        canvas.add(startScreenBackground);
        canvas.add(startScreenBanner);
        canvas.add(startButtonImage);
    }




    public void resetGame() {
        //for (Pipe pipe : pipes){
           /// pipes.remove(pipe);
        //}
        pipes.clear();
        bird.setPosition(100,200);
        scoreboard.resetScore();
        //resetPipe();
        // createPipe();
        //canvas.remove((GraphicsObject) pipes);
        // Assuming your CanvasWindow or bird object has these methods to reset the game
        // this.canvas.getGame().restart();
        // this.canvas.update();
    }


    public CanvasWindow getCanvas(){
        return canvas;
    }
   

    public void gameLoop(){
        
        if(isStartScreen){
            startScreen();
            return;
        }
        else{
        //bird.moveBird();
        canvas.setBackground(new Color(153, 204, 255));
        backgroundImage.setMaxHeight(WINDOW_HEIGHT);
        backgroundImage.setMaxWidth(WINDOW_WIDTH);
        canvas.add(backgroundImage);
        canvas.remove(bird);
     

        // bird = new Bird(canvas.getWidth() * 0.5,canvas.getHeight() * 0.5, 50,50);
        // bird.setCenter(canvas.getWidth() * 0.5,canvas.getHeight() * 0.5 );
        // canvas.add(bird);
        // bottomPipeImage = new Image("bottomPipe.png");
        // topPipeImage = new Image("upwardPipe.png");
       

        // pipes = new ArrayList<>();
        canvas.onKeyDown(event-> {
            if (event.getKey().equals(Key.UP_ARROW)) {
                System.out.println("Hi Hi");
                bird.moveBird();
                // bird2.newUpdatePosition();
                // bird.jumpBird();
            }
            return;
        });
       
        

        int frameCount = 0;
        // bird.newUpdatePosition();
        canvas.add(bird);
        // createPipe();
        Iterator<UpwardPipe> pipes_I = pipes.iterator();
        while(pipes_I.hasNext()){
            UpwardPipe pipe = pipes_I.next();
            // pipe.move();
        } 

    }
    }
    
    
    


   
    public static void main(String[] args) {
        FlappyBird game = new FlappyBird();
    }
}





