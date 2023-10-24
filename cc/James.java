public class James {

    public static int jamess(int arr[] , int i, int j){
        if(i >= j){
            return 0;
        }
        int left = bobs(arr, i+1, j); 
        int right = bobs(arr, i, j-1);

        if(arr[i]+left > arr[j]+right){
            return arr[i]+left;
        }else{
            return arr[j]+right;
        }
    }

    public static int bobs(int arr[] , int i, int j){
        if(i >= j){
            return 0;
        }
        int left,right ;
        if(arr[i] > arr[j]){
             left = jamess(arr, i+1, j);
             return left;
        }else{
             right = jamess(arr, i, j-1);;
             return right;
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {8,5,6,11,2,10};
        System.out.println(jamess(arr, 0, arr.length-1));
        
    }
}
