package NormalWork;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //happy
        Scanner input = new Scanner(System.in);
        System.out.println("输入数组元素的个数，创建一个整型数组");
        int[] arr = new int[input.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*100);
            System.out.println("第"+(i+1)+"位:"+arr[i]);
        }
        System.out.println("最大值为："+MaxArray.max(arr));
        System.out.println("请输入一个整形，判断是否在数组中");
        if(MaxArray.search(input.nextInt(),arr))
            System.out.println("该数存在");
        else System.out.println("该数不存在");
    }
    // 选择排序
/*    void SelectionSort(int arr[], int length)
    {
        for (int i = 0; i < length; i++)
        {
            int index = i;//下标
            for (int j = i+1; j < length; j++)
            {
                if (arr[j] < arr[index])
                {
                    index = j;
                }
            }
            if (index == i)
                continue;
            else
            {   //将最小的数替换成这个的下标
                int temp;
                temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
    }*/
}
