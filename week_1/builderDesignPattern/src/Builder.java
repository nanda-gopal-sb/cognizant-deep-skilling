public class Builder {
    public static void main(String[] args) {
        // 1. Building a high-end Gaming PC configuration
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel Core i9-14900K")
                .setRAM("32GB DDR5")
                .setStorage("2TB NVMe SSD")
                .setGraphicsCard(true) // Include GPU
                .build();

        System.out.println(gamingPC);

        System.out.println("------------------------------------");

        // 2. Building a budget Office PC configuration (leaving out optional GPU)
        Computer officePC = new Computer.Builder()
                .setCPU("Intel Core i3")
                .setRAM("8GB DDR4")
                .setStorage("512GB SSD")
                .build();

        System.out.println(officePC);
    }
}