package PAT;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class parenthesisMatch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        char[] arr = str.toCharArray();
        char a = '[';
        char b = ']';
        char c = '(';
        char d = ')';
        char e = '{';
        char f = '}';
        char name =' ';
        boolean judge = true;
        A:
        for (int i = 0; i < arr.length; i++) {
            // []
            if (arr[i] == a) {
                for (int j = i + 1; j < arr.length; j++) {
                    if(arr[j]==']'){
                        judge = true;
                        name = arr[j];
                        break;
                    }else if(arr[j]=='}'||arr[j]==')'){
                        judge =false;
                        break A;
                    }else if(j==arr.length-1){
                        if(name!=']'){
                            judge =false;
                            break A;
                        }
                    }
                }
            }
            // ()
            else if (arr[i] == c) {
                for (int j = i + 1; j < arr.length; j++) {
                    if(arr[j]==')'){
                        judge =true;
                        name = arr[j];
                        break;
                    }else if(arr[j]=='}'||arr[j]==']'){
                        judge =false;
                        break A;
                    }else if(j==arr.length-1){
                        if(name!=')'){
                            judge =false;
                            break A;
                        }

                    }
                }
            }
            // {}
            else if (arr[i] == e) {
                for (int j = i + 1; j < arr.length; j++) {
                    if(arr[j]=='}'){
                        judge =true;
                        name = arr[j];
                        break;
                    }else if(arr[j]==']'||arr[j]==')'){
                        judge =false;
                        break A;
                    }else if(j==arr.length-1){
                        if(name!='}'){
                            judge =false;
                            break A;
                        }
                    }
                }
            }
        }
        if(judge==true){
            System.out.println("yes");
        }else if(judge == false){
            System.out.println("no");
        }
    }
}

