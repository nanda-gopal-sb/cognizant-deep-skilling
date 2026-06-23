public class WebApp implements Observer {
    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("[Web Dashboard Table] Rendering live ticker updating row for " + stockSymbol + " -> $" + price);
    }
}