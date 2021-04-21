package NormalWork;

import java.util.Scanner;

public class TwoNumber {
    private int n1;
    private int n2;
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        TwoNumber TwoNumber = new TwoNumber();
        System.out.println("输入两个整数");
        TwoNumber.setN1(input.nextInt());
        TwoNumber.setN2(input.nextInt());
        boolean judge = true;
        int choose = 0;
        while(judge){
            TwoNumber.print();
            choose = input.nextInt();
            switch (choose){
                case 0:
                    judge = false;
                    break;
                case 1:
                    System.out.println("最大值为："+TwoNumber.maxNum(TwoNumber.getN1(), TwoNumber.getN2()));
                    break;
                case 2:
                    System.out.println("最小值为："+TwoNumber.minNum(TwoNumber.getN1(), TwoNumber.getN2()));
                    break;
                case 3:
                    System.out.println("两个数相等的判断为");
                    System.out.println(TwoNumber.equal(TwoNumber.getN1(), TwoNumber.getN2()));
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
        }
    }
    public int maxNum(int a,int b){
        int max =0;
        if(a>b){
            max =a;
        }else if(a<b){
            max =b;
        }else max = a=b;
        return max;
    }
    public int minNum(int a,int b){
        int min =0;
        if(a>b){
            min =b;
        }else if(a<b){
            min =a;
        }else min = a=b;
        return min;
    }
    public boolean equal(int a,int b){
        if(a==b){
            return true;
        }else return false;
    }
    public void print(){
        System.out.println(" ******************************************");
        System.out.println("请选择：");
        System.out.println("1、求最大值；2、求最小值；3、判断是否相等；0、退出");
        System.out.println(" ******************************************");
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }
}
