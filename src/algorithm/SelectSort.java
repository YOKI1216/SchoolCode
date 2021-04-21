package algorithm;

public class SelectSort {
    int a[]={1,2,3};
    public void sequence(){
        for (int i = 0; i < a.length; i++) {
            int index = i;
            //找到最小值下标
            for (int j = i+1; j < a.length; j++) {
                if(a[j]<a[index])
                    index = j;
            }
            //最小值替换
            if(index==i){
                continue;
            }else{
                int temp;
                temp = a[i];
                a[i] = a[index];
                a[index] = temp;
            }
        }
    }
}
