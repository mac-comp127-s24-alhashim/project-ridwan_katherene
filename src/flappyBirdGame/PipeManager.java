package flappyBirdGame;

//mport java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class PipeManager {
    UpwardPipe upwardPipe;
    ArrayList<UpwardPipe> upwardPipes;
    ArrayList<BottomPipe> bottomPipes;
    Random random = new Random();
    BottomPipe bottomPipe;

    public PipeManager(){
        double velocityX = 0;
        for(UpwardPipe upwardPipe: upwardPipes){
            upwardPipe.x += velocityX;
        }
        for(BottomPipe bottomPipe: bottomPipes){
            bottomPipe.x += velocityX;
        }

        

    }


    


    
}
