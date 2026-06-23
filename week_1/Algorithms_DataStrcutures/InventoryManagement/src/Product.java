public class Product {
    private String productName;
    private int productId;
    private double productPrice;
    private int productQuantity;
    
    public Product(String productName, int productId, double productPrice, int productQuantity) {
        this.productName = productName;
        this.productId = productId;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return productName;
    }
    public int getProductId() {
        return productId;
    }
    public double getProductPrice() {
        return productPrice;
    }
    public int getProductQuantity() {
        return productQuantity;
    }
    
}
