import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.events.Key;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FlappyBird extends CanvasWindow {

    private Bird bird;
    private List<Pipe> pipes;
    private Scoreboard scoreboard;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private JButton resetButton;
    private final String FRAME_TITLE = "Flappy Bird";

    public FlappyBird() {
        super("Flappy Bird", WINDOW_WIDTH, WINDOW_HEIGHT);
        setupGame();
        createGUI();
    }
    private void createGUI(){
        JPanel panel = new JPanel(new BorderLayout());
        resetButton = new JButton("reset Game");
        resetButton.addActionListener(e-> resetGame());
        panel.add(resetButton);
        add(panel, BorderLayout.SOUTH);
        //borderPane.setBottom(resetGame);
        //borderPane.setAlignment(resetButton, Pos.CENTER);


        animate();
    }      
    private void setupGame(){
        background = new Image("backgroundImage.png");
        add(background);
        bird = new Bird(100,200,50, 50, new Image ("flappyBird.png"));
            add(bird);
            pipes = new ArrayList<>();
            createPipe();
            scoreboard = new Scoreboard(this);
            add(scoreboard);
            
            onKeyPress(event-> {
                if(event.getKey()==Key.SPACE){
                    bird.jump();
                }
            });
    }
    private void createPipe(){
        int gap = 200;
        int pipeWidth = 50;
        int pipeHeight = 300;
        int randomGapPosition = (int)(Math.random()*(getHeight()-gap-pipeHeight));
        int pipeX = getWidth();
        int pipeYTop = randomGapPosition;
        int pipeYBottom = randomGapPosition + gap + pipeHeight;
        Pipe pipe = new Pipe(pipeX, pipeYTop, pipeYBottom, pipeWidth, pipeHeight, new Image("upward.png"), new Image("bottomPipe.png"));
        //(pipeX, pipeYTop, pipeYBottom, pipeWidth, pipeHeight, 
        //new Image ("upward.png"), new Image ("bottomPipe.png"));
        add(pipe);
        pipes.add(pipe);
    }
    //private void jump(Event event){
       // bird.jump();
    //}
    public void checkCrash(){
        for(Pipe pipe: pipes){
            if(bird.collisionwithPipe(pipe)){
                JOptionPane.showMessageDialog(null,"Game over");
                resetGame();
                return;

            }
        if(bird.getY()>= getHeight()|| bird.getY()<=0){
                JOptionPane.showMessageDialog(null, "Game Over");
        
                resetGame();
                return;

        }
        }
        
    }
    private void resetGame() {
        bird.setPosition(100,200);
        pipes.clear();
        createPipe();
        scoreboard.resetScore();
        //this.canvas.getGame().restart();
        //this.canvas.update();
    }
    public void animate(){
        while(true){
            bird.updatePosition();
            for(Pipe pipe: pipes){
                pipe.move();

            }
            checkCrash();
            try{
                Thread.sleep(20);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
   
    }
    public static void main(String[] args) {
        FlappyBird flappyBird = new FlappyBird();
       //flappyBird.run();
    }
    

