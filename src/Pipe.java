import edu.macalester.graphics.Image;
import java.awt.Graphics;

public class Pipe  extends Image{
    // the pipes can't touch each other, generate at different heights, induce the game to stop if the bird touches
    // the pipes
    private int x;
    private int yTop;
    private int yBottom;
    private Image bottomPipeImage;
    private Image topPipeImage;
    private final int SPEED = 2;
    private int width;
    private int height;
    //private static final int gap
    //private static final int max 
    //private static final int height
    //speed of pipes

    public Pipe(int x, int yTop, int yBottom, int width, int height, 
    Image topPipeImage, Image bottomPipeImage) {
       // super("bottomPipe.png");
        //super(path: "upwardPipe.png");
        //initlizeing variables
        this.x = x;
        this.yTop = yTop;
        this.yBottom = yBottom;
        this.width = 50;
        this.speed = 2;
        this.height = height;
        this.topPipeImage = topPipeImage;
        this.bottomPipeImage = bottomPipeImage;
        topPipeImage = new Image( "upwardPipe.png");
        bottomPipeImage = new Image ("bottomPipe.png");

        //this.topPipeImage = topPipeImage;
        //his.bottomPipeImage = bottomPipeImage;
    }
    public void move () {
        x -= SPEED;
        //moves pipe to left decreasing x- coordinate

    }
    public boolean collisionPipe(Bird bird) {
        //checks if bird collides with pipe
        int birdX= bird.getX();
        int birdY = bird.getY();
        int birdWidth = bird.getWidth();
        int birdHeight = bird.getHeight();
        
        for(int y = yTop; y <= yBottom + height; y++){
            if(birdX < x +width && birdX + birdWidth> x &&
            birdY < y + height && birdY + birdHeight> y ){
                return true;
            }
        }
        return false;
    }
    public int getX(){
        return x;
    public int getYTop(){
        return yTop;
    }
    public int getYBottom(){
            return yBottom;

    } 
    public int getWidth(){
        return width;
    }
    public int getHiegth(){
        return height;
    }
    public void draw(Graphics g){
        g.drawImage(topPipeImage, x, yTop, width, height, null);
        //draws images
        g.drawImage(bottomPipeImage, x, yBottom, width, height, null);

    }
}


