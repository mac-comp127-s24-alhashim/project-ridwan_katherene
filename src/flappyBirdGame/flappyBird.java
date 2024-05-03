package flappyBirdGame;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import java.awt.Color;
import edu.macalester.graphics.events.Key;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class flappyBird {

    private Bird bird;
    ///private Bird bird2;
    private scoreboard scoreboard;
    private CanvasWindow canvas;
    private int WINDOW_WIDTH = 600;
    private int WINDOW_HEIGHT = 600;
    private static final int PIPES_INTERVAL = 250;
    // private Image topPipeImage;
    private Image backgroundImage;
    private List<UpwardPipe> pipes = new ArrayList<>();
    ///private List<BottomPipe> pipes = new ArrayList<>();
    private boolean isStartScreen;
    //private UpwardPipe upwardPipe;
   ///. private BottomPipe bottomPipe;
    private Image topPipeImage; 
    private Image bottomPipeImage;

    public flappyBird() {
        this.isStartScreen = true;
        backgroundImage = new Image(0, 0, "backgroundImage.png");
        WINDOW_WIDTH = (int)backgroundImage.getWidth();
        WINDOW_HEIGHT = (int)backgroundImage.getHeight();

        canvas = new CanvasWindow("By Ridwan Osman and Katherene Lugo", WINDOW_WIDTH, WINDOW_HEIGHT);
        canvas.setBackground(new Color(153, 204, 255));
        backgroundImage.setMaxHeight(WINDOW_HEIGHT);
        backgroundImage.setMaxWidth(WINDOW_WIDTH);
        canvas.add(backgroundImage);
     
        bird = new Bird(canvas.getWidth() * 0.5,canvas.getHeight() * 0.5, 40,40);
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
        canvas.onKeyDown(event -> {
            isStartScreen = false;
            System.out.println("Game started!");
            // Call the game loop when the start button is clicked
            gameLoop();
        });
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
    private void createPipe(){ 
        int gap = 200; 
        int pipeWidth = 20; 
        int pipeHeight = 300; 
        int randomGapPosition = (int)(Math.random()*(canvas.getHeight()-gap-pipeHeight)); 
        int pipeX = canvas.getWidth(); 
        int pipeYTop = randomGapPosition; 
        int pipeYBottom = randomGapPosition + gap + pipeHeight; 
        // if (upwardPipe.getTopPipeImage() == null) { 
            topPipeImage = new Image("upwardPipe.png"); 
        // } 
        // if (bottomPipe.getBottomPipeImage() == null) { 
            bottomPipeImage = new Image("bottomPipe.png"); 
        // } 
        UpwardPipe pipe = new UpwardPipe(pipeX, pipeYTop, pipeYBottom, pipeWidth, pipeHeight, topPipeImage, bottomPipeImage, canvas); 
        //GraphicsObject pipeObject = pipe.createGraphicsObject(); 
        //topPipeImage = new Image( "upwardPipe.png"); 
        //bottomPipeImage = new Image ("bottomPipe.png"); 
        pipes.add(pipe); 
        // canvas.add(pipe.getTopPipeImage()); 
        // canvas.add(pipe.getBottomPipeImage());
        topPipeImage.setCenter(400, 50);
        topPipeImage.setScale(0.17);
        bottomPipeImage.setCenter(400, 410);
        bottomPipeImage.setScale(0.17);
        canvas.add(topPipeImage);
        canvas.add(bottomPipeImage);
        canvas.draw();
        }
   

    public void gameLoop(){
        int frameCount=0;
        
        if(isStartScreen){
            startScreen();
            return;
        }
        else{ 
            
                canvas.removeAll();
                canvas.setBackground(new Color(153, 204, 255));
                backgroundImage.setMaxHeight(WINDOW_HEIGHT);
                backgroundImage.setMaxWidth(WINDOW_WIDTH);
                canvas.add(backgroundImage);
                canvas.add(bird);
                canvas.onKeyDown(event-> {
                    if (event.getKey().equals(Key.UP_ARROW)) {
                        System.out.println("Hi Hi");
                        bird.moveBird();
                        // if(bird.updatePosition(double dt))
                        //     bird.updatePosition;
                        // bird2.newUpdatePosition();
                        // bird.jumpBird();
                    }
                    return;
                });
       
                canvas.add(bird);
                
                frameCount++;
                // Check if it's time to create a new pipe
                if (frameCount % PIPES_INTERVAL == 0){
                createPipe();
                }
                Iterator<UpwardPipe> pipes_I = pipes.iterator();
                while(pipes_I.hasNext()){
                    UpwardPipe pipe = pipes_I.next();
                    canvas.add(pipe);
                    //pipe.move();
                } 
                movePipes(pipes, canvas);
                checkCrash();
                canvas.draw();
               
               

        }
    }
    

    public void checkCrash(){
        for(UpwardPipe pipe: pipes){
            if(bird.collisionWithPipe(pipe)){
                System.out.println("Game Over");
                resetGame();
                return;
            }
        }
    }
    public void movePipes(List<UpwardPipe> pipes, CanvasWindow canvas) {
        for (UpwardPipe pipe : pipes) {
            pipe.move();
            pipe.getTopPipeImage().setPosition(pipe.getX(), pipe.getY());
            pipe.getBottomPipeImage().setPosition(pipe.getX(), pipe.getY());
        }
        canvas.draw();
    }
    
    
    


 
    public static void main(String[] args) {
        flappyBird game = new flappyBird();
        game.gameLoop();
    }
}





