package first_stage;

import java.util.Scanner;

public class StringBuilderTest01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String line = sc.nextLine();
        String s =reverse(line);
        System.out.println(s);
    }
    public static String reverse(String str){
        return new StringBuilder(str).reverse().toString();
    }
}
