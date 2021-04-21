package Collection;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class linkedList_use {

    public static void main(String[] args) {
        //理论上可以存储无限个数据
        LinkedList<String> list = new LinkedList<>();
        list.add("abc");
        System.out.println(list.get(0));
        list.remove(0);
        list.toArray();

    }


}
