// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- sichengfan
package spacecolonies;

import java.util.Arrays;
import list.AList;

/**
 * Class for Planet is a method class.
 * 
 * @author Sicheng Fan
 * @version <11/11/2021>
 */
public class ColonyCalculator {
    /**
     * number of planets in the colony
     */
    public static final int NUM_PLANETS = 3;
    /**
     * minimum number of skill level
     */
    public static final int MIN_SKILL_LEVEL = 1;
    /**
     * maximum number of skill level
     */
    public static final int MAX_SKILL_LEVEL = 5;

    private ArrayQueue<Person> applicantQueue;
    private AList<Person> rejectBus;
    private static Planet[] planets = new Planet[NUM_PLANETS + 1];

    /**
     * ColonyCalculator class
     * 
     * @param person
     *            person type
     * @param planet
     *            an array of planets
     */
    public ColonyCalculator(ArrayQueue<Person> person, Planet[] planet) {
        if (person == null) {
            throw new IllegalArgumentException("the queue is empty");
        }
        rejectBus = new AList<Person>();
        this.applicantQueue = person;
        ColonyCalculator.planets = planet;
    }


    /**
     * getQueue method
     * 
     * @return the queue of applicants
     */
    public ArrayQueue<Person> getQueue() {
        return applicantQueue;
    }


    /**
     * getPlanets method
     * 
     * @return the array for the planets
     */
    public static Planet[] getPlanets() {
        return ColonyCalculator.planets;
    }


    /**
     * getPreferredPlanet method
     * 
     * @param person
     *            people who have planet
     * @param number
     *            the array for the planets
     * @return the number of planets
     */
    private Planet getPreferredPlanet(Person person, int number) {
        if (number != 0 && ColonyCalculator.planets[number].isQualified(
            person)) {
            return ColonyCalculator.planets[number];
        }
        return null;
    }


    /**
     * getMostAvailablePlanet method
     * 
     * @param person
     *            people be added
     * @return the planets added
     */
    private Planet getMostAvailablePlanet(Person person) {
        Planet[] planet = Arrays.copyOfRange(planets, 1, planets.length);
        Arrays.sort(planet);
        for (int i = planet.length - 1; i > 0; i--) {
            if (planet[i].isQualified(person) && !planet[i].isFull()) {
                return planetByNumber(getPlanetIndex(planet[i].getName()));
            }
        }
        return null;
    }


    /**
     * getPlanetForPerson method
     * 
     * @param nextPerson
     *            the next person
     * @return the planet which is available
     */
    public Planet getPlanetForPerson(Person nextPerson) {

        if (nextPerson == null || applicantQueue.isEmpty()) {
            return null;
        }
        int i = getPlanetIndex(nextPerson.getPlanetPreference());
        if (i == 0) {
            return getMostAvailablePlanet(nextPerson);
        }
        return getPreferredPlanet(nextPerson, i);

    }


    /**
     * accept method
     * 
     * @return return true
     */
    public boolean accept() {
        if (!applicantQueue.isEmpty()) {
            Person firstPerson = applicantQueue.getFront();
            Planet preferredPlanet = getPlanetForPerson(firstPerson);
            if (preferredPlanet != null && preferredPlanet.addPerson(
                firstPerson)) {
                applicantQueue.dequeue();
                return true;
            }
        }
        return false;
    }


    /**
     * reject method
     */
    public void reject() {
        rejectBus.add(applicantQueue.dequeue());
    }


    /**
     * planetByNumber method
     * 
     * @param planet
     *            number of planets
     * @return the array of the planet
     */
    public Planet planetByNumber(int planet) {
        if (planet >= 1 && planet < ColonyCalculator.NUM_PLANETS + 1) {
            return ColonyCalculator.planets[planet];
        }
        return null;
    }


    /**
     * getPlanetIndex method
     * 
     * @param planet
     *            number of planets
     * @return the index of the planet
     */
    public int getPlanetIndex(String planet) {
        for (int i = 1; i < planets.length; i++) {
            if (planets[i].getName().equals(planet)) {
                return i;
            }
        }
        return 0;
    }
}
