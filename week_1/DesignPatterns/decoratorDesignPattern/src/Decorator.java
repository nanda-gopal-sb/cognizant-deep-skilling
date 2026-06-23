// Main.java
public class Decorator {
    public static void main(String[] args) {

        String criticalAlert = "System database space is running low!";

        System.out.println("--- Scenario 1: Basic Email Only ---");
        Notifier coreEmailNotifier = new EmailNotifier();
        coreEmailNotifier.send(criticalAlert);

        System.out.println("\n--- Scenario 2: Email + SMS text ---");
        // 2. Wrap the email notifier inside an SMS decorator
        Notifier emailAndSMS = new SMSNotifierDecorator(new EmailNotifier());
        emailAndSMS.send(criticalAlert);

        System.out.println("\n--- Scenario 3: Full Stack (Email + SMS + Slack) ---");
        Notifier fullyDecoratedSystem = 
            new SlackNotifierDecorator(
                new SMSNotifierDecorator(
                    new EmailNotifier()
                )
            );
            
        fullyDecoratedSystem.send(criticalAlert);
    }
}