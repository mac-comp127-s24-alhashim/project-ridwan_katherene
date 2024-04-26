package flappyBirdGame;
import edu.macalester.graphics.Image;

//import java.awt.Canvas;
//import java.awt.Graphics;
//import flappyBirdGame.flappyBird;
///import flappyBirdGame.Pipe;
///import edu.macalester.graphics.CanvasWindow;

public class Bird  extends Image{
    private double x;
    private double y;
    private double width;
    private double height;
    private int velocity;
    private Image birdImage;
    private boolean isAlive;
    private final int GRAVITY = -1;
    private final int jumpHeight = -10;
  
    //the constant  GRAVITY represnts force pulling bird down 


    public Bird(double x, double y, double width, double height, Image birdImage){
        // paramteres
        //super(birdImage.getImagePath());
        super("flappyBird.png");
        setMaxWidth(width);
        setMaxHeight(height);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.birdImage = new Image("flappyBird.png");
        isAlive= true;
       // birdImage = new Image("flappyBird.png");
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
        if (y< 0) {
            y = 0;
            velocity = 0; 
        } else if (y + height > getHeight()) {
            
            isAlive = false;
        }
}
}


//     public void fall(){           


    
//     public updatePosition(){
//         y += velocity;
//         velocity += GRAVITY;
//         //updates birds veloicty by adding garvity
//     //public void fall(){

//     }

//     public void jump(){

//         velocity = 10;
//         //velpocity ten when it jumps
        
//     }
//     public boolean collisionwithPipe(Pipe pipe){
//         if (this.y >= pipe.getYTop()&& this.y <= pipe.getYBottom()){
//             //the bird's Y coordinate equals the pipe's Y coordinate
//             return true;
//         }
//         return false;
//         //Y coordinate does not equal the pipe's Y coordinate
//     }
//     public void draw(Graphics g){
//         g.drawImage(birdImage, x,y, width, height, null);
//         // draws the bird on the screen.
//     }
//     //do bounds
// }

// }

