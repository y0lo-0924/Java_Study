package TestThread;

//测试守护线程
//上帝守护你
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true);     //模式是false表示是用户线程，正常的线程都是守护线程

        thread.start();     //上帝守护线程启动

        new Thread(you).start();    //你-->用户线程启动
    }
}

//上帝

class God implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println("上帝保佑着你");
        }
    }
}


//你
class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你一生都开心的活着");
        }
        System.out.println("======goodbye! world!=====");
    }
}
