// CreditCardPayment.java
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    @SuppressWarnings("unused")
    private String name;

    public CreditCardPayment(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing payment of $" + amount + " using Credit Card (" + maskCardNumber(cardNumber) + ").");
    }

    private String maskCardNumber(String rawCardNumber) {
        if (rawCardNumber != null && rawCardNumber.length() >= 4) {
            return "**** **** **** " + rawCardNumber.substring(rawCardNumber.length() - 4);
        }
        return "****";
    }
}