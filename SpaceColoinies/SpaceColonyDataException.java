//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, 
//nor will I accept the actions of those who do.
//-- sichengfan
package spacecolonies;

/**
 * Class for Planet is a method class.
 * @author Sicheng Fan
 * @version <11/11/2021>
 */
@SuppressWarnings("serial")
public class SpaceColonyDataException extends Exception {
    /**
     * Constructor with string message
     * @param string
     *            the type of value
     */
    public SpaceColonyDataException(String string) 
    {
        super(string);
    }
}
