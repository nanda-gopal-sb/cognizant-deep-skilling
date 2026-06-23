public class MobileApp implements Observer {
    private String appUser;

    public MobileApp(String appUser) {
        this.appUser = appUser;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("[Mobile Push Alert for " + appUser + "] " + stockSymbol + " has changed to $" + price);
    }
}