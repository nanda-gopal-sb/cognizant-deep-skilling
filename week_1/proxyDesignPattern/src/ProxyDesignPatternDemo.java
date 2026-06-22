// Main.java
public class ProxyDesignPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Testing Proxy Design Pattern ===");

        // 1. Instantiating the proxy object
        Image dashboardBanner = new ProxyImage("https://cdn.example.com/assets/banner.png");
        System.out.println("Proxy instance created. (No network traffic generated yet!)");

        // 2. First rendering request (Triggers lazy initialization)
        System.out.println("Action: User clicks to view the banner for the FIRST time:");
        dashboardBanner.display();
        
        // 3. Second rendering request (Triggers caching)
        System.out.println("Action: User navigates away and clicks back to view the banner a SECOND time:");
        dashboardBanner.display();
    }
}