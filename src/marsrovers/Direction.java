
package marsrovers;

/**
 * Direction represents cardinal directions North, South, East & West
 * 
 * xPositionChange: x coordinate change if rover moves facing in this direction
 * yPositionChange: y coordinate change if rover moves facing in this direction
 * 
 * @author markhebberd@gmail.com
 */
public enum Direction {

    N   ( 0,  1),
    S   ( 0, -1),
    E   ( 1,  0),
    W   (-1,  0);
    
    private final int xPositionChange;
    private final int yPositionChange;

    protected int getxPositionChange() {
        return xPositionChange;
    }

    protected int getyPositionChange() {
        return yPositionChange;
    }
    
    Direction(int x ,int y){
        this.xPositionChange = x;
        this.yPositionChange = y;
    }
}
