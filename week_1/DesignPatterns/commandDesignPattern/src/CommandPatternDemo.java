// Main.java
public class CommandPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Testing Command Design Pattern ===");

        // 1. Instantiate the Receiver (The physical device)
        Light livingRoomLight = new Light("Living Room");

        // 2. Instantiate the Concrete Commands and hand them their Receiver
        Command switchOn = new LightOnCommand(livingRoomLight);
        Command switchOff = new LightOffCommand(livingRoomLight);

        // 3. Instantiate the Invoker (The interface widget)
        RemoteControl smartRemote = new RemoteControl();

        // 4. Test Scenario: Turn the light ON
        System.out.println("\n--- Scenario A: Programming and pressing 'On' ---");
        smartRemote.setCommand(switchOn);
        smartRemote.pressButton();

        // 5. Test Scenario: Turn the light OFF
        System.out.println("\n--- Scenario B: Programming and pressing 'Off' ---");
        smartRemote.setCommand(switchOff);
        smartRemote.pressButton();
    }
}