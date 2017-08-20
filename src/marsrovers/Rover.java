
package marsrovers;

/**
 *
 * @author markh
 */
public class Rover {
    
    RoverPosition position;
    
    protected Rover(RoverPosition rp){
        this.position = rp;
    }
    
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
    
    private void moveRover()  {
        position.setxPosition(position.getxPosition() + position.getDirection().getxPositionChange() );
        position.setyPosition(position.getyPosition() + position.getDirection().getyPositionChange() );
    }

    protected void moveRover(char movement, boolean debugOutput) throws OutOfBoundsException {
            
        switch (movement) {
            //move
            case 'M':
                Rover.this.moveRover();
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
    
    protected void printRoverPosition() {
        System.out.println(position.getxPosition() + " " + position.getyPosition() 
                + " " + position.getDirection());
    }
}
