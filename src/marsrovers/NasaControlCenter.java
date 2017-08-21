
package marsrovers;

/**
 * NasaControlCenter manages the movement of the rover on the plateau. 
 * 
 * @author markhebberd@gmail.com
 */
public class NasaControlCenter {
    private PlateauGrid plateauGrid;
    private Rover rover;
    
    /**
     * NasaControlCenter constructor
     * 
     * @param plateauGrid - plateauGrid that NasaControlCenter will manage. 
     */
    protected NasaControlCenter(PlateauGrid plateauGrid) {
        this.plateauGrid = plateauGrid;
    }
    
    /**
     * moveRover transmits each movement to the rover and checks to ensure rover not outside the plateau. 
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

            if (rxp < 0 || rxp > plateauGrid.getWidth() || ryp < 0 || ryp > plateauGrid.getLength() ){
                throw new OutOfBoundsException("Rover outside Plateau at position " + rxp + " " + ryp + " " + rover.position.getDirection());
            }
        } 
    }
    
    // Getters and setters of local variables. 
    
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


