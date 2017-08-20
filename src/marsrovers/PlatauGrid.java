
package marsrovers;


/**
 *
 * @author markh
 */
public class PlatauGrid {
    
    Rover rover;
    GridSquare[][] arrayGridSquares2D;
    int width, height;

    public PlatauGrid(int[] platauSize) {
        
        //create an array of gridsquares
        this.width = platauSize[0];
        this.height = platauSize[1];
        arrayGridSquares2D = new GridSquare[ width ][ height ];
        
        //initialise the gridsquares 
        for (int i=0; i < platauSize[0]; i++){
            for (int j=0; j < platauSize[1]; j++){
                if (arrayGridSquares2D[i][j] != null){
                    arrayGridSquares2D[i][j] = new GridSquare(); 
                }
            }            
        }
    }

    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }

    void moveRover(String movements, boolean debugOutput) throws OutOfBoundsException {
        for (char movement: movements.toCharArray()){ 
            rover.moveRover(movement, debugOutput);
            
            int rxp = rover.position.getxPosition();
            int ryp = rover.position.getyPosition();
            
            if (rxp < 0 || rxp > width || ryp < 0 || ryp > height ){
                throw new OutOfBoundsException("Rover outside Platau at position " + rxp + " " + ryp + " " + rover.position.getDirection());
            }
        } 
    }
}
