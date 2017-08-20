
package marsrovers;


/**
 *
 * @author markhebberd@gmail.com
 */
public class Main {
    
    /**
     * @throws marsrovers.OutOfBoundsException
     */
    
    
    public static void main(String[] args) throws OutOfBoundsException {
        
        int[] platauSize = {5,5};
        PlatauGrid platauGrid = new PlatauGrid( platauSize) ;

        
        // start Rover one
        Rover rover = new Rover( new RoverPosition(1, 2, Direction.N) );
        platauGrid.setRover( rover );
        
        moveRover( platauGrid, "LMLMLMLMM", false); 
        platauGrid.getRover().printRoverPosition();
        

        // start second rover
        rover = new Rover( new RoverPosition(3, 3, Direction.E) );
        platauGrid.setRover(rover);
        
        moveRover(platauGrid, "MMRMMRMRRM", false);
        platauGrid.getRover().printRoverPosition();

    }

    
    private static void moveRover(PlatauGrid platauGrid, String movements, boolean printDebugOutput) {
         try{
            platauGrid.moveRover(movements, printDebugOutput); 
        }
        catch (OutOfBoundsException OOB){
            System.out.println(OOB);
        }
    }
    
}
