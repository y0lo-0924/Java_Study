package com.y0lo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

public class JsonUtils {
    public static String getJson(Object object,String dateFormat){
        ObjectMapper mapper = new ObjectMapper();
        //自定义日期的格式
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

        //使用ObjectMapper来格式化输出
        //关闭时间戳
        mapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS,false);
        mapper.setDateFormat(sdf);

        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;

        }
    }

    public static String getJson(Object object){
        return getJson(object,"yyyy-MM-dd HH:mm:ss");
    }
}
