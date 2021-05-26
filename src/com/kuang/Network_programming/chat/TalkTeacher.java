package com.kuang.Network_programming.chat;

public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkSend(4567,"localhost",8777)).start();
        new Thread(new TalkReceive(7890,"学生")).start();
    }
}
