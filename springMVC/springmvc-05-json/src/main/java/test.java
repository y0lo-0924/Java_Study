import java.util.Scanner;

class test1{
    public test1(){
        System.out.println("父类无参空构造");
    }
    public test1(String name){
        System.out.println("带一个String参数的构造函数");
    }
    public test1(int age){
        System.out.println("带一个int参数的构造函数");
    }
    public void father(){
        System.out.println("");
    }
}

public class test extends test1{
    public test(){
        System.out.println("子类无参空构造");
    }
    public test(String a){
        System.out.println("子类有参构造");
    }
    public static void main(String[] args) {
        test a = new test("abc");
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());

    }
}
