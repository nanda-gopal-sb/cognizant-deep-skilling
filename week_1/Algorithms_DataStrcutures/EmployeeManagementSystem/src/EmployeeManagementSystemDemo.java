public class EmployeeManagementSystemDemo {
    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem(3);
        system.addEmployee(new Employee(1, "Asha", "Developer", 65000));
        system.addEmployee(new Employee(2, "Ravi", "Tester", 55000));

        System.out.println(system.searchEmployee(2));
        system.traverseEmployees();
        system.deleteEmployee(1);
        system.traverseEmployees();
    }
}
