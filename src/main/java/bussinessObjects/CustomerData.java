package bussinessObjects;

import Configurations.Configurations;
import java.util.List;

public class CustomerData{
    String firstName;
    String lastName;
    int age;
    Address address;
    List<PhoneNumber> PhoneNumbers;


    public CustomerData(String firstName, String lastName, int age, Address address, List<PhoneNumber> phoneNumbers) {
         Configurations configurations = new Configurations();
         String numbersOnlyRegex  = configurations.getNumbersOnlyRegex();

         if (!(firstName+lastName).matches(numbersOnlyRegex)){
            throw new IllegalArgumentException("Name must be letters only");
        }
        if (age<0){
            throw new IllegalArgumentException("Age must be greater than zero");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        PhoneNumbers = phoneNumbers;
    }


}
