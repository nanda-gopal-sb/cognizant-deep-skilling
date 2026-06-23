// Main.java
public class StrategyDesignPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Testing Strategy Design Pattern ===");

        PaymentContext checkoutCart = new PaymentContext();
        double orderTotal = 124.50;

        System.out.println("\n--- Scenario A: Paying with Credit Card ---");
        PaymentStrategy visaCard = new CreditCardPayment("1234567890123456", "Name on Card");
        checkoutCart.setPaymentStrategy(visaCard);
        checkoutCart.executePayment(orderTotal);

        System.out.println("\n--- Scenario B: Swapping Strategy to PayPal ---");
        PaymentStrategy personalPayPal = new PayPalPayment("user@example.com");
        checkoutCart.setPaymentStrategy(personalPayPal); // Swapping strategies cleanly
        checkoutCart.executePayment(45.00);
    }
}