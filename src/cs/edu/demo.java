package cs.edu;

import cs.edu.Student;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Student stu = new Student("001","王健","计算机科学与技术");
        System.out.println("please input student name or input student name and major.");
        if(stu.search(input.next())|| stu.search(input.next(),input.next()))
        stu.print();
        else System.out.println("no exit");
    }
}
