// CustomerRepositoryImpl.java
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(String id) {
        // Simulating a real data storage lookup
        if ("CUST-101".equals(id)) {
            return "John Doe";
        }
        return "Customer Not Found";
    }
}