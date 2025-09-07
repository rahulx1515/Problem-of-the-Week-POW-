public class PerfectSquares {
    public static int minNumSquares(int n) {
        int[] dp = new int[n + 1];
        dp = 0; 

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println(minNumSquares(n)); 
    }
}
