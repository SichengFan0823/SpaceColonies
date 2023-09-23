// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- sichengfan
package spacecolonies;

/**
 * Class for Planet is a method class.
 * 
 * @author Sicheng Fan
 * @version <11/11/2021>
 */
public class Planet implements Comparable<Planet> {
    private String name;
    private Skillset minSkill;
    private Person[] population;
    private int populationSize;
    private int capacity;

    /**
     * Five parameters class
     * 
     * @param planetName
     *            name of the planet
     * @param planetAgri
     *            Agricultural value
     * @param planetMedi
     *            Medicinal value
     * @param planetTech
     *            technological value
     * @param planetCap
     *            capacity for the planet
     */
    public Planet(
        String planetName,
        int planetAgri,
        int planetMedi,
        int planetTech,
        int planetCap) {
        name = planetName;
        capacity = planetCap;
        minSkill = new Skillset(planetAgri, planetMedi, planetTech);
        population = new Person[planetCap];
        populationSize = 0;
    }


    /**
     * setName method
     * 
     * @param planetName
     *            name of the planet
     */
    public void setName(String planetName) {
        this.name = planetName;
    }


    /**
     * getName method
     * 
     * @return name of the planet
     */
    public String getName() {
        return name;
    }


    /**
     * getSkills method
     * 
     * @return the minimum skill
     */
    public Skillset getSkills() {
        return minSkill;
    }


    /**
     * getPopulation method
     * 
     * @return the population
     */
    public Person[] getPopulation() {
        return population;
    }


    /**
     * getPopulationSize method
     * 
     * @return the size of the population
     */
    public int getPopulationSize() {
        return populationSize;
    }


    /**
     * getCapacity method
     * 
     * @return the capacity for the planet
     */
    public int getCapacity() {
        return capacity;
    }


    /**
     * getAvailability method
     * 
     * @return the available planets
     */
    public int getAvailability() {
        return capacity - populationSize;
    }


    /**
     * isFull method
     * 
     * @return the available planets
     */
    public boolean isFull() {
        return populationSize == capacity;
    }


    /**
     * isQualified method to check the qualification
     * 
     * @param person
     *            the person's name
     * @return return true is is qualify
     */
    public boolean isQualified(Person person) {
        return this.getSkills().isLessThanOrEqualTo(person.getSkills());
    }


    /**
     * adds the planet
     * 
     * @param newbie
     *            add people
     * @return return true if people is added
     */
    public boolean addPerson(Person newbie) {
        if (!isFull() && isQualified(newbie)) {
            population[populationSize] = newbie;
            populationSize++;
            return true;
        }
        return false;
    }


    /**
     * toString method
     * 
     * @return the string value
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name + ", ");
        builder.append("the population " + getPopulationSize() + " (cap: "
            + getCapacity() + ")");
        builder.append(", Requires: A>=" + minSkill.getAgriculture() + ", M>="
            + minSkill.getMedicine() + ", T>=" + minSkill.getTechnology()
            + ")");
        return builder.toString();
    }


    /**
     * compareTo method
     * 
     * @return the numbers
     */
    @Override
    public int compareTo(Planet o) {
        if (o == null) {
            throw new IllegalArgumentException();
        }
        return this.getAvailability() - o.getAvailability();
    }


    /**
     * equals method
     * 
     * @param obj
     *            type Object
     * @return return true
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            Planet planet = (Planet)obj;
            return this.getSkills().equals(planet.getSkills()) && this.getName()
                .equals(planet.getName()) && this.getCapacity() == planet
                    .getCapacity() && this.getPopulationSize() == planet
                        .getPopulationSize();
        }
        return false;
    }

}
