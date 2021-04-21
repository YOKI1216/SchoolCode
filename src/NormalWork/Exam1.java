package NormalWork;

import java.util.Scanner;

public class Exam1 {
    int[] a;
    void init(int n){
        Scanner input = new Scanner(System.in);
        a = new int[n];
        for (int i = 0; i < a.length; i++) {
            System.out.println("请输入一个整数");
            a[i]=input.nextInt();
        }
    }
//求数组最大值。
    public int max() throws NullPointerException{
        int max=0;
        for (int i = 0; i < a.length; i++) {
            if(max<a[i])
                max= a[i];
        }
        return max;

    }
//输出数组每一个元素的值。
    public  void print(){
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
//翻转数组元素，第一个变成最后一个，第二个移动到倒数第二个。。。，如{1,2,3,5,7,9,4}===>{4,9,7,5,3,2,1}
    public  void inverse(){
        int b[]=a.clone(),i=0;
        for (int length = a.length; length > 0; length--) {
            a[i] = b[length-1];
            i++;
        }
        print();
    }
//对数组从小到大排序,冒泡排序？可以用选择排序
    public void sort(){
        for (int i = 0; i < a.length; i++) {
            int index =i;
            //j从上一个最小值的下一位开始对比
            for (int j = i+1; j < a.length; j++) {
                if(a[j]<a[index]){
                    index = j;//最小坐标
                }
            }
            if(index==i)
                continue;
            else{
                int temp;
                temp = a[index];
                a[index] = a[i];
                a[i] = temp;
            }
        }
        print();
    }
    public static void main(String[] args) {

//请创建类的对象，调用init方法对属性数组进行初始化，输出所有数组元素；
        Exam1 myselfObject = new Exam1();
        Scanner input = new Scanner(System.in);
        System.out.println("输入n初始化");
        myselfObject.init(input.nextInt());
        //求属性数组的最大值并输出
        System.out.println("数组的最大值:"+myselfObject.max());
        //对属性数组进行翻转并输出
        System.out.println("对属性数组进行翻转并输出");
        myselfObject.inverse();
        //对属性数组排序并输出
        System.out.println("对属性数组排序并输出");
        myselfObject.sort();
        //请将Eclisep中代码以及运行结果截图上传，不允许定义static静态方法。

    }

}
