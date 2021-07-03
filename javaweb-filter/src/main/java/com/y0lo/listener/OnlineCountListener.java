package com.y0lo.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//统计网站在线人数：统计session
public class OnlineCountListener implements HttpSessionListener {

    //创建session监听：看你的一举一动
    //一旦创建Session就会触发这个事件
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext ctx = httpSessionEvent.getSession().getServletContext();

        System.out.println(httpSessionEvent.getSession().getId());
        Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");
        if(onlineCount==null){
            onlineCount=new Integer(1);
        }else {
            int count=onlineCount.intValue();

            onlineCount=new Integer(count+1);
        }
        ctx.setAttribute("OnlineCount",onlineCount);
    }

    //销毁session监听
    //一旦销毁Session就会触发这个事件
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext ctx = httpSessionEvent.getSession().getServletContext();
        Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");
        if(onlineCount==null){
            onlineCount=new Integer(0);
        }else {
            int count=onlineCount.intValue();

            onlineCount=new Integer(count-1);
        }
        ctx.setAttribute("OnlineCount",onlineCount);
    }
}
/*
* Session销毁：
* 1. 手动销毁   getSession().invalidate();
* 2. 自动销毁
*     <session-config>
        <session-timeout>1</session-timeout>
      </session-config>
* */
