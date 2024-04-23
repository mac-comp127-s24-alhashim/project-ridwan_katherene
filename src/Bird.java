import edu.macalester.graphics.Image;
//import java.awt.Graphics;

public class Bird {
    private int x;
    private int y;
    private int width;
    private int height;
    private int velocity;
    private Image birdImage;
    private final int GRAVITY = -1;
    //the constant  GRAVITY represnts force pulling bird down 


    public Bird(int x, int y, int width, int height, Image birdImage) {
        //paramteres
        //super("flappyBird.png");
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.birdImage = birdImage;
        Image birdy = new Image("flappyBird.png");
        Bird bird = new Bird(50,200, 50,50, birdImage);
    }
    public void fall(){           


    
    public void updatePosition(){
        y += velocity;
        velocity += GRAVITY;
        //updates birds veloicty by adding garvity
    //public void fall(){

    }

    public void jump(){

        velocity = 10;
        //velpocity ten when it jumps
        
    }
    public Image getBirdImage(){
        return birdImage;
    }
    public boolean collisionwithPipe(Pipe pipe){
        if (this.y >= pipe.getYTop()&& this.y <= pipe.getYBottom()){
            //the bird's Y coordinate equals the pipe's Y coordinate
            return true;
        }
        return false;
        //Y coordinate does not equal the pipe's Y coordinate
    }
    //do bounds
}
}

