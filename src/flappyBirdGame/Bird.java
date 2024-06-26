package flappyBirdGame;
import edu.macalester.graphics.Image;
//import java.awt.Graphics;
import edu.macalester.graphics.Point;


public class Bird extends Image {
    public double x;
    public double y;
    private double width;
    private double height;
    private double velocity;
    private boolean isAlive;
    private double gravity = 4;

    public Bird(double x, double y, double width, double height){
        super(x,y,"flappyBird.png");
        setMaxWidth(width);
        setMaxHeight(height);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        isAlive = true;
    }
    public boolean isAlive() {
        return isAlive;
    }

    public void moveBird(){
        System.out.println("move bird");
        velocity = -1;
        this.y += velocity;
        this.setCenter(new Point(this.x, this.y));
    }
    public boolean updatePosition() {
        double centerX_1 = ((velocity))+ x;
        double centerY_1 = ((velocity))+y;
            if (0<= centerX_1 && centerX_1 <= 0 && 0 <= centerY_1 && centerY_1<=0) {
                x = centerX_1;
                y = centerY_1;
                this.setPosition(x,x);
                velocity = velocity-(gravity);
                return true;
            } 
            return false;
        

        // velocity += gravity;
        // this.y += velocity;
    }

    public boolean collisionWithPipe(UpwardPipe pipe) {
        if (x + width >= pipe.getX() && x <= pipe.getX() + pipe.getWidth() &&
            y >= pipe.getY() && y + height <= pipe.getY()) {
            return true;
        }
        return false;
    }
    public void jumpBird(){
        System.out.println("jump bird");
        this.newUpdatePosition(); 
    }
    // public void updatePosition(){
    //     System.out.println("Update position");
    //     if (y < 0) {
    //         y = 0;
    //         velocity = 0;
    //     } else if (y + height > getHeight()) {
    //         isAlive = false;
    //     }
    // }
  
    public void newUpdatePosition() {
        System.out.println("new Update position");
    }
}

