package second_stage;

public class Person {
    String name;
    int age;
    public Person(){

    }
    public Person(String name,int age){
        this.name= name;
        this.age=age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

class Teacher extends Person{
    public Teacher(){

    }
    public void teach(){
        System.out.println("老师教书");
    }
}

class Student extends Person{
    public Student(){

    }
    public void study(){
        System.out.println("学生学习");
    }
}

class PersonDemo{
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.setAge(25);
        teacher.setName("aaa");
        System.out.println("老师的姓名："+teacher.getName()
        +'\n'+"老师的年龄："+teacher.getAge());
        teacher.teach();
    }
}