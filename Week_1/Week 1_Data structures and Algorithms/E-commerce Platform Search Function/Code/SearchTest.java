import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SearchTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input for number of products
        System.out.print("Enter the number of products: ");
        int numberOfProducts = scanner.nextInt();
        scanner.nextLine(); 

        Product[] products = new Product[numberOfProducts];

        // Input product details
        for (int i = 0; i < numberOfProducts; i++) {
            System.out.print("Enter product ID for product " + (i + 1) + ": ");
            int productId = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Enter product name for product " + (i + 1) + ": ");
            String productName = scanner.nextLine();

            System.out.print("Enter category for product " + (i + 1) + ": ");
            String category = scanner.nextLine();

            products[i] = new Product(productId, productName, category);
        }

        // Sort the array for binary search
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        
        System.out.print("Enter the product ID to search: ");
        int searchId = scanner.nextInt();

        // Linear Search
        Product foundProductLinear = SearchUtility.linearSearch(products, searchId);
        if (foundProductLinear != null) {
            System.out.println("Product found using Linear Search: " + foundProductLinear);
        } else {
            System.out.println("Product not found using Linear Search.");
        }

        // Binary Search
        Product foundProductBinary = SearchUtility.binarySearch(products, searchId);
        if (foundProductBinary != null) {
            System.out.println("Product found using Binary Search: " + foundProductBinary);
        } else {
            System.out.println("Product not found using Binary Search.");
        }

        scanner.close();
    }
}
