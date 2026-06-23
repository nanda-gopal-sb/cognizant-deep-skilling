// RemoteControl.java
public class RemoteControl {
    private Command slot;

    // Changes the command dynamically (re-programming a slot on the remote)
    public void setCommand(Command command) {
        this.slot = command;
    }

    // Triggers the execution of whatever command is currently loaded
    public void pressButton() {
        if (slot == null) {
            System.out.println("[Remote Control] No command programmed into this slot.");
            return;
        }
        slot.execute();
    }
}