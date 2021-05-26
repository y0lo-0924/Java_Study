package StudentManager;

public class Student {
    //学号
    private String sid;
    //姓名
    private String name;
    //年龄
    private int age;
    public Student(){}
    public Student(String sid,String name,int age){
        this.sid=sid;
        this.name=name;
        this.age=age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSid(String sid) {
        this.sid = sid;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getSid() {
        return sid;
    }
}
