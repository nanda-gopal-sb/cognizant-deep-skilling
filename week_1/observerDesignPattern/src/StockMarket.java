// StockMarket.java
import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private List<Observer> observers;
    private String stockSymbol;
    private double price;

    public StockMarket() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        System.out.println("[Market Info] New observer successfully subscribed.");
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("[Market Info] An observer unsubscribed.");
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockSymbol, price);
        }
    }

    // Business logic method to alter state and broadcast changes
    public void setStockData(String stockSymbol, double price) {
        this.stockSymbol = stockSymbol;
        this.price = price;
        System.out.println("\n=== Market Update: " + stockSymbol + " is now $" + price + " ===");
        notifyObservers(); 
    }
}