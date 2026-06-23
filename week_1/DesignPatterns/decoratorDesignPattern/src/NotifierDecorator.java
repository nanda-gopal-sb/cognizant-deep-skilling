// NotifierDecorator.java
public abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    // The constructor accepts any Notifier (could be a component or another decorator)
    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        // Default behavior delegates execution to the wrapped component
        wrappedNotifier.send(message);
    }
}