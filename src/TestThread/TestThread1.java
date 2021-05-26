package TestThread;

//创建线程方式一：继承Thread类，重写run()方法，调用start开启线程
public class TestThread1 extends Thread{
    @Override
    public void run(){
        //run方法线程体
        for(int i=0;i<20;i++)
            System.out.println("我在看代码---"+i);
    }

    public static void main(String[] args) {
        //main线程，主线程

        //创建一个线程对象
        TestThread1 thread1 = new TestThread1();
        //调用start方法
        thread1.start();
//        thread1.run();

        for(int i=0;i<20;i++)
            System.out.println("我学习多线程---"+i);
    }
}
