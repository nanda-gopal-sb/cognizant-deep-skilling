public class InventoryManagement {
    Operations operations = new Operations();

    Product product1 = new Product("Laptop", 1, 999.99, 10);

    Product product2 = new Product("Smartphone", 2, 499.99, 20);

    public void manageInventory() {
        operations.addProduct(product1);
        operations.addProduct(product2);

        System.out.println("Added products to inventory.");

        Product retrievedProduct = operations.getProduct(1);
        if (retrievedProduct != null) {
            System.out.println("Retrieved product: " + retrievedProduct.getProductName());
        }

        operations.updateProductQuantity(1, 15);
        System.out.println("Updated product quantity for product ID 1.");

        operations.removeProduct(2);
        System.out.println("Removed product with ID 2 from inventory.");
    }
}
