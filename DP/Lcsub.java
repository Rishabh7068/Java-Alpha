public class Lcsub {
    public static int LongestCommonSubstring(String str1 , String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j <m+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1; 
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]);
                ans = Math.max(ans, dp[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        return ans;
    }

    public static void main(String[] args) {
        String str1 = "ABCDE";
        String str2 = "ABGCE";
        System.out.println(LongestCommonSubstring(str1, str2));
    }
}

