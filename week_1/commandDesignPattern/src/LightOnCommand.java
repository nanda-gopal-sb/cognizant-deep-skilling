// LightOnCommand.java
public class LightOnCommand implements Command {
    private Light light;

    // The command is given a reference to its specific receiver
    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn(); // Delegates the action to the receiver
    }
}