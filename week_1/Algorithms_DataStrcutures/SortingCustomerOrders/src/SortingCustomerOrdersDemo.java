public class SortingCustomerOrdersDemo {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "Asha", 799.50),
            new Order(102, "Ravi", 199.99),
            new Order(103, "Neha", 1299.00)
        };

        Order[] bubbleSorted = orders.clone();
        Order[] quickSorted = orders.clone();

        OrderSorter sorter = new OrderSorter();
        sorter.bubbleSort(bubbleSorted);
        sorter.quickSort(quickSorted, 0, quickSorted.length - 1);

        for (Order order : bubbleSorted) {
            System.out.println(order);
        }

        for (Order order : quickSorted) {
            System.out.println(order);
        }
    }
}
