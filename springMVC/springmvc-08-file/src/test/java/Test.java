public class Test {
    private static int a = 1;
    private int b = 1;
    public void add(){
        a++;
        b++;
    }

    public static void main(String[] args) {
        Test test1 = new Test();
        Test test2 = new Test();
        test1.add();
        test2.add();
        System.out.println("test1.a==>"+test1.a);
        System.out.println("test1.b==>"+test1.b);
        System.out.println("test2.a==>"+test2.a);
        System.out.println("test2.b==>"+test2.b);
    }
}
