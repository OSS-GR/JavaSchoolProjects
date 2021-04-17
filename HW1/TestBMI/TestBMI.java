package TestBMI;

import patients.PersonInfo;
import java.util.Scanner;


/**
 * A simple program that receives the name, date of birth, height and weight of a person and displays their weight classification
 * based on their BMI (Body Mass Index) as underweight, normal weight, overweight, or obese.
 */

public class TestBMI {

    /**
     * 
     * @param person An instance of a PersonInfo class object.
     * @return A string that contains the classification of pat's BMI.
     * <p> It will be one of the following four depending on the BMI: </p>
     * <ul>
     *  <li> underweight (BMI < 18.5) </li>
     * <li> normal weight (18.5 <= BMI <= 25) </li>
     * <li> overweight (25 < BMI <= 30) </li>  
     * <li> obese (BMI > 30) </li>
     * </ul>
     * 
     */
    public static String classifyBMI(PersonInfo person){
        
        double BMI = person.calculateBMI();

        if (BMI < 18.5) return "Underweight";
        else if ( BMI <= 25 ) return "Normal Weight";
        else if ( BMI <= 30 ) return "Overweight";
        else return "Obese";

    }


    
    public static void main(String[] args){
        
        //Initialize PersonInfo object using default constructor.
        PersonInfo Patient = new PersonInfo();
        
        //Creating a scanner object.
        Scanner sc = new Scanner(System.in);
        
        System.out.printf("\nFirst Instance Prompts\n");
        
        System.out.printf("%s","Enter person's name: ");
        Patient.setName( sc.nextLine() );                                   //Reading user input and using Mutator method to alter the default value for Patient's name.
        System.out.printf("%s","Enter person's year of birth: ");
        Patient.setYOB( Integer.parseInt( sc.nextLine()) );                 //Reading user input and using Mutator method to alter the default values for Patient's year of birth.
        System.out.printf("%s","Enter person's height in meters: ");
        Patient.setHeight( Double.parseDouble( sc.nextLine()) );            //Reading user input and using Mutator method to alter the default values for Patient's height.
        System.out.printf("%s","Enter person's weight in kilograms: ");
        Patient.setWeight( Double.parseDouble( sc.nextLine()) );            //Reading user input and using Mutator method to alter the default values for Patient's weight.
        

        System.out.printf("\nSecond Instance Prompts\n");

        System.out.printf("%s","Enter person's name: ");
        String name = sc.nextLine();                                        //Reading user input for name.
        System.out.printf("%s","Enter person's year of birth: ");
        int birth = Integer.parseInt( sc.nextLine());                       //Reading user input for year of birth.
        System.out.printf("%s","Enter person's height in meters: ");
        double height = Double.parseDouble( sc.nextLine() );                //Reading user input for height.
        System.out.printf("%s","Enter person's weight in kilograms: ");
        double weight = Double.parseDouble( sc.nextLine() );                //Reading user input for weight.
        
        //Initialize second PersonInfo object using non-default constructor.
        PersonInfo Patient2 = new PersonInfo(name,birth,height,weight);

        //Close scanner object.
        sc.close();
        
        //Prints all information regarding Patient1 and Patient2.
        System.out.printf("\n1st Instance Output\n");
        
        System.out.printf("%16s%s\n","Full Name: ", Patient.getName());
        System.out.printf("%16s%s\n","Age: ", Patient.calculateAge());
        System.out.printf("%16s%s\n","Height: ", Patient.getHeight());
        System.out.printf("%16s%s\n","Weight: ", Patient.getWeight());
        System.out.printf("%16s%s\n","Classification: ", classifyBMI(Patient));

        System.out.printf("\n2nd Instance Output\n");
        
        System.out.printf("%16s%s\n","Full Name: ", Patient2.getName());
        System.out.printf("%16s%s\n","Age: ", Patient2.calculateAge());
        System.out.printf("%16s%s\n","Height: ", Patient2.getHeight());
        System.out.printf("%16s%s\n","Weight: ", Patient2.getWeight());
        System.out.printf("%16s%s\n","Classification: ", classifyBMI(Patient2));
        
    }
}
