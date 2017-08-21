
package marsrovers;


/**
 *
 * @author markh
 */
public class PlateauGrid {
    
    GridSquare[][] arrayGridSquares2D;
    int width, height;

    protected PlateauGrid(int[] plateauSize) {
        
        //create an array of gridsquares
        this.width = plateauSize[0];
        this.height = plateauSize[1];
        arrayGridSquares2D = new GridSquare[ width ][ height ];
        
        //initialise the gridsquares 
        for (int i=0; i < plateauSize[0]; i++){
            for (int j=0; j < plateauSize[1]; j++){
                if (arrayGridSquares2D[i][j] != null){
                    arrayGridSquares2D[i][j] = new GridSquare(); 
                }
            }            
        }
    }
}
