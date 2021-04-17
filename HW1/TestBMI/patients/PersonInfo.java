package patients;
import java.util.GregorianCalendar;

/**
 * <p> A container for the data and operations relating to a person's weight.
 */

public class PersonInfo {
    
    /** A {@code String} variable that stores the name of an instance of {@code PersonInfo}. */
    String personName;
    /** An {@code int} variable that stores the year of birth of an instance of {@code PersonInfo}. */
    int personYOB;
    /** A {@code double} variable that stores the height of an instance of {@code PersonInfo} in meters. */
    double personHeight;
    /** A {@code double} variable that stores the height of an instance of {@code PersonInfo} in kilograms. */
    double  personWeight;

    /**Default Class Constructor */
    public PersonInfo() {
        personName = "";
        personYOB = 0;
        personHeight = 0;
        personWeight =  0;
    }
    /**Non-default Class Constructor
     * @param name : Person's input for name.
     * @param yob : Person's input for year of birth.
     * @param height : Person's input for height.
     * @param weight : Person's input for weight.
     */
    public PersonInfo(String name, int yob,double height, double weight) {
        personName = name;
        personYOB = yob;
        personHeight = height;
        personWeight = weight;
    }

// Accessor Methods
    
    /** Return {@code PersonInfo} object's name */
    public String getName() {
        return personName; 
    }
    /** Return {@code PersonInfo} object's year of birth */
    public int getYOB() {
        return personYOB;
    }
    /** Return {@code PersonInfo} object's height in meters */
    public double getHeight() {
        return personHeight;
    }
    /** Return {@code PersonInfo} object's weight in kilograms*/
    public double getWeight() {
        return personWeight;
    }

// Mutator methods

    /**  Store {@code PersonInfo} object's name in {@code personName}.
     * @param name : A {@code String} containing the person's name.
     */
    public void setName(String name) {
        personName = name; 
    }

    /** Store {@code PersonInfo} object's year of birth in {@code personYOB}.
     * @param yob : A {@code int} containing the person's year of birth.
    */
    public void setYOB(int yob) {
        personYOB = yob ;
    }

    /** Store {@code PersonInfo} object's height in {@code personHeight}.
     * @param height : A {@code double} containing the person's height meters.
    */
    public void setHeight(double height) {
        personHeight = height;
    }

    /** Store {@code PersonInfo} object's weight in {@code personWeight}.
     * @param weight : A {@code double} containing the person's weight in kilograms.
    */
    public void setWeight(double weight) {
        personWeight = weight;
    }
    
    /** 
     * @return A person's age by calculating the difference between the current year taken from {@code Java.Util.GregorianCalendar} package
     * and the person's year of birth.
    */
    public int calculateAge() {
        int currentYear = new GregorianCalendar().get(GregorianCalendar.YEAR);
        return ( currentYear - getYOB() );
    }

    /** 
     * @return A person's BMI by dividing the person's weight in kilograms
     * by the square of the person's height in meters.
    */
    public double calculateBMI() {
        return ( getWeight() / (getHeight()*getHeight()) ); 
    }

}
