package Test;

class Base{}

public class MyCast extends Base{
    static boolean b1=false;
    static int i = -1;
    static double d = 10.1;
    public static void main(String argv[]) {
        MyCast m = new MyCast();
        Base b = new Base();
        //Here
        b=m;
//        m=b;
        d=i;
//        b1=i;
    }
}
