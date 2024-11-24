import java.util.Arrays;

public class MatrixTab {

    public static int McmTab(int arr[] , int n){
        int dp[][] = new int[n][n];
        
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 0;
        }

        for(int len = 2 ; len < n ; len++){  // 2 
            for (int i = 1; i <=n-len; i++) { // 1
                int j = i+len-1; //col
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j-1; k++) {
                    int ct1 = dp[i][k];
                    int ct2 = dp[k+1][j];
                    int ct3 = arr[i-1]*arr[k]*arr[j];
                    dp[i][j] = Math.min(dp[i][j], ct1+ct2+ct3);
                }
            }
        }

        return dp[1][n-1];
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};
        int n = arr.length;
        System.out.println(McmTab(arr , n ));
    }
}


