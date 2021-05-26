package first_stage;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        //创建数组
        ArrayList <String> array = new ArrayList<String>();

        //添加元素
        array.add("hello");
        array.add("world");
        array.add("java");
        System.out.println(array.size());
        System.out.println("array:"+array);

        //遍历集合
        for(int i=0;i<array.size();i++){
            String s = array.get(i);
            System.out.println(s);
        }
    }
}
