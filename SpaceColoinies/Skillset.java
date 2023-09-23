// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- sichengfan
package spacecolonies;

/**
 * Class for Skillset is a method class.
 * 
 * @author Sicheng Fan
 * @version <11/11/2021>
 */
public class Skillset {
    private int agriculture;
    private int medicine;
    private int technology;

    /**
     * return these three skills
     * 
     * @param ag
     *            agricultural
     * @param med
     *            medicinal
     * @param tec
     *            technological
     */
    public Skillset(int ag, int med, int tec) {
        this.agriculture = ag;
        this.medicine = med;
        this.technology = tec;
    }


    /**
     * getAgriculture method
     * 
     * @return agriculture
     */
    public int getAgriculture() {
        return agriculture;
    }


    /**
     * getMedicine method
     * 
     * @return medicine
     */
    public int getMedicine() {
        return medicine;
    }


    /**
     * getTechnology method
     * 
     * @return technology
     */
    public int getTechnology() {
        return technology;
    }


    /**
     * isLessThanOrEqualTo methid
     * 
     * @param other
     *            parameter
     * @return returns true if these three are below and equal the given
     */
    public boolean isLessThanOrEqualTo(Skillset other) {
        return this.agriculture <= other.agriculture
            && this.medicine <= other.medicine
            && this.technology <= other.technology;
    }


    /**
     * a string method
     * 
     * @return strings
     */
    public String toString() {
        return "A:" + this.getAgriculture() + "M:" + this.getMedicine() + this
            .getTechnology();
    }


    /**
     * equals method
     * 
     * @param obj
     *            the type
     * @return return true if three skills are equal
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            return (this.agriculture == (((Skillset)obj).agriculture))
                && (this.medicine == (((Skillset)obj).medicine))
                && (this.technology == (((Skillset)obj).technology));
        }
        return false;
    }


    /**
     * compareTo method
     * 
     * @param skills
     *            the type
     * @return return zero based on the sum
     */
    public int compareTo(Skillset skills) {
        return 0;
    }
}
