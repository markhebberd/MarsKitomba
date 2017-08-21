
package marsrovers;

/**
 * GridSquare represents a single coordinate location
 * 
 * GridSquare is currently unused but it seemed smarter to write it in now
 * rather than having to rewrite the surrounding code at a later date.
 * 
 * @author markhebberd@gmail.com
 */


public class GridSquare {
    private boolean explored;

    protected GridSquare() {
        explored = false;
    }

    //getters and setters
    
    public boolean isExplored() {
        return explored;
    }

    protected void setExplored(boolean explored) {
        this.explored = explored;
    }
}
