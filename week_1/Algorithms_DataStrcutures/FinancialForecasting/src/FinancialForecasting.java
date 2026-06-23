public class FinancialForecasting {
    public double predictFutureValue(double currentValue, double[] growthRates) {
        return predictFutureValue(currentValue, growthRates, 0);
    }

    private double predictFutureValue(double currentValue, double[] growthRates, int index) {
        if (index == growthRates.length) {
            return currentValue;
        }
        double nextValue = currentValue * (1 + growthRates[index]);
        return predictFutureValue(nextValue, growthRates, index + 1);
    }

    public static void main(String[] args) {
        FinancialForecasting forecasting = new FinancialForecasting();
        double futureValue = forecasting.predictFutureValue(1000.0, new double[] {0.05, 0.03, 0.04});
        System.out.println(futureValue);
    }
}
