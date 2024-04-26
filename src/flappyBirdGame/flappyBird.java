package flappyBirdGame;
import edu.macalester.graphics.CanvasWindow;
///import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Image;
///import java.awt.Dimension;
import java.awt.Color;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.events.KeyboardEvent;
import flappyBirdGame.Bird;
import flappyBirdGame.Pipe;


///import java.awt.BorderLayout;
///import java.awt.event.ActionEvent;
///import java.awt.event.ActionListener;
//import java.nio.channels.Pipe;
//import scoreboard;
//import javax.swing.Timer;
import javax.swing.*;

///import org.w3c.dom.events.Event;

//import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class flappyBird {

    private Bird bird;
    //private List <Pipe> pipes;
    private scoreboard scoreboard;
    private CanvasWindow canvas;
    private static final int WINDOW_WIDTH = 8000;
    private static final int WINDOW_HEIGHT = 6000;
    private static final int pipesInterval = 250;
    private Image topPipeImage;
    private Image bottomPipeImage;
    private Image backgroundImage;
    //rivate static final double GRAVITY = 0.5;
    private List<Pipe> pipes = new ArrayList<>();

    public flappyBird() {
        canvas = new CanvasWindow("By Ridwan Osman and Katherene", WINDOW_WIDTH, WINDOW_HEIGHT);
        //canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //canvas.setBounds(100,100,450,300);


        canvas.setBackground(new Color(153, 204, 255));
        backgroundImage = new Image(0, 0, "backgroundImage.png");
        canvas.onKeyDown(event -> onKeyPress(event));
        backgroundImage.setMaxHeight(WINDOW_HEIGHT);
        backgroundImage.setMaxWidth(WINDOW_WIDTH);
        canvas.add(backgroundImage);
        //background.set(canvas);


        bird = new Bird(0,0,90, 90, new Image ("flappyBird.png"));
        canvas.add(bird);
        bottomPipeImage = new Image("bottomPipe.png");
        topPipeImage = new Image("upwardPipe.png");

        //pipes = new ArrayList<>();
        createPipe();
        canvas.draw();
        scoreboard = new scoreboard(canvas);
        canvas.onKeyDown(event-> {
            if (event.getKey() == Key.SPACE) {
                bird.jumpBird();
            }
        });
       
        startScreen();
        gameLoop();
        
        //canvas.add(scoreboard);
    }
    public void startScreen(){
        Rectangle startScreenBackground = new Rectangle(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
        startScreenBackground.setFillColor(Color.RED);
        canvas.add(startScreenBackground);
        GraphicsText title = new GraphicsText( "Flappy Bird");
        title.setFontSize(70);
        ///title.setFontbold(true);
        title.setPosition(WINDOW_WIDTH/2- title.getWidth()/2 , WINDOW_HEIGHT/2);
        canvas.add(title);

        GraphicsText instructions = new GraphicsText("Press SPACE to start");
        instructions.setFontSize(30);
        instructions.setPosition(WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2 + 50 );
        instructions.setFillColor(Color.WHITE);
        canvas.add(instructions);


        canvas.onKeyDown(event -> {
            if (event.getKey() == Key.SPACE) {
                canvas.remove(startScreenBackground);
                canvas.remove(title);
                canvas.remove(instructions);
                //gameLoop();
    
           
            
            }
        });
        

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
        //GraphicsObject pipeObject = pipe.createGraphicsObject();
        //topPipeImage = new Image( "upwardPipe.png");
        //bottomPipeImage = new Image ("bottomPipe.png");
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
    public Image getTopPipeImage(){
        return topPipeImage;
    }
    public Image getBottomPipeImage(){
        return bottomPipeImage;
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
        int frameCount = 0;
        while(true){
            bird.newUpdatePosition();
            bird.checkBounds(canvas.getHeight());
            canvas.add(bird.getBirdImage());
            for(Pipe pipe :pipes){
                pipe.move();
                if(pipe.getX()<0){
                    pipes.remove(pipe);
                }

                if (frameCount % pipesInterval == 0) {
                    createPipe();
                }
                if (bird.collisionWithPipe(pipe) || 
                    bird.getY() < 0 || bird.getY() >= canvas.getHeight()) {
                    JOptionPane.showMessageDialog(null, "Game Over");
                    resetGame();
                    break;
                    }
            } 
            canvas.draw();
            frameCount++;
            try{Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            
        }
    private void onKeyPress(KeyboardEvent event){
        if(event.getKey() == Key.SPACE){
            bird.jumpBird();
        }
    }
    


   
    public static void main(String[] args) {
        flappyBird game = new flappyBird();
        game.startScreen();
        game.gameLoop();
    }
}


