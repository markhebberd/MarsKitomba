
package marsrovers;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

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
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    
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
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        
    }
    
    @After
    public void tearDown() {
        gridSize = null;
        pg = null;
        rp = null;
        rover = null;
        nasaControlCenter = null;
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    
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
    
    @Test
    public void testOutOfBoundsExceptionWest() throws OutOfBoundsException { 
        expectedEx.expect(OutOfBoundsException.class);
        expectedEx.expectMessage("Rover outside Plateau at position -1 0 W");
        nasaControlCenter.moveRover("LM", false);
    }
    
    @Test
    public void testOutOfBoundsExceptionNorth() throws OutOfBoundsException { 
        expectedEx.expect(OutOfBoundsException.class);
        expectedEx.expectMessage("Rover outside Plateau at position 0 6 N");
        nasaControlCenter.moveRover("MMMMMM", false);
    }
    
    @Test
    public void testOutOfBoundsExceptionSouth() throws OutOfBoundsException { 
        expectedEx.expect(OutOfBoundsException.class);
        expectedEx.expectMessage("Rover outside Plateau at position 0 -1 S");
        nasaControlCenter.moveRover("LLM", false);
    }
    
    @Test
    public void testOutOfBoundsExceptionEast() throws OutOfBoundsException {
        expectedEx.expect(OutOfBoundsException.class);
        expectedEx.expectMessage("Rover outside Plateau at position 6 0 E");
        nasaControlCenter.moveRover("RMMMMMM", false);
        
    }
    
    @Test
    public void testRoverInvalidInput() throws OutOfBoundsException { 
 
        nasaControlCenter.moveRover("P", false);
        final String standardOutput = outContent.toString().trim();
        assertEquals("Invalid movement string, must contain only 'M', 'L' or 'R'", standardOutput);
    }
    
}
