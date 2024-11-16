import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class Lis {
    public static int LongestIncSubsequesnce(int arr1[]){
        HashSet<Integer> set = new HashSet<>();
        for (int x : arr1) {
            set.add(x);
        }
        int arr2[] = new int[set.size()];
        int i = 0 ;
        for (Integer x : set) {
            arr2[i] = x;
            i++;
        }
        Arrays.sort(arr2);
        int n = arr1.length;
        int m = arr2.length;
        int dp[][] = new int[n+1][m+1];
        for (i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
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
        int arr[] = {50,3,10,7,40,80};
        System.out.println(LongestIncSubsequesnce(arr));
    }
}

