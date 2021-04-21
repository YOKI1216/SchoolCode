package Collection;

import java.util.ArrayList;

public class Arraylist_use {
    private ArrayList<Integer> list_1 = new ArrayList<>();//成员变量
    public static void main(String[] args) {
        //创建本类对象
        Arraylist_use arraylist_use = new Arraylist_use();
        ArrayList list_2 = new ArrayList();//局部变量
        int num_1 =1;
        String num_2 ="999";
        //
        System.out.println(Integer.valueOf(num_2));
        //添加两个不同类型的数据进入Arraylist集合
        list_2.add(num_1);
        list_2.add(num_2);
        System.out.println(list_2.get(0));
        System.out.println(list_2.get(1));
        //当有定义泛型时
        arraylist_use.list_1.add(num_1);
        arraylist_use.list_1.add(Integer.valueOf(num_2));

    }

    public ArrayList<Integer> getList_1() {
        return list_1;
    }

    public void setList_1(ArrayList<Integer> list_1) {
        this.list_1 = list_1;
    }
}
