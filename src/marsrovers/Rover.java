
package marsrovers;

/**
 * Rover represents the mars rover. 
 * 
 * @author markhebberd@gmail.com
 */
public class Rover {
    
    RoverPosition position;
    
    protected Rover(RoverPosition rp){
        this.position = rp;
    }
    
    /**
     * rotateRoverRight turns rover clockwise
     */
    private void rotateRoverRight() {
        if (null != position.getDirection()) switch (position.getDirection()) {
            case N:
                position.setDirection(Direction.E);
                break;
            case E:
                position.setDirection(Direction.S);
                break;
            case S:
                position.setDirection(Direction.W); 
                break;
            case W:
                position.setDirection(Direction.N);
                break;
            default:
                break;
        }
    }

    /**
     * rotateRoverLeft turns rover anticlockwise
     */
    private void rotateRoverLeft() {
        if (null != position.getDirection()) switch (position.getDirection()) {
            case N:
                position.setDirection(Direction.W); 
                break;
            case E:
                position.setDirection(Direction.N);
                break;
            case S:
                position.setDirection(Direction.E);
                break;
            case W:
                position.setDirection(Direction.S);
                break;
            default:
                break;
        }
    }
    
    /**
     * moveRover steps rover forward one position based on direction 
     */
    private void moveRover()  {
        position.setxPosition(position.getxPosition() + position.getDirection().getxPositionChange() );
        position.setyPosition(position.getyPosition() + position.getDirection().getyPositionChange() );
    }

    /**
     * moveRover accepts a movement character and changes the position of the 
     * rover using moveRover(), rotateRoverRight() & rotateRoverLeft()
     * 
     * @param movement - character containing movement information
     * @param debugOutput - if true will print position for each movement of the rover.
     */
    protected void moveRover(char movement, boolean debugOutput) {
            
        switch (movement) {
            //move
            case 'M':
                moveRover();
                if (debugOutput) {
                    System.out.println("Rover Moved");
                    printRoverPosition();
                }
                break;
            //move
            case 'R':
                rotateRoverRight();
                if (debugOutput) {
                    System.out.println("Rover Turned Right");
                    printRoverPosition();
                }
                break;
            case 'L':
                rotateRoverLeft();
                if (debugOutput) {
                    System.out.println("Rover Turned Left");
                    printRoverPosition();
                }
                break;
            default:
                System.out.println("invalid movement string, must contain only 'M', 'L' or 'R'");
                break;
        }
    }
    
    /**
     * Prints rover position in the form; "1 2 N"
     */
    protected void printRoverPosition() {
        System.out.println(position.getxPosition() + " " + position.getyPosition() 
                + " " + position.getDirection());
    }
}
