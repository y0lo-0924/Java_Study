package LambdaDemo;

public class TestLambda2 {
    public static void main(String[] args) {
        Ilove love;
/*        Ilove love = (int a) ->{
                System.out.println("i love you-->"+a);
            };*/

        //简化1.去掉参数类型
/*        love = (a) ->{
            System.out.println("i love you-->"+a);
        };*/

        //简化2.简化括号
/*        love = a -> {
            System.out.println("i love you-->"+a);
        };*/

        //简化3.去掉花括号
        love = a-> System.out.println("i love you-->"+a);

        //总结：
            //lambda表达式只能有一行代码的情况下才能简化成为一行，如果有多行，那么就用代码块包裹
            //前提是函数式接口
            //多个参数也可以去掉参数类型，要去掉就都去掉，必须要加上括号

        love.love(2);
    }
}

interface Ilove{
    void love(int a);
}

