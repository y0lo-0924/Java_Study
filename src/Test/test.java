package Test;

public class test {
/*    public static void main(String argv[]){
        String x="hello";
        change(x);
        System.out.println(x);
    }
    static void change(String m){
        m=m+2;
    }*/

//    int i;
//    public static void main(String argv[]){
//        test s = new test();
//        s.amethod();
//    }
//    public static void amethod(){
//        System.out.println(i);
//    }

/*public static void main(String argv[]) {
    test m = new test();
    m.amethod();
}
    public void amethod(){
        static int i;
        System.out.println(i);
    }*/


//    int m=5;
//    public  void some(int x) {
//        m=x;
//    }
//    public static void main(String args []) {
//        new Demo().some(7);
//    }
//}
//class Demo extends test {
//    int m=8;
//    public  void some(int x) {
//        super.some(x);
//        System.out.println(m);
//    }

/*    public String name = "Outer";
    public static void main(String argv[]){
        Inner i = new Inner();
        i.showName();
    }
    class Inner{
        String name =new String("Inner");
        void showName(){
            System.out.println(name);
        }
    }*/

    public static void main(String[] args) {
        char c='\0';
        for(int i=1;i<=4;i++){
            switch (i){
                case 1: c='j';
                    System.out.println(c);
                case 2: c ='e';
                    System.out.println(c);
                    break;
                case 3: c='p';
                    System.out.println(c);

                default:
                    System.out.println("好");

            }
        }
    }

}
