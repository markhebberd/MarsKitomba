
package marsrovers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author markhebberd@gmail.com
 */
public class testRover {
    int[] gridSize= {5,5};
    PlateauGrid pg = new PlateauGrid( gridSize );
    RoverPosition rp = new RoverPosition(0,0,Direction.N);
    Rover rover = new Rover(rp);
    NasaControlCenter nasaControlCenter = new NasaControlCenter(pg);
    
    public testRover() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        nasaControlCenter.setRover(rover);
    }
    
    @After
    public void tearDown() {
        gridSize = null;
        pg = null;
        rp = null;
        rover = null;
        nasaControlCenter = null;
    }

    @Test
    public void testRoverTurnRight() throws OutOfBoundsException {         
        nasaControlCenter.moveRover("R", false);
        assertEquals(rover.position.getDirection(), Direction.E);
    }
    
    @Test
    public void testRoverTurnLeft() throws OutOfBoundsException { 
        nasaControlCenter.moveRover("L", false);
        assertEquals(rover.position.getDirection(), Direction.W);
    }
    
    @Test
    public void testRoverTurnRight360() throws OutOfBoundsException { 
        nasaControlCenter.moveRover("RRRR", false);
        assertEquals(rover.position.getDirection(), Direction.N);
    }
    
    @Test
    public void testRoverTurnLeft360() throws OutOfBoundsException { 
        nasaControlCenter.moveRover("LLLL", false);
        assertEquals(rover.position.getDirection(), Direction.N);
    }
    
    @Test
    public void testRoverTurnRightatEachCorner() throws OutOfBoundsException { 
        nasaControlCenter.moveRover("MMMMMRMMMMMRMMMMMRMMMMM", false);
        assertEquals(rover.position.getDirection(), Direction.W);
        assertEquals(rover.position.getxPosition(), 0);
        assertEquals(rover.position.getyPosition(), 0);
    }
    
    @Test(expected=OutOfBoundsException.class)
    public void testOutOfBoundsExceptionWest() throws OutOfBoundsException { 
        nasaControlCenter.moveRover("LM", false);
    }
    
    @Test(expected=OutOfBoundsException.class)
    public void testOutOfBoundsExceptionNorth() throws OutOfBoundsException { 
        nasaControlCenter.moveRover("MMMMMM", false);
    }
    
    @Test(expected=OutOfBoundsException.class)
    public void testOutOfBoundsExceptionSouth() throws OutOfBoundsException { 
        nasaControlCenter.moveRover("LLM", false);
    }
    
    @Test(expected=OutOfBoundsException.class)
    public void testOutOfBoundsExceptionEast() throws OutOfBoundsException { 
        nasaControlCenter.moveRover("RMMMMMM", false);
    }
    
}
