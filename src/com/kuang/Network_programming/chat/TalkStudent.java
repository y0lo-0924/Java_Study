package com.kuang.Network_programming.chat;

public class TalkStudent {
    public static void main(String[] args) {
        //开启两个线程
        new Thread(new TalkSend(6789,"localhost",7890)).start();
        new Thread(new TalkReceive(8777,"老师")).start();
    }
}
