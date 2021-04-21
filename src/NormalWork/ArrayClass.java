
package NormalWork;

import java.util.Scanner;

public class ArrayClass {
    private int arr[];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayClass myselfObject =new ArrayClass();
        System.out.println("输入n，为属性arr创建n个元素空间");
        myselfObject.init(input.nextInt());
        myselfObject.out();
        System.out.println("\n输入一个整数，查找该整数是否在数组中，并输出结果");
        if(myselfObject.search(input.nextInt()))
            System.out.println("存在");
        else System.out.println("不存在");
        System.out.println("最大值："+myselfObject.max());
        System.out.println("平均值"+myselfObject.average());
    }
    private void init(int num){
        Scanner input = new Scanner(System.in);
        arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入一个整数");
            arr[i]=input.nextInt();
        }
    }
    private int max(){
        int max= 0;
        for (int i = 0; i < arr.length; i++) {
            if(max<arr[i])
                max= arr[i];
        }
        return max;
    }
    private boolean search(int num){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==num)
                return true;
        }
        return false;
    }
    private int sum(){
        int reslut = 0;
        for (int i = 0; i < arr.length; i++) {
            reslut+=arr[i];
        }
        return reslut;
    }
    private int average(){
        int reslut = 0;
        for (int i = 0; i < arr.length; i++) {
            reslut+=arr[i];
        }
        return (reslut/arr.length);
    }
    private void out(){
        System.out.println("");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("数组元素"+(i+1)+":"+arr[i]+"\n");
        }
    }
}
