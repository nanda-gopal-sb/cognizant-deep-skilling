// Main.java
public class Adapter {
    public static void main(String[] args) {

        double checkoutTotal = 49.99;

        // 1. Using Paytm through our unified processor interface
        PaytmGateway legacyPaytm = new PaytmGateway();
        PaymentProcessor paytmProcessor = new PaytmAdapter(legacyPaytm);
        
        System.out.println("Client: Processing checkout with Paytm...");
        paytmProcessor.processPayment(checkoutTotal);

        System.out.println("------------------------------------");

        // 2. Using PhonePe through the exact same type of interface reference
        PhonePayGateway legacyPhonePay = new PhonePayGateway();
        PaymentProcessor phonePayProcessor = new PhonePayAdapter(legacyPhonePay);
        
        System.out.println("Client: Processing checkout with PhonePe...");
        phonePayProcessor.processPayment(checkoutTotal);
    }
}