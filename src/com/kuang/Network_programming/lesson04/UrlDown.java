package com.kuang.Network_programming.lesson04;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlDown {
    public static void main(String[] args) throws Exception {
        //1.下载地址
        URL url = new URL("https://y0lo-0924.github.io/");

        //2.连接到这个资源 HTTP
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();

        FileOutputStream fos = new FileOutputStream("SecurityFile.html");

        byte[] buffer = new byte[1024];
        int len;
        while ((len=inputStream.read(buffer))!=-1){
            fos.write(buffer,0,len);    //写出这个数据
        }

        fos.close();
        inputStream.close();
        urlConnection.disconnect();
    }
}
