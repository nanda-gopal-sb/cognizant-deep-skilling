public class PaytmAdapter implements PaymentProcessor {
    private PaytmGateway paytmGateway;

    public PaytmAdapter(PaytmGateway paytmGateway) {
        this.paytmGateway = paytmGateway;
    }

    @Override
    public void processPayment(double amount) {
        // Direct conversion: maps processPayment to makePaytmPayment
        paytmGateway.makePaytmPayment(amount);
    }
}