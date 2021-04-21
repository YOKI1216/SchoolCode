package TestSeat;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public  class TestSeat_MainCode {

    private String time;//考试时间
    private String stuClass;//考生班级
    private int stuNum;//考生人数
    private String function;//编排要求
    private String[][] classLayout;//教室布局
    private String[]stuInformation;//全部考生信息
    private String stu;//考生个人考试信息

    public static void main(String[] args) throws IOException, ParseException {
        //界面
        System.out.println("===============================================================");
        System.out.println("===============================================================");
        System.out.println("============                                       ============");
        System.out.println("============          欢迎来到考试座位分配系统          ============");
        System.out.println("============                                       ============");
        System.out.println("===============================================================");
        System.out.println("===============================================================");
        TestSeat_MainCode myself = new TestSeat_MainCode();
        Scanner input = new Scanner(System.in);
        System.out.println("#请输入考试时间、考生班级、考生人数");
        System.out.println(" *输入格式");
        System.out.println("  —时间格式：yyyy年MM月dd号HH时mm分");

        myself.setTime(input.next());

        System.out.println(myself.testTime());

        System.out.println("考试时间输入成功："+myself.getTime());
        System.out.println("  -班级格式：学院+专业+年级+班级");
        myself.setStuClass(input.next());
        System.out.println("  -人数格式：2");
        myself.setStuNum(input.nextInt());
        myself.setStuInformation(new String[myself.getStuNum()]);
        //学生信息导入
        boolean judge = true;
        do {
            System.out.println("#输入1    新建学生信息表格");
            System.out.println("#输入2    导入已有学生表格");
            System.out.println("#输入3    进入下一步");
            int num= input.nextInt();
            int i= 0;
            switch (num){
                case 1:
                    System.out.println("#填写考生信息导入考生考试信息表");
                    System.out.println("#实例  1-张三");
                    while( i<myself.getStuNum()){
                        myself.setStu(input.next());
                        myself.stuInformation(myself.getStu());
                        i++;
                    }
                    break;
                case 2:
                    System.out.println("#导入考生考试信息表");
                    myself.setStuInformation(myself.readStuInformation());
                    myself.setStuNum(myself.getStuInformation().length);
                    break;
                case 3:
                    judge = false;
                    break;
                case 4:
                    System.out.println("#查询考生考试信息");
                    String test = Arrays.toString(myself.getStuInformation());
                    System.out.println(test);
                default:
                    System.out.println("重新输入选择数字");
                    break;

            }
        }while(judge);

        //初始化不同座位数的教室布局
        System.out.println("输入教室座位列数进行教室布局初始化");
        int column = input.nextInt();//列
        int row = 0;//行
        if(column>=1){
            if(myself.getStuNum()%column==0){
                row = myself.getStuNum()/column;
            }else row+= myself.getStuNum()/column;
        }else System.out.println("输入错误，请重新输入");
        String[][] ClassLayout = new String[row][2*column];
        myself.setClassLayout(ClassLayout);
        //座位表生成
        System.out.println("#输入考试座位编排要求，三选一：横向、纵向、随机。");
        String choose = input.next();
        myself.setClassLayout(myself.function(choose, myself.getStuInformation(), myself.getClassLayout()));
        judge = true;
        do {

            System.out.println("#输入：1输出座位表或输入：2导出座位表到目录\n#输入3：退出");
            //输入1输出座位表或输入2导出座位表到目录
            int num= input.nextInt();
            switch (num){
                case 1:
                    System.out.println("生成考试座位表");
                    System.out.println("考试时间为："+myself.time);
                    myself.printSeatList(myself.getClassLayout(),myself.time, myself.stuClass);
                    break;
                case 2:
                    System.out.println("导出考试座位表");
                    myself.seatFile(myself.getClassLayout(), myself.time);
                    break;
                case 3:
                    judge = false;
                    System.out.println("非常感谢本次的使用，你的一键三连是对作者最大的支持，下次再见！");
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }while(judge);

    }
    //考试时间
    public  String testTime() throws ParseException {
        //格式为yyyy-MM-dd-HH

        checkTimeFormat();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd号HH时mm分");
        //将字符串返回一个date对象，
        Date date = sdf.parse(time);
        return sdf.format(date);
    }
    //输入座位编排要求：三选一：横向、纵向、随机。
    public  String[][] function(String choose,String[] stuInformation,String[][] classLayout){
        switch (choose){
            case"横向":
                int stuNum=0;
                   for (int i = 0; i < classLayout.length; i++) {
                       for (int j = 0; j < classLayout[i].length; j++) {
                        if(j%2==0){
                            classLayout[i][j] = "空座位";
                        }
                        if ((j%2!=0)){
                            classLayout[i][j] = stuInformation[stuNum];
                            stuNum++;
                        }
                       }
                   }
                break;
            case"纵向":
                stuNum=0;
                for (int i = 0; i < classLayout[0].length; i++) {//columnLength
                    for (int j = 0; j < classLayout.length; j++) {//rowLength
                        if(i%2==0){
                            classLayout[j][i] = "空座位";
                        }
                        if ((i%2!=0)){
                            classLayout[j][i] = stuInformation[stuNum];
                            stuNum++;
                        }
                    }
                }
                break;
            case"随机":
                ArrayList <String> list = new ArrayList<>();
                Collections.addAll(list, stuInformation);
                Collections.shuffle(list);
                for (int i = 0; i < list.size(); i++) {
                    stuInformation[i] = list.get(i);
                }
                stuNum = 0;
                for (int i = 0; i < classLayout.length; i++) {
                    for (int j = 0; j < classLayout[i].length; j++) {
                        if(j%2==0){
                            classLayout[i][j] = "空座位";
                        }
                        if ((j%2!=0)){
                            classLayout[i][j] = stuInformation[stuNum];
                            stuNum++;
                        }
                    }
                }
                break;
            default:
                System.out.println("输入错误，请重新输入");
        }
        return classLayout;
    }
    //输入学生名单功能：要求输入以下信息：序号、姓名。
    public  void stuInformation(String information) throws IOException {
        File stuInformation = new File("D:\\学生管理系统");
        stuInformation.mkdir();
        FileOutputStream FileOutput = new FileOutputStream("D:\\学生管理系统\\学生信息.xlsx",true);
        FileOutput.write("\n".getBytes(StandardCharsets.UTF_8));
        FileOutput.write(information.getBytes(StandardCharsets.UTF_8));
    }
    //导入学生名单
    public  String[] readStuInformation() throws IOException {
        File readFile = new File("D:\\学生管理系统\\学生信息.txt");
        FileInputStream fileInput = new FileInputStream(readFile);
        int length =fileInput.available();
        byte[] size = new byte[length];
        fileInput.read(size);
        String list1 = new String(size);
        System.out.println("导入成功，表中数据如下");
        System.out.println(list1);
        return list1.split("\n");

    }

    //输出座位表：要求以“序号姓名”格式（如1黄小萌）填入到各个座位上并输出。
    public  void printSeatList(String[][] classLayout,String time,String stuClass){
        System.out.println("输出程序执行");
        System.out.println("考试时间为："+time);
        System.out.println("考试班级为："+stuClass);
        int StringMax = 0;
        for (String[] strings : classLayout) {
            if (strings.length > StringMax) {
                StringMax = strings.length;
            }
        }
        for (String[] strings : classLayout) {
            for (String string : strings) {
                StringBuilder print = new StringBuilder(string + "\t");
                while (print.length() < StringMax) {
                    print.append(' ');
                }
                System.out.print(print);
            }
            System.out.println();
        }
    }
    //把生成的座位表导出到文件中保存。
    public  void seatFile(String[][] classLayout,String time)throws IOException{

            FileOutputStream output = new FileOutputStream("D:\\学生管理系统.txt",true);
            output.write(("考试班级为："+stuClass+"\n").getBytes(StandardCharsets.UTF_8));
            output.write(("考试时间为:\t"+time+"\n").getBytes(StandardCharsets.UTF_8));
        for (String[] strings : classLayout) {
            for (String string : strings) {
                output.write(string.getBytes(StandardCharsets.UTF_8));
                output.write("\t".getBytes(StandardCharsets.UTF_8));
            }
            output.write("\n".getBytes(StandardCharsets.UTF_8));
        }
            output.close();
    }

    public void checkTimeFormat(){
        Scanner update = new Scanner(System.in);
        String regularExpress = "^[0-9]{1,4}年[1-9]{1,2}月[1-9]{1,2}号[0-9]{1,2}时[0-9]{1,2}分$";
        boolean judge = time.matches(regularExpress);
        while (!judge){
            System.out.println("输入错误，请重新输入");
            time = update.next();
            judge = time.matches(regularExpress);
        }
    }



    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public int getStuNum() {
        return stuNum;
    }

    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String[] getStuInformation() {
        return stuInformation;
    }

    public void setStuInformation(String[] stuInformation) {
        this.stuInformation = stuInformation;
    }

    public String getStu() {
        return stu;
    }

    public void setStu(String stu) {
        this.stu = stu;
    }

    public String[][] getClassLayout() {
        return classLayout;
    }

    public void setClassLayout(String[][] classLayout) {
        this.classLayout = classLayout;
    }

}
