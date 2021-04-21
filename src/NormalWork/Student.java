package NormalWork;

public class Student {

    private String code;
    private String name;
    private String sex;
    private String major;
    private String phone;
    public Student() {
    }
    public Student(String code, String name, String sex, String major, String phone) {
        this.code = code;
        this.name = name;
        this.sex = sex;
        this.major = major;
        this.phone = phone;
    }
    public void showStudent(){
        System.out.println("学生信息如下：");
        System.out.println("姓名："+name);
        System.out.println("性别："+sex);
        System.out.println("学号："+code);
        System.out.println("专业："+major);
        System.out.println("电话："+phone);
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
