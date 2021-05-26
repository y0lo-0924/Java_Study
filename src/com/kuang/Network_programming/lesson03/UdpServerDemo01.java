package com.kuang.Network_programming.lesson03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

//还是要等待客户端的链接！
public class UdpServerDemo01 {
    public static void main(String[] args) throws Exception {
        //开放端口
        DatagramSocket socket = new DatagramSocket(9090);
        //接受数据包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);
        socket.receive(packet);     //阻塞接受

        System.out.println(packet.getAddress().getHostAddress());
        System.out.println(new String(packet.getData(),0,packet.getLength()));


        //关闭连接
        socket.close();

    }
}
