// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- sichengfan
package spacecolonies;

import student.TestCase;

/**
 * Class for Person is a method class.
 * 
 * @author Sicheng Fan
 * @version <11/11/2021>
 */
public class PersonTest extends TestCase {
    private Person p1;
    private Person p2;
    private Person p3;
    private Skillset skill;

    /**
     * a set up method
     */
    public void setUp() {
        p1 = new Person("Peter", 2, 3, 4, "earth");
        p2 = new Person("Jack", 2, 3, 4, "");
        skill = new Skillset(3, 4, 5);
    }


    /**
     * testGetName method
     */
    public void testGetName() {
        assertEquals("Peter", p1.getName());
    }


    /**
     * testGetSkills method
     */
    public void testGetSkills() {
        assertEquals(3, skill.getAgriculture());
        assertEquals(4, skill.getMedicine());
        assertEquals(5, skill.getTechnology());
    }


    /**
     * testGetPlanetPreference method
     */
    public void testGetPlanetPreference() {
        assertEquals("earth", p1.getPlanetPreference());
    }


    /**
     * testToString method
     */
    public void testToString() {
        assertEquals("Peter A:2 M:3 T:4 Wants: earth", p1.toString());
        assertEquals("No-Planet Jack A:2 M:3 T:4", p2.toString());
    }


    /**
     * testEquals method
     */
    public void testEquals() {
        String a = "i";
        assertTrue(p1.equals(p1));
        assertFalse(p1.equals(p3));
        assertFalse(p1.equals(p2));
        assertFalse(p1.equals(a));
        Person person4 = new Person("Peter", 1, 2, 3, "");
        Person person5 = new Person("Peter", 1, 2, 3, "");
        assertFalse(p1.equals(person4));
        assertTrue(person4.equals(person5));
        Person person6 = new Person("Peter", 2, 2, 3, "");
        assertFalse(person4.equals(person6));
    }
}
