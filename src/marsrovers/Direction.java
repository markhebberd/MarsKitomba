
package marsrovers;

/**
 *
 * @author markh
 */
public enum Direction {

    /**
     *
     */
    N   ( 0,     1),
    S   ( 0,    -1),
    E   ( 1,     0),
    W   (-1,     0);
    
    
    private final int xPositionChange;
    private final int yPositionChange;

    public int getxPositionChange() {
        return xPositionChange;
    }

    public int getyPositionChange() {
        return yPositionChange;
    }
    
    Direction(int x ,int y){
        this.xPositionChange = x;
        this.yPositionChange = y;
    }
}
