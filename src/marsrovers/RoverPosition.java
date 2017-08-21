
package marsrovers;

/**
 *
 * @author markh
 */
public class RoverPosition {
    private int xPosition;
    private int yPosition;
    private Direction direction;
    
    protected RoverPosition(int xPosition, int yPosition, Direction direction) {
    this.xPosition = xPosition;
    this.yPosition = yPosition;
    this.direction = direction;
    }

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
