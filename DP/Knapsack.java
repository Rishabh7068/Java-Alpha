
import java.util.Arrays;
public class Knapsack {

    public static int KnapsackCal(int val[] , int wt[] , int bag , int idx , int dp[][]){
        if(bag == 0 || idx == val.length){
            return 0;
        }
        
        if(dp[idx][bag] != -1){
            return dp[idx][bag];
        }

        if (wt[idx] <= bag) {
            int ans1 = val[idx] + KnapsackCal(val, wt, bag - wt[idx], idx+1 ,dp);
            int ans2 = KnapsackCal(val, wt, bag, idx+1, dp);
            dp[idx][bag] =  Math.max(ans2,ans1);
            return dp[idx][bag];
        }else{
            dp[idx][bag] = KnapsackCal(val, wt, bag, idx+1, dp);
            return dp[idx][bag];
        }
    }

    public static int KnapsackTab(int val[] , int wt[] , int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        
        for(int i = 0 ; i < dp.length ; i++){
            dp[i][0] =0;
        }
        for(int j = 0 ; j < dp[0].length ; j++){
            dp[0][j] =0;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < W+1; j++) {
                int value = val[i-1];
                int weight = wt[i-1];
                if(weight <= j){
                    int icp = value + dp[i-1][j-weight];
                    int ecp = dp[i-1][j];
                    dp[i][j] = Math.max(icp, ecp);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static int KnapsackUn(int val[] , int wt[] , int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < W+1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < n+1 ;i++) {
            for (int j = 1; j < W+1; j++) {
                int v = val[i-1];
                int w = wt[i-1];
                if(j >= w){
                    int icp = v + dp[i][j-w];
                    int ecp = dp[i-1][j];
                    dp[i][j] = Math.max(icp, ecp);
                }else{
                    dp[i][j] =dp[i-1][j];
                }
            }
        }
        return dp[val.length][W]; 
    }

    public static void main(String[] args) {
        int val[] = {15,14, 10,45,30};
        int wt[] = {2,5,1,3,4};
        int bag = 7;
        int dp[][] = new int[val.length+1][bag+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(KnapsackCal(val , wt , bag , 0 , dp ));
        System.out.println(KnapsackTab(val, wt, bag));
        System.out.println(KnapsackUn(val , wt , bag) );
    } 
}



