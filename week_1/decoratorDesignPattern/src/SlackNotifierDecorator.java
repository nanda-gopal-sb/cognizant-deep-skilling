public class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // Execute whatever came before this wrapper
        sendSlackMessage(message); // Add extra functionality
    }

    private void sendSlackMessage(String message) {
        System.out.println("Posting to Slack workspace: " + message);
    }
}