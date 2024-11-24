public class MinJumps {
    public static int minJump(int nums[]){
        int n = nums.length;
        int dp[] = new int[n];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        dp[n-1] = 0;
        
        for (int i = n-2; i >= 0; i--) {
            int step = nums[i];
            int ans = Integer.MAX_VALUE;
            for (int j = i+1; j <= i+step && j < n; j++) {
                if(dp[j] != -1){
                    ans = Math.min(ans, dp[j]+1);
                }   
            }
            dp[i] = ans;
        }
        return dp[0];
    }
    public static void main(String[] args) {
        int nums[] = {2,3,1,1,4};
        System.out.println(minJump(nums));
    }
}
