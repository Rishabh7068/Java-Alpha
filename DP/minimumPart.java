public class minimumPart {
    public static int MinimumPartition(int arr[]){
        int n = arr.length;
        int sum  = 0;
        for (int i : arr) {
            sum+=i;
        }
        int w = sum/2;

        int dp[][] = new int[n+1][w+1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < w+1; j++) {
                int wt = arr[i-1];
                if(j >= wt){
                    int ics = wt + dp[i][j-wt];
                    int ecs = dp[i-1][j]; 
                    dp[i][j] = Math.max(ics, ecs);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int sum1 = dp[n][sum/2];
        int sum2 = sum-sum1;
        return Math.abs(sum1-sum2);

    }
    public static void main(String[] args) {
        int arr[] = {1,6,11,5};
        System.out.println(MinimumPartition(arr));
    }   
}

