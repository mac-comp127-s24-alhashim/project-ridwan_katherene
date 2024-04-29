package flappyBirdGame;
import edu.macalester.graphics.Image;
import java.awt.Graphics;


public class Bird extends Image {
    private double x;
    private double y;
    private double width;
    private double height;
    private int velocity;
    private Image birdImage;
    private boolean isAlive;
    private final int GRAVITY = -1;
    private final int jumpHeight = -10;
    private double y2;
    private double y3;
  
    //the constant  GRAVITY represnts force pulling bird down 


    public Bird(double x, double y, double width, double height){
        super(x,y,"flappyBird.png");

        // height = y;
        // y3 = y;
        // y2 = y;
        // setCenter(width * 0.5,height * 0.5);
        setMaxWidth(width);
        setMaxHeight(height);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        isAlive = true;
        // Image birdy = new Image("flappyBird.png");
        // Bird bird = new Bird(50,200, 50,50, birdImage);
    }
    public void fall() {
        y += velocity;
        velocity += GRAVITY;
    }
    public boolean isAlive() {
        return isAlive;
    }
    public void jumpBird(){
        velocity = jumpHeight;
    }
    public void updatePosition(){
        fall();
        if (y < 0) {
            y = 0;
            velocity = 0; // Prevent negative velocity after hitting top
        } else if (y + height > getHeight()) {
            isAlive = false;
        }
    }
    public void checkBounds(int canvasHeight) {
        if (y < 0) {
            y= 0; 
        } else if (y + height > canvasHeight) {
            y = canvasHeight - height; 
            }
        }
    public boolean collisionWithPipe(Pipe pipe){
                 if (x + width >= pipe.getX() && x <= pipe.getX() + pipe.getWidth() &&
                         y >= pipe.getYTop() && y + height <= pipe.getYBottom ()) {
                    isAlive = false;
                    return true;
                 }
                 return false;
    }
  
    public Image getBirdImage(){
        return birdImage;
    }
    public void newUpdatePosition() {
        fall();
        if (y < 0) {
            y = 0;
            velocity = 0; 
        } else if (y + height > getHeight()) { 
            isAlive = false;
        }
    }
}

