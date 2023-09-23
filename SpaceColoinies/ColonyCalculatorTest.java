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
public class ColonyCalculatorTest extends TestCase {
    private Planet[] planet;
    private ColonyCalculator calculator;
    private ArrayQueue<Person> queue1;

    /**
     * a set up method
     */
    public void setUp() {
        planet = new Planet[4];
        queue1 = new ArrayQueue<Person>();
        planet[1] = new Planet("Earth", 1, 2, 1, 6);
        planet[2] = new Planet("Moon", 3, 4, 5, 6);
        planet[3] = new Planet("Mars", 1, 2, 2, 7);
        Person person1 = new Person("a", 2, 3, 4, "Mars");
        Person person2 = new Person("b", 2, 3, 4, "Venus");
        queue1.enqueue(person1);
        queue1.enqueue(person2);
        calculator = new ColonyCalculator(queue1, planet);
        Exception exception = null;
        try {
            calculator = new ColonyCalculator(null, planet);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);
    }


    /**
     * testGetQueue method
     */
    public void testGetQueue() {
        assertEquals(queue1, calculator.getQueue());
    }


    /**
     * testGetPlanet method
     */
    @SuppressWarnings("static-access")
    public void testGetPlanet() {
        assertEquals(planet, calculator.getPlanets());
    }


    /**
     * testGetPlanetForPerson method
     */
    public void testGetPlanetForPerson() {
        Person a = new Person("a", 5, 5, 5, "");
        assertEquals(planet[3], calculator.getPlanetForPerson(a));
        assertEquals(null, calculator.getPlanetForPerson(null));

        Person b = new Person("b", 5, 5, 5, "");
        assertEquals(planet[3], calculator.getPlanetForPerson(b));

        Person c = new Person("c", 1, 1, 1, "Venus");
        assertNull(calculator.getPlanetForPerson(c));

        Person d = new Person("d", 1, 1, 1, "Moon");
        assertNull(calculator.getPlanetForPerson(d));

        Person e = new Person("e", 6, 1, 1, "");
        assertNull(calculator.getPlanetForPerson(e));
        queue1.clear();
        for (int i = 0; i < 10; i++) {
            queue1.enqueue(new Person("a", 6, 1, 1, ""));
        }
        assertFalse(calculator.accept());
        queue1.clear();
        Person x = null;
        assertNull(calculator.getPlanetForPerson(x));
    }


    /**
     * testAccept method
     */
    public void testAccept() {
        assertTrue(calculator.accept());
        queue1.clear();
        assertFalse(calculator.accept());
        Person i = new Person("a", 6, 6, 6, "");
        queue1.enqueue(i);
        assertTrue(calculator.accept());

    }


    /**
     * testPlanetByNumber method
     */
    public void testPlanetByNumber() {
        assertEquals(planet[1].toString(), calculator.planetByNumber(1)
            .toString());
        assertNull(calculator.planetByNumber(8));
        assertNull(calculator.planetByNumber(0));

    }


    /**
     * testReject method
     */
    public void testReject() {
        Person person = new Person("a", 3, 3, 3, "");
        queue1.enqueue(person);
        calculator.accept();
        calculator.accept();
        calculator.reject();
        assertFalse(calculator.accept());
        assertTrue(calculator.accept());
    }


    /**
     * testGetPlanetIndex method
     */
    public void testGetPlanetIndex() {
        assertEquals(1, calculator.getPlanetIndex("Venus"));
        assertEquals(0, calculator.getPlanetIndex("d"));
    }
}
