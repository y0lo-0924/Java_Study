package first_stage;

import java.util.Scanner;

public class StringTest01 {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = s1.nextLine();
        reverse(str);
    }

    public static void reverse(String str) {
        for (int i = str.length()-1; i >= 0; i--) System.out.print(str.charAt(i));
    }
}
