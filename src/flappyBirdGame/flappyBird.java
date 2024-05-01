package flappyBirdGame;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import java.awt.Color;
import edu.macalester.graphics.GraphicsText;  
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.events.KeyboardEvent;
import javax.swing.*;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class FlappyBird {

    private Bird bird;
    //private List <Pipe> pipes;
    private scoreboard scoreboard;
    private CanvasWindow canvas;
    private int WINDOW_WIDTH = 600;
    private int WINDOW_HEIGHT = 600;
    private static final int PIPES_INTERVAL = 250;
    private Image topPipeImage;
    private Image bottomPipeImage;
    private Image backgroundImage;
    //rivate static final double GRAVITY = 0.5;
    private List<Pipe> pipes = new ArrayList<>();
    private boolean isStartScreen;

    public FlappyBird() {
        this.isStartScreen = true;
        backgroundImage = new Image(0, 0, "backgroundImage.png");
        WINDOW_WIDTH = (int)backgroundImage.getWidth();
        WINDOW_HEIGHT = (int)backgroundImage.getHeight();

        canvas = new CanvasWindow("By Ridwan Osman and Katherene Lugo", WINDOW_WIDTH, WINDOW_HEIGHT);
        
        canvas.setBackground(new Color(153, 204, 255));
        canvas.onKeyDown(event -> onKeyPress(event));
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
                // canvas.remove(startScreenBackground);
                // canvas.remove(startButtonImage);
                // canvas.remove(startScreenBanner);
                // gameLoop();
            }
        });
        canvas.animate(() -> gameLoop());

        
        // bottomPipeImage = new Image("bottomPipe.png");
        // topPipeImage = new Image("upwardPipe.png");
       


        // pipes = new ArrayList<>();
        // // scoreboard = new scoreboard(canvas);
        // canvas.onKeyDown(event-> {
        //     if (event.getKey() == Key.SPACE) {

        //         bird.newUpdatePosition(); 
        //         bird.jumpBird();
        //     }
        // });
       
        // startScreen();
        // gameLoop();
        
        // canvas.add(scoreboard);
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




        // GraphicsText instructions = new GraphicsText("Press SPACE to start");
        // instructions.setFontSize(30);
        // instructions.setPosition(WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2 + 50 );
        // instructions.setFillColor(Color.WHITE);
        // canvas.add(instructions);
        // canvas.onKeyDown(event -> {
        //     if (event.getKey() == Key.SPACE) {
        //         isStartScreen = false;
        //         canvas.remove(startScreenBackground);
        //         canvas.remove(startButtonImage);
        //         canvas.remove(startScreenBanner);
        //         // gameLoop();
        //     }
        // });
        

    }
    private void createPipe(){
        int gap = 200;
        int pipeWidth = 20;
        int pipeHeight = 300;
        int randomGapPosition = (int)(Math.random()*(canvas.getHeight()-gap-pipeHeight));
        int pipeX = canvas.getWidth();
        int pipeYTop = randomGapPosition;
        int pipeYBottom = randomGapPosition + gap + pipeHeight;
        if (topPipeImage == null) {
            topPipeImage = new Image("upwardPipe.png");
        }
        if (bottomPipeImage == null) {
            bottomPipeImage = new Image("bottomPipe.png");
        }
        Pipe pipe = new Pipe(pipeX, pipeYTop, pipeYBottom, pipeWidth, pipeHeight, topPipeImage, bottomPipeImage, canvas);
        pipe.updateImages();
        pipes.add(pipe);
        canvas.add(pipe.getTopPipeImage());
        canvas.add(pipe.getBottomPipeImage());

       
    }
    public void checkCrash(){
        for(Pipe pipe: pipes){
            if(bird.collisionWithPipe(pipe)){
                JOptionPane.showMessageDialog(null, "Game over");
                resetGame();
                return;
            }
            if (bird.getY() >= canvas.getHeight() || bird.getY() <= 0){

            }
        }
        if(bird.getY() >= canvas.getHeight() || bird.getY() <= 0){
            JOptionPane.showMessageDialog(null,"Game Over");
            resetGame();
            
        }
    }
    public void resetGame() {
        //for (Pipe pipe : pipes){
           /// pipes.remove(pipe);
        //}
        pipes.clear();
        bird.setPosition(100,200);
        scoreboard.resetScore();
        //resetPipe();
        createPipe();
        //canvas.remove((GraphicsObject) pipes);
        // Assuming your CanvasWindow or bird object has these methods to reset the game
        // this.canvas.getGame().restart();
        // this.canvas.update();
    }
    public CanvasWindow getCanvas(){
        return canvas;
    }
    //public GraphicsObject createGraphicsObject(){
       // return null;
    //}
    public void move(){
        
        for(Pipe pipe: pipes){
            pipe.move();
            pipe.getTopPipeImage().setPosition(pipe.getX(),pipe.generateRandomYTop());
            pipe.getBottomPipeImage().setPosition(pipe.getX(), pipe.getYBottom());
        }
        canvas.draw();
    }
   

    public void gameLoop(){
        
        if(isStartScreen){
            startScreen();
            return;
        }
        else{
            canvas.setBackground(new Color(153, 204, 255));
        // canvas.onKeyDown(event -> onKeyPress(event));
        backgroundImage.setMaxHeight(WINDOW_HEIGHT);
        backgroundImage.setMaxWidth(WINDOW_WIDTH);
        canvas.add(backgroundImage);
     

        bird = new Bird(canvas.getWidth() * 0.5,canvas.getHeight() * 0.5, 50,50);
        bird.setCenter(canvas.getWidth() * 0.5,canvas.getHeight() * 0.5 );
        canvas.add(bird);
        bottomPipeImage = new Image("bottomPipe.png");
        topPipeImage = new Image("upwardPipe.png");
       

        pipes = new ArrayList<>();
        // scoreboard = new scoreboard(canvas);
        canvas.onKeyDown(event-> {
            if (event.getKey().equals(Key.SPACE)) {
                System.out.println("Hi Hi");

                // bird.newUpdatePosition(); 
                bird.jumpBird();
            }
        });
       
        

        int frameCount = 0;
        // bird.move();
        bird.newUpdatePosition(); 
        bird.checkBounds(canvas.getHeight());
        canvas.add(bird);
        createPipe();
        Iterator<Pipe> pipes_I = pipes.iterator();
        while(pipes_I.hasNext()){
            Pipe pipe = pipes_I.next();
            pipe.move();
            if (frameCount % PIPES_INTERVAL == 0) {
            }
            if (bird.collisionWithPipe(pipe) || 
                bird.getY() < 0 || bird.getY() >= canvas.getHeight()) {
                JOptionPane.showMessageDialog(null, "Game Over");
                resetGame();
                return;
                }
        } 
        canvas.draw();
        frameCount++;
        try{
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }
    
        
    
    private void onKeyPress(KeyboardEvent event){
        if(event.getKey() == Key.SPACE){
            System.out.println("keyPressEvent");
            bird.jumpBird();
        }
     }
    


   
    public static void main(String[] args) {
        FlappyBird game = new FlappyBird();
    }
}





