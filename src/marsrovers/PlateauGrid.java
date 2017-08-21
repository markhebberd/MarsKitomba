
package marsrovers;


/**
 * PlateauGrid represents the Plateau in memory. 
 * 
 * @author markhebberd@gmail.com
 */
public class PlateauGrid {
    
    private GridSquare[][] arrayGridSquares2D;
    private int width, length;

    /**
     * Constructor for PlateauGrid
     * 
     * @param plateauSize - integer array which the first value is the width and the 
     * second value is the length of the plateau. 
     */
    protected PlateauGrid(int[] plateauSize) {
        
        //create an array of gridsquares
        this.width = plateauSize[0];
        this.length = plateauSize[1];
        arrayGridSquares2D = new GridSquare[ width ][ length ];
        
        //initialise the gridsquares 
        for (int i=0; i < plateauSize[0]; i++){
            for (int j=0; j < plateauSize[1]; j++){
                if (arrayGridSquares2D[i][j] != null){
                    arrayGridSquares2D[i][j] = new GridSquare(); 
                }
            }            
        }
    }
    
    //Getters of width and length of plateau. 
    
    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }
}
