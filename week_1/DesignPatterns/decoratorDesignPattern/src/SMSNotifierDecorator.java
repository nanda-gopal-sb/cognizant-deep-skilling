public class SMSNotifierDecorator extends NotifierDecorator {
    
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // Execute whatever came before this wrapper
        sendSMS(message);    // Add extra functionality
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS text message: " + message);
    }
}