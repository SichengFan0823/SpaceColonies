// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- sichengfan
package spacecolonies;

/**
 * Class for Person is a method class.
 * 
 * @author Sicheng Fan
 * @version <11/11/2021>
 */
public class Person {
    private String name;
    private Skillset skill;
    private String planetPreference;

    /**
     * Three skills
     * 
     * @param name
     *            people's name
     * @param agri
     *            agricultural
     * @param medi
     *            medicinal
     * @param tech
     *            technological
     * @param planet
     *            planet's name
     */
    public Person(String name, int agri, int medi, int tech, String planet) {
        skill = new Skillset(agri, medi, tech);
        this.name = name;
        planetPreference = planet;
    }


    /**
     * getName method
     * 
     * @return people's name
     */
    public String getName() {
        return name;
    }


    /**
     * getSkills method
     * 
     * @return type of skill
     */
    public Skillset getSkills() {
        return skill;
    }


    /**
     * getPlanetName method
     * 
     * @return the planet's name that people prefer
     */
    public String getPlanetPreference() {

        return planetPreference;
    }


    /**
     * toString method
     * 
     * @return person as string type
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name + " " + skill.toString());
        if (planetPreference.length() > 0) {
            builder.append(" Wants: " + planetPreference);
        }
        else {
            builder.insert(0, "No-Planet ");

        }
        return builder.toString();
    }


    /**
     * To check if two names are equal
     * 
     * @param obj
     *            type
     * @return return true if two names are equal
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            Person p = (Person)obj;
            return p.getName().equals(this.getName()) && p.getPlanetPreference()
                .equals(this.getPlanetPreference()) && (p.getSkills().equals(
                    this.getSkills()));
        }
        return false;
    }
}
