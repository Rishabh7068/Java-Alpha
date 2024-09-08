public class FloodFill {

    public static void floodfill(int image[][] , int sr , int sc , int color , int oriColor){
        int m = image.length;
        int n = image[0].length;
        if(sr >= m || sc >= n || sr < 0 || sc < 0){
            return;
        }
        if(image[sr][sc] != oriColor || image[sr][sc] == color){
            return;
        }
        image[sr][sc] = color;
        floodfill(image, sr+1, sc, color, oriColor);
        floodfill(image, sr-1, sc, color, oriColor);
        floodfill(image, sr, sc+1, color, oriColor);
        floodfill(image, sr, sc-1, color, oriColor);
        return;
    }

    public static void main(String[] args) {
        int image[][] = {{1,1,1},
                        {1,1,0},
                        {1,0,1}};
        int sr =1,sc=1,color =2;
        floodfill(image, sr, sc, color, image[sr][sc]);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
        return;
    }
}


