// CustomerService.java
public class CustomerService {
    // Depend on the abstract Interface, NOT the concrete class
    private final CustomerRepository repository;

    // 5. Constructor Injection: The dependency is supplied from the outside
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void renderCustomerProfile(String id) {
        System.out.println("[Service Log] Initiating profile rendering request...");
        String name = repository.findCustomerById(id);
        System.out.println("Customer Profile Detail: [ID: " + id + ", Name: " + name + "]");
    }
}