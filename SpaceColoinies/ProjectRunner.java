package spacecolonies;

import java.io.FileNotFoundException;
import bsh.ParseException;

/**
 * Class for Planet is a method class.
 * 
 * @author Sicheng Fan
 * @version <11/11/2021>
 */
public class ProjectRunner {
    /**
     * main method to run the code
     * 
     * @param args
     * @throws SpaceColonyDataException
     * @throws ParseException
     * @throws FileNotFoundException
     */
    @SuppressWarnings("unused")
    public static void main(String[] args)
        throws FileNotFoundException,
        ParseException,
        SpaceColonyDataException {
        ColonyReader colonyReader;
        if (args.length >= 2) {
            colonyReader = new ColonyReader(args[0], args[1]);
        }
        else {
            colonyReader = new ColonyReader("planets.txt",
                "inputAllAccept.txt");
        }
    }

}
