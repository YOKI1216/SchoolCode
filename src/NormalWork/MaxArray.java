package NormalWork;

public class MaxArray {
    static int max(int[] arr){
        int maxNum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(maxNum<arr[i])
                maxNum = arr[i];
        }
        return maxNum;
    }
    static boolean search(int num,int[] arr){
        for(int i:arr){
            if(i==num)
                return true;
        }
      return false;
    }
}
