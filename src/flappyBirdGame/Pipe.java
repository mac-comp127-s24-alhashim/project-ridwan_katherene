package flappyBirdGame;
import edu.macalester.graphics.Image;
//import java.math.*;
import edu.macalester.graphics.CanvasWindow;
//import flappyBirdGame.Bird;
//import java.awt.Graphics;
//import java.awt.image.BufferedImage;

public class Pipe  {
//     // the pipes can't touch each other, generate at different heights, induce the game to stop if the bird touches

    private int x;
    private int yTop;
    private int yBottom;
    private Image bottomPipeImage;
    private Image topPipeImage;
    private final int SPEED = 2;
    private final double width;
    private final double height;
    //private Random random;
    //private flappyBird game;
    private static final int gap = 200;
    //private static final int max = 457;
    private final CanvasWindow canvas;
    //private static final int height;
//     //speed of pipes

        public Pipe(int x, int yTop, int yBottom, double width, double height, Image topPipeImage, Image bottomPipeImage, 
        CanvasWindow canvas) {
                this.canvas = canvas;
                this.x = x;
                this.yTop = generateRandomYTop();
                this.yBottom = yBottom + gap;
                this.width = width;
                //this.gap = gap;
                //this.SPEED = speed;
                this.height = height;
                this.topPipeImage = topPipeImage;
                this.bottomPipeImage = bottomPipeImage;
                topPipeImage = new Image("upwardPipe.png");
                bottomPipeImage = new Image ("bottomPipe.png");
                // updateImages();
                //this.game = game;
                //random = new Random();

                //this.topPipeImage = topPipeImage;
                //this.bottomPipeImage = bottomPipeImage;
                //this.topPipeImage = topPipeImage;
                //this.bottomPipeImage = bottomPipeImage;       
                }       
        public void move () {
                x -= SPEED;
                if(yBottom<=0){
                        resetPipe();
                }
                        updateImages();
                }
//         //moves pipe to left decreasing x- coordinate


        public double getX(){
                return x;
        }
        public int generateRandomYTop(){
                int maxTop = (int)(getCanvasHeight() - height - gap);
                return(int)(Math.random()+ maxTop);
        }
        private int getCanvasHeight(){
                return canvas.getHeight();
        }
        public int getYBottom(){
                return yBottom;

        } 
        public double getWidth(){
        return width;
        }
        public double getHeight(){
                return height;
        }
        public boolean collisionWithPipe(Bird bird) {
                //checks if bird collides with pipe
                double birdX= bird.getX();
                double birdY = bird.getY();
                double birdWidth = bird.getWidth();
                double birdHeight = bird.getHeight();
                
                return (birdX < x + width && birdX + birdWidth > x &&
                (birdY < yTop + height || birdY + birdHeight > yBottom));
                       
        }
        public int getYTop(){
                return yTop;
        }
        private int getCanvasWidth(){
                return canvas.getWidth(); 
        }
        public void updateImages(){
                topPipeImage.setPosition(x,generateRandomYTop());
                bottomPipeImage.setPosition(x, yBottom);
        }
        public Image getTopPipeImage(){
                return topPipeImage;
        }
        public Image getBottomPipeImage(){
                return bottomPipeImage;
        }
        public void resetPipe(){
                this.x = getCanvasWidth();
                yTop = generateRandomYTop();
                yBottom = yTop + gap;
        }


 }





