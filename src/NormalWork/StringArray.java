package NormalWork;

import java.util.Scanner;

public class StringArray {
    private String [][]StringArray;
    private int row,cols;//行，列
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        StringArray myselfObject = new StringArray();
        System.out.println("输入行");
        myselfObject.setRow(input.nextInt());
        System.out.println("输入列");
        myselfObject.setCols(input.nextInt());

        //初始化
        myselfObject.init();
        myselfObject.print();
        boolean judge = true;
        while (judge){
            System.out.println("输入要找的字符串，输入”EOF“结束");
            //
            String str = input.next();
            if(str.equals("EOF"))
                break;
            if(myselfObject.search(str))
                System.out.println("存在");
            else System.out.println("不存在");
        }
    }
    private void print(){
        for (int i = 0; i < StringArray.length; i++) {
            for (int j = 0; j < StringArray[i].length; j++) {
                System.out.print(StringArray[i][j]+"\t");
            }
            System.out.println();
        }
    }
    private void init(){
        Scanner input =new Scanner(System.in);
        StringArray = new String[row][cols];
        for (int i = 0; i < StringArray.length; i++) {
            for (int j = 0; j < StringArray[i].length; j++) {
                System.out.println("请输入字符串");
                StringArray[i][j] = input.next();
            }
        }
    }
    private boolean search(String str){
        for (int i = 0; i < StringArray.length; i++) {
            for (int j = 0; j < StringArray[i].length; j++) {
                if(str.equals(StringArray[i][j]))
                return true;
            }
        }
        return false;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }
}
