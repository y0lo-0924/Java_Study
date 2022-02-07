package com.y0lo.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.y0lo.pojo.User;
import com.y0lo.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller
@RestController     //RestController 相当于@Controller+@ResponseBody两个注解的结合，只返回json数据
public class UserController {

//    @RequestMapping(value = "/j1",produces = "application/json;charset=utf-8")
    @RequestMapping("j1")
    /*@ResponseBody   //它就不会走视图解析器，会直接返回一个字符串*/
    public String json1() throws JsonProcessingException {

        //jackson ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        User user = new User("y0lo", 20, "男");
        String s = mapper.writeValueAsString(user);

        return s;
    }


    @RequestMapping("j2")
    public String json2() throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();

        List<User> userList = new ArrayList<User>();

        User user1 = new User("y0lo1", 20, "男");
        User user2 = new User("y0lo2", 20, "男");
        User user3 = new User("y0lo3", 20, "男");
        User user4 = new User("y0lo4", 20, "男");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

//        String s = mapper.writeValueAsString(userList);

        return JsonUtils.getJson(userList);
    }

    @RequestMapping("j3")
    public String json3() throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();

        Date date = new Date();

        //自定义日期的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //使用ObjectMapper来格式化输出
        //关闭时间戳
        mapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS,false);
        mapper.setDateFormat(sdf);

        //Timestamp 时间解析后的格式，默认是时间戳
        String s = mapper.writeValueAsString(date);
        return s;
    }

    @RequestMapping("j4")
    public String json4() throws JsonProcessingException{
        Date date =new Date();
        return JsonUtils.getJson(date,"yyyy-MM-dd HH:mm:ss");
    }

    @RequestMapping("j5")
    public String json5(){
        List<User> userList = new ArrayList<User>();

        User user1 = new User("y0lo1", 20, "男");
        User user2 = new User("y0lo2", 20, "男");
        User user3 = new User("y0lo3", 20, "男");
        User user4 = new User("y0lo4", 20, "男");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        String s = JSON.toJSONString(userList);
        return s;
    }
}
