package NormalWork;

import TestSeat.TestSeat_MainCode;

import java.util.Scanner;

public class comeTure {

    private String[][] noname;
    public static void main(String[] args) {
        Scanner input_01 = new Scanner(System.in);
        //正则表达式
        String regularExpress = "^[0-9]{1,4}年[1-9]{1,2}月[1-9]{1,2}号[0-9]{1,2}时[0-9]{1,2}分$";
        String s = input_01.next();
        System.out.println(s.matches(regularExpress));

    }

}
