
package marsrovers;


/**
 * Console application for "Mars Rovers" programming challenge. 
 *
 * @author markhebberd@gmail.com
 */
public class Main {
    
    /**
     * @param args
     * @throws marsrovers.OutOfBoundsException
     */
    
    
    public static void main(String[] args) throws OutOfBoundsException {
        
        //create plateau and Nasa Control Center
        int[] plateauSize = {5,5};
        PlateauGrid plateauGrid = new PlateauGrid( plateauSize) ;
        NasaControlCenter nasaControlCenter = new NasaControlCenter(plateauGrid);
        
        // start Rover one
        Rover rover = new Rover( new RoverPosition(1, 2, Direction.N) );
        nasaControlCenter.setRover( rover );
        
        nasaControlCenter.moveRover("LMLMLMLMM", false);
        nasaControlCenter.getRover().printRoverPosition();
        

        // start second rover
        rover = new Rover( new RoverPosition(3, 3, Direction.E) );
        nasaControlCenter.setRover(rover);
        
        nasaControlCenter.moveRover("MMRMMRMRRM", false);
        nasaControlCenter.getRover().printRoverPosition();

    }    
}
