import java.util.Arrays;

public class Matrixmemo {
    public static int McmM(int arr[] , int i , int j , int dp[][]){
        if(i == j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int ct1 = McmM(arr , i , k , dp);
            int ct2 = McmM(arr, k+1, j, dp);
            int ct3 = arr[i-1]*arr[k]*arr[j];
            ans = Math.min(ans, ct3+ct1+ct2);
        }
        return dp[i][j] = ans;

    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};
        int n = arr.length;
        int dp[][] = new int[n][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        System.out.println(McmM(arr, 1, n-1, dp));
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(" " + dp[i][j]);
            }
            System.out.println("");
        }
    }
}


