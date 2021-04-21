package NormalWork;

public class PrimeNumber {
    private int number;
    public void print(){
        for (int i = 0; i < number; i++) {
            if(isPrimeNumber(i))
                System.out.println(i+"是质数");
        }
    }
    public boolean isPrimeNumber(int num){
        if(num==0||num ==1) return false;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if(i*j==num) return false;
            }
        }
        return true;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
