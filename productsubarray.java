import java.util.*;
class productsubarray {
    // it solve by kandane's algorithm.
    int maxproduct(int []arr){
        int n = arr.length;
        int maxprod = arr[0];
        int minprod = arr[0];
        int res = arr[0];

        for (int i =1;i<n;i++){
            if(arr[i]<0){
                int temp = maxprod;
                maxprod = minprod;
                minprod=temp;

                maxprod = Math.max(arr[i], maxprod*arr[i]);
                minprod = Math.min(arr[i] , minprod*arr[i]);
                res = Math.max(res ,maxprod);
            }
        }
        return res;
    }
    public static void main (String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array");
        int n = sc.nextInt();
        int []arr =new int[n];

        System.out.println("Enter the array elements :");
        for (int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        productsubarray obj = new productsubarray();
        int result = obj.maxproduct(arr);

        System.out.println("it is a maximum of product of subarray:" + result);
    }
}
