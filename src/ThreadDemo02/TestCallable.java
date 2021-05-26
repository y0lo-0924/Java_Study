package ThreadDemo02;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

//线程创建方式三，实现callable接口
/*
* callable的好处
* 1.可以定义返回值
* 2.可以抛出异常
* */
public class TestCallable implements Callable {
    private String url; //网络图片地址
    private String name; //保存的文件名
    public TestCallable(String url,String name){
        this.url=url;
        this.name=name;
    }

    @Override
    public Boolean call(){
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.juimg.com%2Ftuku%2Fyulantu%2F140703%2F330746-140f301555752.jpg&refer=http%3A%2F%2Fimg.juimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1622537328&t=811be68acf72ee6435a4acd230feeaa8","1.jpg");
        TestCallable t2 = new TestCallable("http://www.ghost64.com/qqtupian/zixunImg/local/2019/09/03/15675049294770.jpg","2.jpg");
        TestCallable t3 = new TestCallable("http://www.ghost64.com/qqtupian/zixunImg/local/2019/09/03/15674413876740.jpg","3.jpg");

        //创建执行服务:
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行:
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);

        //获取结果:
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();

        //关闭服务:
        ser.shutdownNow();
    }
}
class WebDownloader{
    //下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}