package flappyBirdGame;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.CanvasWindow;

public class UpwardPipe extends Image{
    double x;
    private double y;
    private final double width;
    private final double height;
    private static final int gap = 200;
    private boolean passed = false;

        public UpwardPipe(double x, double y, double width, double height) {
                super("upwardPipe.png");
                this.x = x;
                this.y = y;
                this.width = width;
                this.height = height;   
                }  

        
                   
        // public void move () {
        //         x -= SPEED;
        //         if(y<=0){
        //                 resetPipe();
        //         }
        //                 updateImages();
        //         }


        // public double getX(){
        //         return x;
        // }
        // public int generateRandomYTop(){
        //         int maxTop = (int)(getCanvasHeight() - height - gap);
        //         return(int)(Math.random()+ maxTop);
        // }
        // private int getCanvasHeight(){
        //         return canvas.getHeight();
        // }
        // public int getYBottom(){
        //         return yBottom;

        // } 
        // public double getWidth(){
        // return width;
        // }
        // public double getHeight(){
        //         return height;
        // }
        // public boolean collisionWithPipe(Bird bird) {
        //         //checks if bird collides with pipe
        //         double birdX= bird.getX();
        //         double birdY = bird.getY();
        //         double birdWidth = bird.getWidth();
        //         double birdHeight = bird.getHeight();
                
        //         return (birdX < x + width && birdX + birdWidth > x &&
        //         (birdY < y + height || birdY + birdHeight > y));
                       
        // }
        // public int getYTop(){
        //         return yTop;
        // }
        // private int getCanvasWidth(){
        //         return canvas.getWidth(); 
        // }
        // public void updateImages(){
        //         topPipeImage.setPosition(x,generateRandomYTop());
        //         bottomPipeImage.setPosition(x, yBottom);
        // }
        // public Image getTopPipeImage(){
        //         return topPipeImage;
        // }
        // public Image getBottomPipeImage(){
        //         return bottomPipeImage;
        // }
        // public void resetPipe(){
        //         this.x = getCanvasWidth();
        //         yTop = generateRandomYTop();
        //         yBottom = yTop + gap;
        // }


 }





