public class Climb {
        public static int countways(int n){
            if(n < 0){
                return 0;
            }
            int dp[] = new int[n+2];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i < dp.length; i++) {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
            return dp[n];
        }
        public static void main(String[] args) {
            int n = 4;
            System.out.println(countways(n));
        }
}
