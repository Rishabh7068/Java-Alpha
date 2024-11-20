import java.util.Arrays;

public class CatalanProb {
    public static int Catalana(int n){
        if(n==0 || n==1){
            return 1;
        } 
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Catalana(i) * Catalana(n-1-i);
        }
        return ans;
    }

    public static int CatalanaM(int n , int[] dp){
        if(n==1 || n==0 ){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans += CatalanaM(i,dp) * CatalanaM(n-i-1, dp); 
        }
        dp[n] = ans;
        return dp[n];
    }

    public static int CatalanaT(int n){
        if(n==1 || n==0){
            return 1;
        }
        int dp[] = new int[n+1];
        dp[0] = dp[1] =1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int x = 4;
        System.out.println(Catalana(x));
        int dp[] = new int[x+1];
        Arrays.fill(dp, -1);
        System.out.println(CatalanaM(x,dp));
        System.out.println(CatalanaT(x));
    }
}


 
