
package marsrovers;

/**
 *
 * @author markhebberd@gmail.com
 */
public class NasaControlCenter {
    private PlateauGrid plateauGrid;
    private Rover rover;
    
    /**
     * Constructor of NasaControlCenter
     * @param plateauGrid 
     */
    protected NasaControlCenter(PlateauGrid plateauGrid) {
        this.plateauGrid = plateauGrid;
    }
    
    /**
     * 
     * @param movements - string representing movements for rover to complete, Must contain only 'M', 'R' & 'L'
     * @param debugOutput - if true will print position for each movement of the rover. 
     * @throws OutOfBoundsException - thrown if rover steps outside plateau. 
     */
    protected void moveRover(String movements, boolean debugOutput) throws OutOfBoundsException {
        for (char movement: movements.toCharArray()){ 
            rover.moveRover(movement, debugOutput);

            int rxp = rover.position.getxPosition();
            int ryp = rover.position.getyPosition();

            if (rxp < 0 || rxp > plateauGrid.width || ryp < 0 || ryp > plateauGrid.height ){
                throw new OutOfBoundsException("Rover outside Plateau at position " + rxp + " " + ryp + " " + rover.position.getDirection());
            }
        } 
    }
    
    // Getters and setters for plateauGrid and rover. 
    
    protected PlateauGrid getPlateauGrid() {
        return plateauGrid;
    }

    protected void setPlateauGrid(PlateauGrid plateauGrid) {
        this.plateauGrid = plateauGrid;
    }

    protected void setRover(Rover rover) {
        this.rover = rover;
    }
    
    protected Rover getRover() {
        return rover;
    }
    
}


