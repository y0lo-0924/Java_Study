package first_stage;

import java.util.Scanner;
public class ScannerTest {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        int height1 = s1.nextInt();
        int height2 = s1.nextInt();
        int height3 = s1.nextInt();
        int tempHeight = height1 > height2 ? height1 : height2;
        int MaxHeight = height2>height3 ? height2 : height3;
        System.out.println("MaxHeight is "+MaxHeight+" cm");
    }
}
