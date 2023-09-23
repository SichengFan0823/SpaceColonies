// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- sichengfan
package spacecolonies;

import student.TestCase;

/**
 * Class for Planet is a method class.
 * 
 * @author Sicheng Fan
 * @version <11/11/2021>
 */
public class SpaceColonyDataExceptionTest extends TestCase {
    /**
     * a set up method
     */
    public void setUp() {
        // this method is empty
    }


    /**
     * testException method
     */
    public void testException() {
        SpaceColonyDataException exception = new SpaceColonyDataException(
            "message");
        assertTrue(exception instanceof SpaceColonyDataException);
        assertEquals("message", exception.getMessage());

    }
}
