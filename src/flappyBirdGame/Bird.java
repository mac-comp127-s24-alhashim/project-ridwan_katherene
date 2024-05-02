package flappyBirdGame;
import edu.macalester.graphics.Image;
import java.awt.Graphics;
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
        velocity = -6;
        this.y += velocity;
        this.setCenter(new Point(this.x, this.y));
        // velocity += gravity;
        // this.y += velocity;
    }


    public void jumpBird(){
        System.out.println("jump bird");
        this.newUpdatePosition(); 
    }
    public void updatePosition(){
        System.out.println("Update position");
        if (y < 0) {
            y = 0;
            velocity = 0;
        } else if (y + height > getHeight()) {
            isAlive = false;
        }
    }
  
    public void newUpdatePosition() {
        System.out.println("new Update position");
    }
}

