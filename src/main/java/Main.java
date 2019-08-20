import bussinessLogics.CreateCustomerData;
import bussinessLogics.CreateCustomerDataVer_1_0_0;
import bussinessObjects.CustomerData;

public class Main {
    public static void main(String[] args) {
        CreateCustomerData createCustomerData = new CreateCustomerDataVer_1_0_0();
        CustomerData customerData = createCustomerData.createCustomerData();
        String customerDataJson = createCustomerData.customerDataToJson(customerData);
        createCustomerData.logCustomerData( customerDataJson);
        }

}
