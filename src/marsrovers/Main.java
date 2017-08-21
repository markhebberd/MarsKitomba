
package marsrovers;


/**
 *
 * @author markhebberd@gmail.com
 */
public class Main {
    
    /**
     * @param args
     * @throws marsrovers.OutOfBoundsException
     */
    
    
    public static void main(String[] args) throws OutOfBoundsException {
        
        int[] plateauSize = {5,5};
        PlateauGrid plateauGrid = new PlateauGrid( plateauSize) ;
        NasaControlCenter nasaControlCenter = new NasaControlCenter(plateauGrid);
        
        // start Rover one
        Rover rover = new Rover( new RoverPosition(1, 2, Direction.N) );
        nasaControlCenter.setRover( rover );
        
        moveRover(nasaControlCenter, "LMLMLMLMM", false); 
        nasaControlCenter.getRover().printRoverPosition();
        

        // start second rover
        rover = new Rover( new RoverPosition(3, 3, Direction.E) );
        nasaControlCenter.setRover(rover);
        
        moveRover(nasaControlCenter, "MMRMMRMRRM", false);
        nasaControlCenter.getRover().printRoverPosition();

    }

    
    private static void moveRover(NasaControlCenter nasaControlCenter, String movements, boolean printDebugOutput) {
         try{
            nasaControlCenter.moveRover(movements, printDebugOutput); 
        }
        catch (OutOfBoundsException OOB){
            System.out.println(OOB);
        }
    }
    
}
