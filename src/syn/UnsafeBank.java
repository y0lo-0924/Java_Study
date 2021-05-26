package syn;

//不安全的取钱
//两个人去银行取钱
public class UnsafeBank {
    public static void main(String[] args) {
        //账号
        Account account = new Account(1000,"结婚基金");

        Drawing you = new Drawing(account,50,"你");
        Drawing girlfriend = new Drawing(account,100,"girlfriend");

        you.start();
        girlfriend.start();
    }

}

//账户
class Account{
    int money;      //余额
    String name;    //卡号
    public Account(int money,String name){
        this.money=money;
        this.name=name;
    }
}

//银行：模拟取款
class Drawing extends Thread{
    Account account;    //账户
    //取了多少钱
    int drawingMoney;
    //现在手里有多少钱
    int nowMoney;

    public Drawing(Account account,int drawingMoney,String name){
        super(name);
        this.account=account;
        this.drawingMoney=drawingMoney;
    }

    //取钱
    //synchronized 默认锁的是this
    @Override
    public void run() {


        //锁的对象就是变化的量，需要增删改
        synchronized (account){
            //判断有没有钱
            if(account.money-drawingMoney<0){
                System.out.println(Thread.currentThread().getName()+"钱不够，取不了");
                return;
            }

            //sleep可以放大问题的发生性
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //卡内余额 = 余额 - 你取的钱
            account.money-=drawingMoney;

            //你手里的钱
            nowMoney+=drawingMoney;

            System.out.println(account.name+"余额为："+account.money);
            //this.getName()==Thread.currentThread().getName()
            System.out.println(this.getName()+"手里的钱："+nowMoney);
        }
    }
}