    
/**
 * This class will draw a rectangle around a certain area.
 * Afterwards, it will add 5 to 30 balls that will bounce randomly
 * at random speeds.
 * 
 * @author Alexis Dominguez
 * @version 3/24/19
 */

import java.awt.*;
import java.awt.geom.*;

public class BoxBall
{
    // instance variables - replace the example below with your own
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xLocation;
    private int yLocation;
    private final int height;
    private final int width;
    private Canvas canvas;
    private int xVelocity;
    private int yVelocity;
    private int const_Distance = 10;

    /**
     * Constructor for objects of class BoxBall
     * @param xLoc is the horizontal coordinate of the ball
     * @param yLoc is the vertical coordinate of the ball
     * @param ballDiameter is the diameter of the ball 
     * @param ballColor is the color of the ball
     * @param box_width is the width of the rectangle
     * @param box_height is the height of the rectangle
     * @param Canvas draws the canvas that this will go on
     */
    public BoxBall(int xLoc, int yLoc, int ballDiameter, Color ballColor,
                    int box_width, int box_height, Canvas drawingCanvas)
    {
        if(xLoc >= box_width) {
            xLocation = xLoc - const_Distance;
        }else {
            xLocation = xLoc;
        }
        
        if(yLoc >= box_height) {
            yLocation = yLoc - const_Distance;
        }else {
            yLocation = yLoc;
        }
        
        color = ballColor;
        diameter = ballDiameter;
        width = box_width;
        height = box_height;
        canvas = drawingCanvas;
        xVelocity = (int) (Math.random() * 20) + 1;
        yVelocity = (int) (Math.random() * 20) + 1;
    }
    
    /**
     * Draws the ball at its current position on the canvas.
     */
    public void draw() {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xLocation, yLocation, diameter);
    }
    
    /**
     * Erase this ball at its current position.
     */
    public void erase() {
        canvas.eraseCircle(xLocation, yLocation, diameter);
    }
    
    /**
     * Move this ball according to its speed and redraw the ball at its new
     * location.
     */
    public void move() {
        
        //removes old position.
        erase();
        
        //defines radius
        int r = diameter / 2;
        
        //sets position with respect to velocity
        yLocation += yVelocity;
        xLocation += xVelocity;
        
        //if the x location of the ball is less than zero
        //then alter the speed of the ball
        if (xLocation - r - const_Distance < 0) {
            xVelocity = -xVelocity;
            xLocation = r + const_Distance;
        }
        
        //if x location of the ball is greater than or equal to the width
        //then alter the speed of the ball
        else if(xLocation + r >= width) {
            xVelocity = -xVelocity;
            xLocation = width - r;
        }
        
        //if the y location of the ball is less than zero
        //then alter the speed of the ball
        if (yLocation - r - const_Distance < 0) {
            yVelocity = -yVelocity;
            yLocation = r + const_Distance;
        }
        
        //if the y location of the ball is greater than or equal to the height
        //then alter the speed of the ball
        else if (yLocation + r >= height) {
            yVelocity = -yVelocity;
            yLocation = height - r;
        }
        
        draw();
        
    }
    
    /**
     * Returns horizontal position of the ball
     * @return int - location of ball
     */
    public int getXLocation() {
        return xLocation;
    }
    
    /**
     * Returns vertical position of the ball
     * @returns int - location of ball
     */
    public int getYLocation() {
        return yLocation;
    }
 
}


