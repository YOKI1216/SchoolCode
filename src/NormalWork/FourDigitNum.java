package NormalWork;

import java.util.Scanner;

public class FourDigitNum {
    private long number;
    public static void main(String[] args) {
        FourDigitNum digitNum = new FourDigitNum();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入数字");
        digitNum.setNumber(input.nextLong());
        digitNum.printBitwise(digitNum.number);
    }
    public void printBitwise(long num){
        long result= 0,temp =num,firstNum =num%10,digit=0 ;
        while((temp%10)!=0||firstNum==0){
            digit++;
            temp=temp/10;
        }
        for (long i = digit-1; i >=0; i--) {
            result += (long) ((num%10)*Math.pow(10,i));
            num= num/10;
        }
        System.out.println("倒序输出："+result);
    }
    public void setNumber(long number) {
        this.number = number;
    }
}
