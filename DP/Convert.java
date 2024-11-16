
public class Convert {
    public static void StringConvert(String str1 , String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    int x = dp[i-1][j];
                    int y = dp[i][j-1];
                    dp[i][j] = Math.max(x, y);
                }
            }
        }
        System.out.println("No. of Deletion required " + (n-dp[n][m]));
        System.out.println("No. of Insertion required " + (m-dp[n][m]));
        return;
    }

    public static void main(String[] args) {
        String str1 = "peascrr";
        String str2 = "sear";
        StringConvert(str1 , str2);
    }
}

