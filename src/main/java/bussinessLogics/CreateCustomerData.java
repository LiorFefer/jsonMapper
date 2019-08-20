package bussinessLogics;
import bussinessObjects.CustomerData;

public interface CreateCustomerData {
     CustomerData createCustomerData();
     String customerDataToJson(CustomerData customerData);
     void logCustomerData(String customerDataJson);
}
