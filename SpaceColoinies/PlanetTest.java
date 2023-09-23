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
public class PlanetTest extends TestCase {
    private Planet planet1;
    private Planet planet2;
    private Planet planet3;

    /**
     * a set up method
     */
    public void setUp() {
        planet1 = new Planet("earth", 2, 6, 7, 8);
        planet2 = new Planet("moon", 3, 4, 5, 6);
        planet3 = new Planet("", 3, 4, 5, 6);
    }


    /**
     * testSetName method
     */
    public void testSetName() {
        planet3.setName("add");
        assertEquals("add", planet3.getName());
    }


    /**
     * testGetName method
     */
    public void testGetName() {
        assertEquals("earth", planet1.getName());
        assertEquals("moon", planet2.getName());
        assertEquals("", planet3.getName());
    }


    /**
     * testGetSkills method
     */
    public void testGetSkills() {
        Skillset skill1 = new Skillset(2, 6, 7);
        assertEquals(skill1, planet1.getSkills());
    }


    /**
     * testGetPopulation method
     */
    public void testGetPopulation() {
        assertEquals(7, planet1.getPopulation().length);
    }


    /**
     * testGetPopulationSize method
     */
    public void testGetPopulationSize() {
        assertEquals(0, planet1.getPopulationSize());
    }


    /**
     * testGetCapacity method
     */
    public void testGetCapacity() {
        assertEquals(7, planet1.getCapacity());
    }


    /**
     * testGetAvailability method
     */
    public void testGetAvailability() {
        assertEquals(7, planet1.getAvailability());
    }


    /**
     * testIsFull method
     */
    public void testIsFull() {
        assertFalse(planet1.isFull());
        Person person1 = new Person("a", 6, 6, 6, "");
        for (int i = 0; i < 9; i++) {
            planet1.addPerson(person1);
        }
        assertTrue(planet1.isFull());
    }


    /**
     * testIsQualified method
     */
    public void testIsQualified() {
        Person person1 = new Person("a", 6, 6, 6, "");
        Person person2 = new Person("b", 1, 1, 1, "");
        assertTrue(planet1.isQualified(person1));
        assertFalse(planet1.isQualified(person2));
    }


    /**
     * testAddPerson method
     */
    public void testAddPerson() {
        Person person1 = new Person("a", 6, 6, 6, "");
        Person person2 = new Person("b", 1, 1, 1, "");
        assertTrue(planet1.addPerson(person1));
        assertFalse(planet1.addPerson(person2));
        for (int i = 0; i < 9; i++) {
            planet1.addPerson(person1);
        }
        assertFalse(planet1.addPerson(person1));
    }


    /**
     * testToString method
     */
    public void testToString() {
        assertEquals("earth, population 0 (cap: 8)", planet1.toString());
    }


    /**
     * testGetCompareTo method
     */
    public void testGetCompareTo() {
        assertEquals(-8, planet2.compareTo(planet1));
        assertEquals(8, planet1.compareTo(planet2));
        assertEquals(0, planet2.compareTo(planet2));
        Planet planet4 = null;
        Exception exception = null;
        try {
            planet1.compareTo(planet4);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);
    }


    /**
     * testGetCompareTo method
     */
    public void testEquals() {
        String a = "c";
        String b = null;
        assertFalse(planet1.equals(b));
        assertTrue(planet1.equals(planet1));
        assertFalse(planet1.equals(planet2));
        assertFalse(planet1.equals(a));
        Planet planet4 = new Planet("x", 2, 6, 7, 8);
        assertFalse(planet1.equals(planet4));
        Planet planet5 = new Planet("earth", 2, 6, 7, 8);
        assertTrue(planet1.equals(planet5));
        Person person1 = new Person("i", 5, 5, 5, "earth");
        planet1.addPerson(person1);
        assertTrue(planet1.equals(planet5));
        Planet planet6 = new Planet("x", 1, 6, 7, 8);
        assertFalse(planet4.equals(planet6));
        Planet planet7 = new Planet("x", 2, 5, 7, 8);
        assertFalse(planet4.equals(planet7));
        Planet planet8 = new Planet("x", 2, 6, 8, 8);
        assertFalse(planet4.equals(planet8));
        Planet planet9 = new Planet("x", 2, 6, 7, 10);
        assertFalse(planet4.equals(planet9));
        assertEquals(0, planet1.getPopulationSize());

    }
}
