public class PhonePayAdapter implements PaymentProcessor {
    private PhonePayGateway phonePayGateway;

    public PhonePayAdapter(PhonePayGateway phonePayGateway) {
        this.phonePayGateway = phonePayGateway;
    }

    @Override
    public void processPayment(double amount) {
        // Data translation: PhonePe expects integer rupees instead of double dollars
        int amountInRupees = (int) (amount);
        phonePayGateway.chargeCard(amountInRupees);
    }
}