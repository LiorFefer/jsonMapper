package bussinessLogics;

import bussinessObjects.Address;
import bussinessObjects.CustomerData;
import bussinessObjects.PhoneNumber;
import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateCustomerDataVer_1_0_0 implements CreateCustomerData{
    final static Logger logger = Logger.getLogger(CreateCustomerDataVer_1_0_0.class.getName());

    public CustomerData createCustomerData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter First Name ");
        String firstName = scanner.nextLine();

        System.out.println("Please Enter Last Name ");
        String lastName = scanner.nextLine();

        System.out.println("Please Enter Age ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("Please Enter streetAddress ");
        String streetAddress = scanner.nextLine();

        System.out.println("Please Enter city ");
        String city = scanner.nextLine();

        System.out.println("Please Enter postCode ");
        int postCode = Integer.parseInt(scanner.nextLine());

        boolean isMorePhones=true;
        List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
        while(isMorePhones){
            System.out.println("Please Enter phoneType");
            String phoneType = scanner.nextLine();

            System.out.println("Please Enter number");
            String number = scanner.nextLine();

            System.out.println("Add a new phone number? y/n");
            String newPhone = scanner.nextLine();

            PhoneNumber phoneNumber = new PhoneNumber(phoneType,number);
            phoneNumbers.add(phoneNumber);
            if (newPhone.equals("n")){
                isMorePhones=false;
            }
        }

        Address address = new Address(streetAddress,city,postCode);
        CustomerData customerData = new CustomerData(firstName,lastName,age,address,phoneNumbers);
        return customerData;
    }
    public String customerDataToJson(CustomerData customerData){
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);

        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customerData);
        }
        catch (Exception exception){
            //write to log
            return null;
        }
    }
    public void logCustomerData(String customerDataJson) {
        logger.info(customerDataJson);
    }
}
