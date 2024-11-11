public class fib {
    public static int fibo(int n){
        int dp[] = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n= 5;
        System.out.println(fibo(5));
    }
}
