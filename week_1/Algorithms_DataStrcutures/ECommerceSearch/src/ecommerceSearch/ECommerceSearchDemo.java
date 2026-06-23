package ecommerceSearch;

public class ECommerceSearchDemo {
    public static void main(String[] args) {
        Product[] products = {
            new Product(3, "Laptop", "Electronics"),
            new Product(1, "Shoes", "Fashion"),
            new Product(2, "Watch", "Accessories")
        };

        Product[] sortedProducts = {
            new Product(1, "Shoes", "Fashion"),
            new Product(2, "Watch", "Accessories"),
            new Product(3, "Laptop", "Electronics")
        };

        SearchOperations searchOperations = new SearchOperations();
        System.out.println(searchOperations.linearSearch(products, 2));
        System.out.println(searchOperations.binarySearch(sortedProducts, 3));
    }
}