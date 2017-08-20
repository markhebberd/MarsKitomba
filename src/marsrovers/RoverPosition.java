
package marsrovers;

/**
 *
 * @author markh
 */
public class RoverPosition {
    private int xPosition;
    private int yPosition;
    private Direction direction;
    
    public RoverPosition(int xPosition, int yPosition, Direction direction) {
    this.xPosition = xPosition;
    this.yPosition = yPosition;
    this.direction = direction;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
}
