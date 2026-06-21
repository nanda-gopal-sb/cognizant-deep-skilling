public class Computer {
    private final String CPU;
    private final String RAM;
    private final String storage;
    private final boolean hasGraphicsCard; 

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.hasGraphicsCard = builder.hasGraphicsCard;
    }

    public String getCPU() { return CPU; }
    public String getRAM() { return RAM; }
    public String getStorage() { return storage; }
    public boolean isHasGraphicsCard() { return hasGraphicsCard; }

    @Override
    public String toString() {
        return "Computer Configuration: [CPU=" + CPU + ", RAM=" + RAM + 
               ", Storage=" + storage + ", Graphics Card Included=" + hasGraphicsCard + "]";
    }

    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private boolean hasGraphicsCard = false; 

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this; 
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(boolean hasGraphicsCard) {
            this.hasGraphicsCard = hasGraphicsCard;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}