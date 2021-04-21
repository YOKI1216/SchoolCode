package NormalWork;

public class Narcissus {
    public static void main(String[] args) {
        Narcissus isNarcissus = new Narcissus();
        isNarcissus.print();
    }
    public void print(){
        for (int i = 100; i <999 ; i++) {
            if(isNarcissus(i)==1)
                System.out.println(i+"是水仙花数");
        }
    }
    public int isNarcissus(int num){
    int a=num%10;
    int b=(num/10)%10;
    int c=(num/100)%10;
    if(num==(Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3)))
        return 1;
    else
        return 0;
    }
}
