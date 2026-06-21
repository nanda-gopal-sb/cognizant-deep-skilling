public class App {
    public static void main(String[] args) {
        System.out.println("--- Starting Singleton Verification ---");

        Logger firstReference = Logger.getLogger();
        Logger secondReference = Logger.getLogger();

        if (firstReference == secondReference) {
            System.out.println("SUCCESS: Both references point to the exact same instance.");
        } else {
            System.out.println("FAILURE: Multiple instances exist!");
        }

        System.out.println("First instance hash:  " + firstReference.hashCode());
        System.out.println("Second instance hash: " + secondReference.hashCode());

    }
}