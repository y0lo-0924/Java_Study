package first_stage;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        //创建集合对象
         ArrayList<Student> array = new ArrayList<>();
        //创建学生对象
         Student s1 = new Student("林青霞", 30);
         Student s2 = new Student("风清扬", 33);
         Student s3 = new Student("张曼玉", 18);
        //添加学生对象到集合中
         array.add(s1);
         array.add(s2);
         array.add(s3);
        //遍历集合，采用通用遍历格式实现
         for (int i = 0; i < array.size(); i++) {
             Student s = array.get(i);
             System.out.println(s.getName() + "," + s.getAge());
        }
    }
}
