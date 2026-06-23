// Main.java
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        System.out.println("=== Testing Dependency Injection Pattern ===");

        // 1. Create the concrete dependency component
        CustomerRepository productionRepo = new CustomerRepositoryImpl();

        // 2. Inject the repository dependency directly into the service constructor
        CustomerService service = new CustomerService(productionRepo);

        // 3. Execute the service operations seamlessly
        System.out.println("\nExecuting production database lookup:");
        service.renderCustomerProfile("CUST-101");
    }
}