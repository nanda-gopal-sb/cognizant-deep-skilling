import java.util.HashMap;

public class Operations {
    HashMap<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void removeProduct(int productId) {
        inventory.remove(productId);
    }

    public Product getProduct(int productId) {
        return inventory.get(productId);
    }

    public void updateProductQuantity(int productId, int newQuantity) {
        Product product = inventory.get(productId);
        if (product != null) {
            product = new Product(product.getProductName(), product.getProductId(), product.getProductPrice(), newQuantity);
            inventory.put(productId, product);
        }
        else{
            System.out.println("Product with ID " + productId + " not found in inventory.");
        }
    }
}
