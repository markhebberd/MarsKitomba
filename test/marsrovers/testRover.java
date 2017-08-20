
package marsrovers;

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
 * @author markh
 */
public class testRover {
    int[] gridSize= {5,5};
    PlatauGrid pg = new PlatauGrid( gridSize );
    RoverPosition rp = new RoverPosition(0,0,Direction.N);
    Rover rover = new Rover(rp);
    
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
        pg.setRover(rover);
    }
    
    @After
    public void tearDown() {
        gridSize = null;
        pg = null;
        rp = null;
        rover = null;
    }

    @Test
    public void testRoverTurnRight() throws OutOfBoundsException {         
        pg.moveRover("R", false);
        assertEquals(rover.position.getDirection(), Direction.E);
    }
    
    @Test
    public void testRoverTurnLeft() throws OutOfBoundsException { 
        pg.moveRover("L", false);
        assertEquals(rover.position.getDirection(), Direction.W);
    }
    
    @Test
    public void testRoverTurnRight360() throws OutOfBoundsException { 
        pg.moveRover("RRRR", false);
        assertEquals(rover.position.getDirection(), Direction.N);
    }
    
    @Test
    public void testRoverTurnLeft360() throws OutOfBoundsException { 
        pg.moveRover("LLLL", false);
        assertEquals(rover.position.getDirection(), Direction.N);
    }
    
    @Test
    public void testRoverTurnRightatEachCorner() throws OutOfBoundsException { 
        pg.moveRover("MMMMMRMMMMMRMMMMMRMMMMM", false);
        assertEquals(rover.position.getDirection(), Direction.W);
        assertEquals(rover.position.getxPosition(), 0);
        assertEquals(rover.position.getyPosition(), 0);
    }
    
    @Test(expected=OutOfBoundsException.class)
    public void testOutOfBoundsExceptionWest() throws OutOfBoundsException { 
        pg.moveRover("LM", false);
    }
    
    @Test(expected=OutOfBoundsException.class)
    public void testOutOfBoundsExceptionNorth() throws OutOfBoundsException { 
        pg.moveRover("MMMMMM", false);
    }
    
    @Test(expected=OutOfBoundsException.class)
    public void testOutOfBoundsExceptionSouth() throws OutOfBoundsException { 
        pg.moveRover("LLM", false);
    }
    
    @Test(expected=OutOfBoundsException.class)
    public void testOutOfBoundsExceptionEast() throws OutOfBoundsException { 
        pg.moveRover("RMMMMMM", false);
    }
    
}
