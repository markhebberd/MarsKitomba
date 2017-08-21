
package marsrovers;

/**
 * RoverPosition contains coordinate position and direction information of a rover. 
 * 
 * @author markh
 */
public class RoverPosition {
    private int xPosition;
    private int yPosition;
    private Direction direction;
    
    /**
     * Constructor for RoverPosition. 
     * 
     * @param xPosition - x (width) position of the rover on plateau
     * @param yPosition - y (length) position of tehe rover on plateau
     * @param direction - cardinal direction the rover is facing.
     */
    protected RoverPosition(int xPosition, int yPosition, Direction direction) {
    this.xPosition = xPosition;
    this.yPosition = yPosition;
    this.direction = direction;
    }
    
    
    //Getters and setters of local variables
    
    protected int getxPosition() {
        return xPosition;
    }

    protected void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    protected int getyPosition() {
        return yPosition;
    }

    protected void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    protected Direction getDirection() {
        return direction;
    }

    protected void setDirection(Direction direction) {
        this.direction = direction;
    }
    
}
