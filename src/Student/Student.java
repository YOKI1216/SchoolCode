package Student;

public class Student {

    private String code;
    private String name;
    private String sex;
    private String classNum;

    public Student() {
    }
    public Student(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Student(String code, String name, String sex, String classNum) {
        this.code = code;
        this.name = name;
        this.sex = sex;
        this.classNum = classNum;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }
    public void print(){
        System.out.println("student information：");
        System.out.println("student code:"+code);
        System.out.println("student name:"+name);
        System.out.println("student class:"+classNum);
    }
}
