// PaymentContext.java
public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    // Allows setting or changing the payment strategy dynamically at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Executes the encapsulated strategy
    public void executePayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("[Error] No payment method selected!");
            return;
        }
        paymentStrategy.pay(amount);
    }
}