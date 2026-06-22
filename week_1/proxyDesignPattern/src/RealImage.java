// RealImage.java
public class RealImage implements Image {
    private String remoteUrl;

    public RealImage(String remoteUrl) {
        this.remoteUrl = remoteUrl;
        loadFromRemoteServer(); // High-cost operation executed on initialization
    }

    private void loadFromRemoteServer() {
        System.out.println("Network Call: Downloading byte stream from " + remoteUrl + "...");
        System.out.println("Image completely downloaded and loaded into memory.");
    }

    @Override
    public void display() {
        System.out.println("Rendering Image on Screen: " + remoteUrl);
    }
}