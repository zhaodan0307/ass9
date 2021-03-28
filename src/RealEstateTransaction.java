/*Challenge:The class RealEstateTransaction has four states which are streetNumber,streetName,city and purchasePrice
* all the states are String type.
* The class has 2 constructor one is Default constructor the other one takes 4 arguments.
* The class has appropriate getter and setter for every state.
* The class has a method named oneString which return the four fields of the object as one string in which the front
* “half” of the string is lowercase letters and the back “half” of the string is uppercase letters.
* The class has a method named concatedSubstring which returns a substring to the caller of the full state of the
* object concatenated into one string in which one  portion (length to be determined by a random number) of
* the string is lowercase letters and a second portion ((length to be determined by a second random number))of
* the string is uppercase letters based upon two valid random numbers.
* The class has a method named encryptedString which are with 2 ints and returns an encrypted version of the state of
* the object as a single encrypted string to the caller.  The method will concatenate the state of the object into
* one String.  The first int will represent the index of the “key character” of the String.  The second int will
* represent the index value of the first character to be encrypted; the key character will replace the first character
* of the string and every third character thereafter.if any of the info passed into the method is valid return 1
*
* Name: Dan Zhao
* Date: Nov 17th 2020
 * */

//import the Random class
import java.util.Random;

public class RealEstateTransaction {
    //four states
    private String streetNumber;
    private String streetName;
    private String city;
    private String purchasePrice;
    //default constructor
    public RealEstateTransaction(){
        streetNumber="";
        streetName="";
        city="";
        purchasePrice="";
    }
    //the constructor with arguments
    public RealEstateTransaction(String numberOfStreet,String nameOfStreet,String theCity,String thePrice){
        streetNumber=numberOfStreet;
        streetName=nameOfStreet;
        city=theCity;
        purchasePrice=thePrice;
    }
    //setter and getter for all states
    public void setStreetNumber(String numberOfStreet){
        streetNumber=numberOfStreet;
    }
    public String getStreetNumber(){
        return streetNumber;
    }
    public void setStreetName(String nameOfStreet){
        streetName=nameOfStreet;
    }
    public String getStreetName(){
        return streetName;
    }
    public void setCity(String theCity){
        city=theCity;
    }
    public String getCity(){
        return city;
    }
    public void setPurchasePrice(String thePrice){
        purchasePrice=thePrice;
    }
    public String getPurchasePrice(){
        return purchasePrice;
    }



    //the method oneString returns the four fields of the object as one string in which the front
    //“half” of the string is lowercase letters and the back “half” of the string is uppercase letters.
    public String oneString(){
        String stringTogether=streetNumber+streetName+city+purchasePrice;
        //first half of the String
        String portionOne= stringTogether.substring(0,stringTogether.length()/2);
        //the second half of the string
        String portionTwo=stringTogether.substring(stringTogether.length()/2);
        //combine the first half of lowercase with second half of uppercase.
        stringTogether=portionOne.toLowerCase()+portionTwo.toUpperCase();
        return stringTogether;
    }
    /* concatedSubstring method returns a substring to the caller of the full state of the
    /object concatenated into one string in which one  portion (length to be determined by a random number) of
    /the string is lowercase letters and a second portion ((length to be determined by a second random number))of
    /the string is uppercase letters based upon two valid random numbers. */

    public String concatedSubstring(){
        //concatenate all states into one string.
        String concatedString=streetNumber+streetName+city+purchasePrice;
        //record the substring to return;
        String subConcatedString;

        //get the valid random number for portionOne and portionTwo
        int firstlength;
        int secondlength;
        Random rand = new Random();
        do {
            firstlength= rand.nextInt(concatedString.length());
            secondlength= rand.nextInt(concatedString.length());
        }
        while (firstlength+secondlength>concatedString.length()||firstlength+secondlength==concatedString.length());

        //set the portionOne and portionTwo by the length of valid random number
        String portionOne= concatedString.substring(0,firstlength);
        String portionTwo=concatedString.substring(firstlength,firstlength+secondlength);
        //combine the portionOne in lowerCase and portionTwo in UpperCase
        subConcatedString=portionOne.toLowerCase()+portionTwo.toUpperCase();
        return subConcatedString;
    }
    /* encryptedString method is with 2 ints and returns an encrypted version of the state of
   the object as a single encrypted string to the caller.  The method will concatenate the state of the object into
   one String.  The first int will represent the index of the “key character” of the String.  The second int will
   represent the index value of the first character to be encrypted; the key character will replace the first character
   of the string and every third character thereafter.*/
    public String encryptedString(int indexOfKey , int indexOfFirst){

        String stringTogether = streetNumber+streetName+city+purchasePrice;
        String encryptedStr=stringTogether;
        //check if first int is less than the second int passed in and that the neither int is
        //greater than the length of the single concatenated String.
        if(indexOfKey<indexOfFirst&&(indexOfKey<stringTogether.length()||indexOfKey==stringTogether.length())
        &&(indexOfFirst<stringTogether.length()||indexOfFirst==stringTogether.length())){
            //the key character will replace the first character of the string and every third character thereafter.
            for(int indexNum = indexOfFirst;indexNum<stringTogether.length();indexNum=indexNum+3) {

                encryptedStr=encryptedStr.substring(0,indexNum)+encryptedStr.charAt(indexOfKey)+encryptedStr.substring(indexNum+1);

            }
            // if first int is  not less than the second int passed in and
            // that there's int greater than the length of the single concatenated String. return 1 to caller
        }else{
            encryptedStr="1";

        }
        return encryptedStr;
    }




}

