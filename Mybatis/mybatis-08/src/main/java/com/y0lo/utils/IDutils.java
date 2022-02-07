package com.y0lo.utils;

import org.junit.*;
import java.util.UUID;

@SuppressWarnings("all")    //抑制警告
public class IDutils {
    public static String getId(){
        return UUID.randomUUID().toString().replace("-","");
    }

    @Test
    public void test(){
        System.out.println(IDutils.getId());
    }
}
