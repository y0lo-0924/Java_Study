package com.y0lo.demo04;

import com.y0lo.demo03.Rent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//我们会用这个类，自动生成代理类！
public class ProxyInvocationHandler implements InvocationHandler {

/*    Foo f = (Foo) proxy.newProxyInstance(Foo.class.getClassLoader(),
            new Class<?>[]{Foo.class},
            handler);*/

    //被代理的接口
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    //生成得到代理
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this );
    }


    //处理代理实例，并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        //动态代理的本质，就是使用反射机制实现！
        Object result = method.invoke(target, args);
        return null;
    }
    public void log(String msg){
        System.out.println("执行了" + msg + "方法");
    }
}
