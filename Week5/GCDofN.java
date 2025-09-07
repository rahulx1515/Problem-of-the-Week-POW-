import java.util.Scanner;

public class GCDofN {
    // Function to compute gcd of two numbers
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Function to compute gcd of an array of numbers
    public static int findGCD(int[] arr, int n) {
        int result = arr[0];
        for (int i = 1; i < n; i++) {
            result = gcd(result, arr[i]);

            // Early exit: if gcd becomes 1, no need to continue
            if (result == 1) return 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Output
        int ans = findGCD(arr, n);
        System.out.println(ans);

        sc.close();
    }
}

