package NormalWork;

import java.util.Scanner;
public class MonthDay {
    private int month;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MonthDay myself = new MonthDay();
        int num =input.nextInt();
        String judge = "^([0-1][0-2])|([0-9])$";
        Integer tran = num;
        boolean judge_01 = tran.toString().matches(judge);
        while(!judge_01){
            System.out.println("输入错误，请重新输入");
            num =input.nextInt();
            tran = num;
            judge_01 = tran.toString().matches(judge);
        }
        myself.month = num;
        int day = myself.getDay(myself.month);
        System.out.println(myself.month+"月的天数为："+day);
    }
    public int getDay(int month){
        int day;
        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10 :
            case 12 :
                day = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = 30;
                break;
            default :
                day = 28;

        }
        return day;
    }
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
