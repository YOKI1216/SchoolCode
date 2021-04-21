package Collection;

import java.util.HashSet;
import java.util.Objects;

public class HashSet_use  {
    private String name;
    private String age;
    public static void main(String[] args) {
        HashSet <HashSet_use> set = new HashSet<>();
        HashSet_use myself = new HashSet_use("name1","19");
        set.add(myself);
//        System.out.println(myself.toString());
        HashSet <String> set_1 = new HashSet<>();
        set_1.add("name1");
        set_1.add("name3");
        set_1.add("name2");
        set_1.add("name4");
        set_1.add("5");
        set_1.add("4");
        set_1.add("5" + "abc");
        System.out.println(set_1);
    }
    //创建对象时，传参数进去
    public HashSet_use(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HashSet_use)) return false;
        HashSet_use that = (HashSet_use) o;
        return Objects.equals(name, that.name) && Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return this.name+"\t"+this.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
