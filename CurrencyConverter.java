import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {

    private static final HashMap<String, Double> exchangeRates = new HashMap<>();

    // Initialize mock exchange rates
    static {
        exchangeRates.put("USD", 1.0);        // base currency
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("INR", 83.2);
        exchangeRates.put("GBP", 0.75);
        exchangeRates.put("JPY", 150.2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Available Currencies: USD, EUR, INR, GBP, JPY");

        System.out.print("Enter base currency: ");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency: ");
        String toCurrency = scanner.next().toUpperCase();

        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            System.out.println("Invalid currency code.");
            return;
        }

        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        double baseRate = exchangeRates.get(fromCurrency);
        double targetRate = exchangeRates.get(toCurrency);

        double convertedAmount = (amount / baseRate) * targetRate;

        System.out.printf("Converted Amount of the currency is: %.2f %s\n", convertedAmount, toCurrency);

        scanner.close();
    }
}