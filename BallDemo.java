import java.awt.Color;
import java.util.HashSet;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Bill Crosbie
 * @version 2015-March-BB
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    
    int boxWidth = 550;
    int boxHeight = 600;
    
    int canvasWidth = 700;
    int canvasHeight = 700;
    
    int xLoc = 10;
    int yLoc = 10;
    
    HashSet<BoxBall> balls = new HashSet<BoxBall>();
    
    private Random randomGen;
    

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", canvasWidth, canvasHeight);
        
        randomGen= new Random();
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numberOfBalls)
    {
        myCanvas.setVisible(true);
        
        boxBounce(numberOfBalls);

        // make them bounce
        boolean finished =  false;
        
        while(!finished) {
            myCanvas.wait(50);           // small delay
            
            for(BoxBall boxBall : balls) {
                
                boxBall.move();
            
            // stop once ball has travelled a certain distance on x axis
                if(boxBall.getXLocation() >= boxHeight + 30 * numberOfBalls) {
                    finished = true;
                }
            }
        }
    }
            
    
    private void boxBounce(int numberOfBalls) {
        
        myCanvas.boxBounce(xLoc, yLoc, boxWidth, boxHeight);
        
        for(int i = 0; i < numberOfBalls; i++) {
            int x = randomPosition();
            int y = randomPosition();
            
            BoxBall boxBall = new BoxBall(x, y, 16, Color.BLUE, boxWidth, boxHeight, myCanvas);
            
            balls.add(boxBall);
            
            boxBall.draw();
        }
    }
    
    private int randomPosition() {
        int pos = (int) (boxHeight);
        
        return randomGen.nextInt(pos);
    }
}
