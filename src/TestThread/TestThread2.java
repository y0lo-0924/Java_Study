package TestThread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
    
//练习Thread，实现多线程同步下载图片
public class TestThread2 extends Thread {
    private String url; //网络图片地址
    private String name; //保存的文件名
    public TestThread2(String url,String name){
        this.url=url;
        this.name=name;
    }

    @Override
    public void run(){
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.juimg.com%2Ftuku%2Fyulantu%2F140703%2F330746-140f301555752.jpg&refer=http%3A%2F%2Fimg.juimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1622537328&t=811be68acf72ee6435a4acd230feeaa8","1.jpg");
        TestThread2 t2 = new TestThread2("http://www.ghost64.com/qqtupian/zixunImg/local/2019/09/03/15675049294770.jpg","2.jpg");
        TestThread2 t3 = new TestThread2("http://www.ghost64.com/qqtupian/zixunImg/local/2019/09/03/15674413876740.jpg","3.jpg");

        t1.start();
        t2.start();
        t3.start();
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