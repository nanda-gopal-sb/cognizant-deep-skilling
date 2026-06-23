// Main.java
public class ObserverDesignPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Testing Observer Design Pattern ===");

        // 1. Initialize the Subject (Stock Market Feed)
        StockMarket techTickerFeed = new StockMarket();

        // 2. Instantiate Observers
        Observer pixelMobileApp = new MobileApp("Nandagopal");
        Observer chromeBrowserTab = new WebApp();

        // 3. Register subscribers to the stream
        System.out.println("--- Registering Observers ---");
        techTickerFeed.registerObserver(pixelMobileApp);
        techTickerFeed.registerObserver(chromeBrowserTab);

        // 4. Update market value (Both apps should receive the update)
        techTickerFeed.setStockData("GOOGL", 182.50);

        // 5. Update market value again with different metrics
        techTickerFeed.setStockData("AAPL", 215.30);

        // 6. Deregister an observer mid-stream
        System.out.println("\n--- Removing Web Dashboard Observer ---");
        techTickerFeed.removeObserver(chromeBrowserTab);

        // 7. Push one final update (Only the Mobile push notification should trigger now)
        techTickerFeed.setStockData("MSFT", 420.15);
    }
}