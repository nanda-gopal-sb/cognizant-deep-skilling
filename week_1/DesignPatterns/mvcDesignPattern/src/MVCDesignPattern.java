// Main.java
public class MVCDesignPattern {
    public static void main(String[] args) {
        System.out.println("=== Testing MVC Architectural Pattern ===");

        // 1. Fetch/Create student data records (The Model layer)
        Student model = retrieveStudentFromDatabase();

        // 2. Create the presentation output configuration (The View layer)
        StudentView view = new StudentView();

        // 3. Initialize the Controller to bind them together
        StudentController controller = new StudentController(model, view);

        // 4. Render initial view
        System.out.println("\nInitial View State:");
        controller.updateView();

        // 5. Update data elements using the controller pipeline
        System.out.println("Action: Updating student profile metrics via controller...");
        controller.setStudentName("Nandagopal Shaini Binusekhar");
        controller.setStudentGrade("A+");

        // 6. Update view to reflect modifications
        System.out.println("\nUpdated View State:");
        controller.updateView();
    }

    // Simulating database retrieval logic helper
    private static Student retrieveStudentFromDatabase() {
        return new Student("Nandagopal SB", "CUSAT-2027-IT", "A");
    }
}