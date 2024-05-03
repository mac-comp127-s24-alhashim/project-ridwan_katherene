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
        private static final double SPEED = 2.0;
        private CanvasWindow canvas;
    
            public UpwardPipe(double x, double yTop, double yBottom, double width, double height, Image topPipe, Image bottomPipe, CanvasWindow canvas ) {
                    super("upwardPipe.png");
                    this.x = x;
                    this.y = yTop;
                    this.width = width;
                    this.height = height;  
             } 

        
                   
            public void move () {
                     x -= SPEED;
                     if(x+width <=0){
                       resetPipe();
                }
            }
            private void resetPipe() {
              
                x = canvas.getWidth(); 
            
                y = Math.random() * (canvas.getHeight() - gap - height); // Adjust as needed
            }
            
                    
          


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

        public Image getTopPipeImage(){
                return this;
                    // return topPipeImage;
            }
         public Image getBottomPipeImage(){
                return this;
                    // return bottomPipeImage;
            }
        // public void resetPipe(){
        //         this.x = getCanvasWidth();
        //         yTop = generateRandomYTop();
        //         yBottom = yTop + gap;
        // }


 }





