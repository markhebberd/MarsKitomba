
package marsrovers;

/**
 * OutOfBoundsException extends Exception to demonstrate when rover is outside 
 * given coordinates. 
 * 
 * @author markhebberd@gmail.com
 */
public class OutOfBoundsException extends Exception {

    /**
     * Creates a new instance of <code>OutOfBoundsException</code> without
     * detail message.
     */
    public OutOfBoundsException() {
    }

    /**
     * Constructs an instance of <code>OutOfBoundsException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public OutOfBoundsException(String msg) {
        super(msg);
    }
}
