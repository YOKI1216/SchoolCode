package cs.edu;

public class Student {
    private String code;
    private String name;
    private String major;

    public Student(String code, String name) {
        this.code = code;
        this.name = name;
    }
    public Student(String code, String name, String major) {
        this(code,name);
        this.major = major;
    }

    void print(){
        System.out.println("Student information:");
        System.out.println("code:"+code);
        System.out.println("name:"+name);
        System.out.println("major:"+major);
    }
    boolean search(String str){
        if(name.equals(str))
            return true;
        return false;
    }
    boolean search(String str1,String str2){
        if(name.equals(str1)||major.equals(str2))
            return true;
        return false;
    }
}
