import java.util.Arrays;

public class Lcs {
    public static int Lcsqe(String str1 , String str2 , int n , int m){
        if(n == 0 || m == 0){
            return 0;
        }
        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return (1+Lcsqe(str1, str2, n-1, m-1));
        }
        int lf = Lcsqe(str1, str2, n-1, m);
        int rf = Lcsqe(str1, str2, n, m-1);
        return Math.max(lf, rf);    
    }

    public static int LcsqeM(String str1 , String str2 , int n , int m , int dp[][]){
        //base case if any of the string get empty
        if (n == 0 || m == 0) {
            return 0;
        }
        //if we already have a answer
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) { // same charecters
            return dp[n][m] = LcsqeM(str1, str2, n - 1, m - 1, dp) + 1;
        } 
        else { // diff charecters
            int ans1 = LcsqeM(str1, str2, n - 1, m, dp);
            int ans2 = LcsqeM(str1, str2, n, m - 1, dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }   
    }

    public static int LcsqeT(String str1 , String str2 ){
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
            for (int j = 1; j < m+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    int x = dp[i-1][j];
                    int y = dp[i][j-1];
                    dp[i][j] = Math.max(x, y);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";
        int dp[][] = new int[str1.length()+1][str2.length()+2];

         // initialization
        for (int i = 0; i < str1.length() + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(Lcsqe(str1,str2,str1.length() , str2.length()));
        System.out.println(LcsqeM(str1,str2,str1.length() , str2.length(),dp));
        System.out.println(LcsqeT(str1,str2));
    }
}


