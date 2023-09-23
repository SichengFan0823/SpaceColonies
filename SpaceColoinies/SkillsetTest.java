// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- sichengfan
package spacecolonies;

import student.TestCase;

/**
 * Class for SkillsetTest is a test method class.
 * 
 * @author Sicheng Fan
 * @version <11/11/2021>
 */
public class SkillsetTest extends TestCase {
    private Skillset skill1;
    private Skillset skill2;
    private Skillset skill3;
    private Skillset skill4;

    /**
     * a set up method
     */
    public void setUp() {
        skill1 = new Skillset(2, 3, 4);
        skill2 = new Skillset(1, 2, 3);
        skill3 = new Skillset(3, 4, 5);
        skill4 = new Skillset(3, 4, 5);
    }


    /**
     * testGetAgriculture method
     */
    public void testGetAgriculture() {
        assertEquals(2, skill1.getAgriculture());
    }


    /**
     * testGetMedicine method
     */
    public void testGetMedicine() {
        assertEquals(3, skill1.getMedicine());
    }


    /**
     * testGetTechnology method
     */
    public void testGetTechnology() {
        assertEquals(4, skill1.getTechnology());
    }


    /**
     * testIsLessThanOrEqualTo method
     */
    public void testIsLessThanOrEqualTo() {
        assertTrue(skill2.isLessThanOrEqualTo(skill1));
        assertFalse(skill3.isLessThanOrEqualTo(skill1));
        assertTrue(skill3.isLessThanOrEqualTo(skill4));
        Skillset a = new Skillset(2, 3, 3);
        assertTrue(a.isLessThanOrEqualTo(skill1));
        Skillset b = new Skillset(2, 2, 4);
        assertFalse(skill1.isLessThanOrEqualTo(b));
        Skillset c = new Skillset(1, 3, 4);
        assertFalse(skill1.isLessThanOrEqualTo(c));
        Skillset d = new Skillset(2, 4, 5);
        assertTrue(skill1.isLessThanOrEqualTo(d));
        Skillset e = new Skillset(1, 3, 5);
        assertFalse(skill1.isLessThanOrEqualTo(e));
        Skillset f = new Skillset(1, 3, 4);
        assertFalse(skill1.isLessThanOrEqualTo(f));
    }


    /**
     * testToString method
     */
    public void testToString() {
        assertEquals("A:1 M:2 T:3", skill2.toString());
    }


    /**
     * testEquals method
     */
    public void testEquals() {
        String a = null;
        String b = "i";
        assertFalse(skill1.equals(skill2));
        assertTrue(skill3.equals(skill4));
        assertTrue(skill2.equals(skill2));
        assertFalse(skill2.equals(a));
        assertFalse(skill2.equals(b));
        skill4 = new Skillset(4, 4, 5);
        assertFalse(skill3.equals(skill4));
        Skillset skilla = new Skillset(2, 3, 3);
        assertFalse(skilla.equals(skill1));
        Skillset skillb = new Skillset(2, 2, 4);
        assertFalse(skill1.equals(skillb));
        Skillset skillc = new Skillset(1, 3, 4);
        assertFalse(skill1.equals(skillc));
        Skillset skilld = new Skillset(2, 4, 5);
        assertFalse(skill1.equals(skilld));
        Skillset skille = new Skillset(1, 3, 5);
        assertFalse(skill1.equals(skille));
        Skillset skillf = new Skillset(1, 3, 4);
        assertFalse(skill1.equals(skillf));
    }


    /**
     * testEquals method
     */
    public void testCompareTo() {
        assertTrue(skill2.isLessThanOrEqualTo(skill1));
        assertFalse(skill3.isLessThanOrEqualTo(skill1));
        assertTrue(skill3.isLessThanOrEqualTo(skill4));
    }
}
