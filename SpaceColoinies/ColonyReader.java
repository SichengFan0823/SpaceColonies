//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, 
//nor will I accept the actions of those who do.
//-- sichengfan
package spacecolonies;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import bsh.ParseException;
/**
 * Class for Planet is a method class.
 * @author Sicheng Fan
 * @version <11/11/2021>
 */
public class ColonyReader {
    private Planet[] planets;
    private ArrayQueue<Person> queue;
    
    /**
     * ColonyReader class
     * @param applicantFileName
     * @param planetFileName
     */
    @SuppressWarnings("unused")
    public ColonyReader(String applicantFileName, String planetFileName)
        throws FileNotFoundException,
        ParseException,
        SpaceColonyDataException
    {
        this.queue = readQueueFile(applicantFileName);
        this.planets = readPlanetFile(planetFileName);
        SpaceWindow spaceWindow = new SpaceWindow
            (new ColonyCalculator(this.queue, this.planets));
    }
    
    /**
     * readPlanetFile method
     * @param fileName
     * @return planet
     */
    private Planet[] readPlanetFile(String fileName)
        throws FileNotFoundException,
        ParseException,
        SpaceColonyDataException 
    {
        Planet[] planet = new Planet[ColonyCalculator.NUM_PLANETS + 1];
        Scanner scnr = new Scanner(new File(fileName));
        int i = 1;
        while (scnr.hasNextLine() && i <= ColonyCalculator.NUM_PLANETS) 
        {
            String nextLine = scnr.nextLine();
            String[] array = nextLine.split(", *");
            if (array.length != 5) 
            {
                scnr.close();
                throw new ParseException("Incorrect file format");
            }
            int agri = Integer.parseInt(array[1]);
            int medi = Integer.parseInt(array[2]);
            int tech = Integer.parseInt(array[3]);
            if (!isInSkillRange(agri, medi, tech)) 
            {
                scnr.close();
                throw new SpaceColonyDataException(
                    "Skills are not in range");
            }
            planet[i] = new Planet(array[0], agri, medi, tech, Integer.parseInt(
                array[4]));
            i++;
        }
        scnr.close();
        if (i != ColonyCalculator.NUM_PLANETS + 1) 
        {
            throw new SpaceColonyDataException(
                "Insufficient number of planets");
        }

        return planet;
    }
    
    /**
     * readQueueFile method
     * @param fileName
     * @return the arrayQueue
     */
    private ArrayQueue<Person> readQueueFile(String fileName)
        throws FileNotFoundException,
        ParseException,
        SpaceColonyDataException 
    {
        ArrayQueue<Person> arrayQueue = new ArrayQueue<Person>();
        Scanner scnr = new Scanner(new File(fileName));
        while (scnr.hasNextLine()) 
        {
            String nextLine = scnr.nextLine();
            String[] array = nextLine.split(", *", -1);
            if (array.length != 5) 
            {
                scnr.close();
                throw new ParseException("Incorrect file format");
            }
            int agri = Integer.parseInt(array[1]);
            int medi = Integer.parseInt(array[2]);
            int tech = Integer.parseInt(array[3]);
            if (!isInSkillRange(agri, medi, tech)) 
            {
                scnr.close();
                throw new SpaceColonyDataException(
                    "Skills are not in range");
            }
            arrayQueue.enqueue(new Person(array[0], agri, medi, tech,
                array[4]));
        }
        scnr.close();
        return arrayQueue;
    }
    
    /**
     * readQueueFile method
     * @param num1
     * @param num2
     * @param num3
     */
    private boolean isInSkillRange(int num1, int num2, int num3) {
        return num1 >= ColonyCalculator.MIN_SKILL_LEVEL
            && num1 <= ColonyCalculator.MAX_SKILL_LEVEL
            && num2 >= ColonyCalculator.MIN_SKILL_LEVEL
            && num2 <= ColonyCalculator.MAX_SKILL_LEVEL
            && num3 >= ColonyCalculator.MIN_SKILL_LEVEL
            && num3 <= ColonyCalculator.MAX_SKILL_LEVEL;
    }
}
