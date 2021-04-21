package NormalWork;

import java.util.Scanner;

public class reverseString {
    private String str;
    public static void main(String[] args) {
        reverseString reverseString = new reverseString();
        Scanner input =new Scanner(System.in);
        reverseString.setStr(input.next());
        reverseString.printBitwise(reverseString.str);
    }

    public void printBitwise(String str) {
        String result = "";
      char arr[] = str.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            result += String.valueOf(arr[i]);
        }
        long resultNum = Long.parseLong(result);
        System.out.println(result);
        System.out.println(resultNum);
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
