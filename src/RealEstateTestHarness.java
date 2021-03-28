/*Challenge:the method named RealEstateTestHarness.
* the class will instantiate a RealEstateTransaction object with 4 pieces of data.
* and test onString() and concatedSubstring() of RealEstateTransaction. then ask
* the user for two ints to test method encryptedString(firstNumber,secondNumber).
* If the ints are invalid ask the user for two more etc. until the user provide valid ints.
* Name: Dan Zhao
* Date: Nov 17th 2020
* */

//import the Scanner class
import java.util.Scanner;
import java.util.InputMismatchException;
public class RealEstateTestHarness {
    public static void main(String[] args) {
        //instantiate a RealEstateTransaction object named realEstate1 with 4 arguments.
        RealEstateTransaction realEstate1= new RealEstateTransaction("632","BayStreet","Toronto","1,524,368");
        //check the method oneString()
        System.out.println("The method 1: combination of the states with half lowercase and half uppercase is: ");
        System.out.println(realEstate1.oneString());
        System.out.println("_________________________________");
        //check the method concatedSubstring()
        System.out.println("the method 2: a substring to the caller of the full state of the object concatenated into one string is: ");
        System.out.println(realEstate1.concatedSubstring());

        /*ask the user for two ints to test method encryptedString.If they does not input int,let them input again
         until they inputs valid numbers */
        while(true){
            try{
                Scanner in = new Scanner(System.in);
                System.out.println("Please input the first number ");
               int firstNumber=in.nextInt();
                System.out.println("Please input the second number ");
               int secondNumber=in.nextInt();
                /*if any of the info passed into the method encryptedString is not valid,let them input again
                 */
                while(realEstate1.encryptedString(firstNumber,secondNumber)=="1"){
                    System.out.println("invalid number please input again");
                    System.out.println("Please input the first number ");
                    firstNumber = in.nextInt();
                    System.out.println("Please input the second number ");
                    secondNumber = in.nextInt();
                }

                System.out.println("The method 3: the encryptedString is");
                //call the method encryptedString,and print out the encrypted string.
                System.out.println(realEstate1.encryptedString(firstNumber,secondNumber));

                break;
            }
            //if user don't input int,let them input valid number
            catch (InputMismatchException e){

                System.out.println("You don't input int, please input valid ints");

            }


        }





    }
}
