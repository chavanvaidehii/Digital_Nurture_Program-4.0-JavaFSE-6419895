import java.util.Scanner;

public class Financial_Forecasting {

    // Recursive method
    public static double calculateFutureValue(double amount, double rate, int years) {
        if (years == 0) {
            return amount;
        }
        return calculateFutureValue(amount * (1 + rate), rate, years - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter the initial amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the annual growth rate (as a decimal): ");
        double rate = scanner.nextDouble();

        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

    
        double futureValue = calculateFutureValue(amount, rate, years);
        System.out.printf("Future Value: %.2f\n", futureValue);

        scanner.close();
    }
}
