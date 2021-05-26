package StudentManager;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        //创建集合对象，用于保存学生信息
        ArrayList<Student> array = new ArrayList<Student>();

        //
        while(true){
            System.out.println("------欢迎来到学生管理系统------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("0 退出");
            System.out.println("请输入你的选择");

            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            switch (choice){
                case "0":
                    System.out.println("谢谢使用");
                    //JVM退出
                    System.exit(0);
                case "1":
                    addStudent(array);
                    break;
                case "2":
                    deleteStudent(array);
                    break;
                case "3":
                    updateStudent(array);
                    break;
                case "4":
                    displayStudent(array);
                    break;
                default:
                    System.out.println("输入不合格，请重新输入！");
                    break;
            }
        }
    }

    public static void addStudent(ArrayList<Student> array){
        Scanner sc = new Scanner(System.in);
        String sid,name;
        int age;
            System.out.println("请输入学号");
            sid=sc.nextLine();
            if ((isUsed(array, sid))) {
                System.out.println("您输入的学号已经被占用，请重新输入");
                return;
            } else {
                System.out.println("请输入姓名");
                name=sc.nextLine();
                System.out.println("请输入年龄");
                age = sc.nextInt();
                Student s = new Student(sid,name,age);
                //将学生对象添加到集合中
                array.add(s);
                //给出添加成功提示
                System.out.println("添加学生成功");
            }
    }

    //定义一个删除学生的方法
    public static void deleteStudent(ArrayList<Student> array){
        //键盘录入要删除的学生的学号，显示提示信息
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你要删除的学生的学号：");
        String sid = sc.nextLine();

        //在删除/修改学生操作前，对学号是否存在进行判断
        //不存在，显示提示信息
        //存在，执行删除/修改操作
        int index =-1;
        for(int i=0;i<array.size();i++){
            Student s = array.get(i);
            if(s.getSid().equals(sid)) {
                index=i;
                break;
            }
        }

        if(index==-1){
            System.out.println("您输入的学号有误，请重新输入");
        }else {
            array.remove(index);
            System.out.println("删除成功");
        }
    }
    public static void displayStudent(ArrayList<Student> array){
        for(int i=0;i<array.size();i++){
            Student s = array.get(i);
            System.out.println("学号："+s.getSid());
            System.out.println("姓名："+s.getName());
            System.out.println("年龄："+s.getAge());
            System.out.println("");
        }
    }
    public static void updateStudent(ArrayList<Student> array){
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你要修改的学生的学号");
        String sid = sc.nextLine();

        if(isUsed(array,sid)){
            System.out.println("请输入新姓名：");
            String name =sc.nextLine();
            System.out.println("请输入新年龄");
            Integer age = sc.nextInt();
            Student s = new Student();
            s.setSid(sid);
            s.setName(name);
            s.setAge(age);
            for(int i=0;i<array.size();i++){
                Student stu = array.get(i);
                if(stu.getSid().equals(sid)) {
                    array.set(i,s);
                    break;
                }
            }
        }else {
            System.out.println("该学号不存在请重新输入");
            return;
        }
    }

    //定义一个方法判断学号是否被占用
    public static boolean isUsed(ArrayList<Student> array,String sid){
        boolean flag = false;
        for(int i=0;i<array.size();i++){
            Student s = array.get(i);
            if(s.getSid().equals(sid)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
