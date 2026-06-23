// ProxyImage.java
public class ProxyImage implements Image {
    private RealImage realImage;
    private String remoteUrl;

    public ProxyImage(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    @Override
    public void display() {
        if (realImage == null) {
            System.out.println("[Proxy Log] Cache miss. Initializing RealImage resource...");
            realImage = new RealImage(remoteUrl); 
        } else {
            System.out.println("[Proxy Log] Cache hit! Serving existing memory allocation.");
        }
        
        realImage.display();
    }
}