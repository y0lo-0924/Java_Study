package com.kuang.reflection;

public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException {

        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父类加载器-->扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取扩展类加载器的父类加载器-->根加载器(C/C++)
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //测试当前类是哪个类加载的
        ClassLoader classLoader = Class.forName("com.kuang.reflection.Test07").getClassLoader();
        System.out.println(classLoader);

        //测试JDK内置的类是谁加载的
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);

        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));


        //双亲委派机制
        /*
        D:\Java\jdk1.8.0_201\jre\lib\charsets.jar;
        D:\Java\jdk1.8.0_201\jre\lib\deploy.jar;
        D:\Java\jdk1.8.0_201\jre\lib\ext\access-bridge-64.jar;
        D:\Java\jdk1.8.0_201\jre\lib\ext\cldrdata.jar;
        D:\Java\jdk1.8.0_201\jre\lib\ext\dnsns.jar;
        D:\Java\jdk1.8.0_201\jre\lib\ext\jaccess.jar;
        D:\Java\jdk1.8.0_201\jre\lib\ext\jfxrt.jar;
        D:\Java\jdk1.8.0_201\jre\lib\ext\localedata.jar;
        D:\Java\jdk1.8.0_201\jre\lib\ext\nashorn.jar;
        D:\Java\jdk1.8.0_201\jre\lib\ext\sunec.jar;
        D:\Java\jdk1.8.0_201\jre\lib\ext\sunjce_provider.jar;
        D:\Java\jdk1.8.0_201\jre\lib\ext\sunmscapi.jar;
        D:\Java\jdk1.8.0_201\jre\lib\ext\sunpkcs11.jar;
        D:\Java\jdk1.8.0_201\jre\lib\ext\zipfs.jar;
        D:\Java\jdk1.8.0_201\jre\lib\javaws.jar;
        D:\Java\jdk1.8.0_201\jre\lib\jce.jar;
        D:\Java\jdk1.8.0_201\jre\lib\jfr.jar;
        D:\Java\jdk1.8.0_201\jre\lib\jfxswt.jar;
        D:\Java\jdk1.8.0_201\jre\lib\jsse.jar;
        D:\Java\jdk1.8.0_201\jre\lib\management-agent.jar;
        D:\Java\jdk1.8.0_201\jre\lib\plugin.jar;
        D:\Java\jdk1.8.0_201\jre\lib\resources.jar;
        D:\Java\jdk1.8.0_201\jre\lib\rt.jar;
        D:\code\java_study\out\production\java_study;
        D:\code\java_study\src\lib\commons-io-2.8.0.jar;
        D:\code\java_study\src\lib\commons-io-2.8.0-bin.zip;
        D:\idealC-2020.3.2\IntelliJ IDEA Community Edition 2020.3.2\lib\idea_rt.jar
         */
    }
}
