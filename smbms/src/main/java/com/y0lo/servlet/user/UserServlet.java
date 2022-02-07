package com.y0lo.servlet.user;

import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.util.StringUtils;
import com.y0lo.pojo.Role;
import com.y0lo.pojo.User;
import com.y0lo.service.role.RoleServiceImpl;
import com.y0lo.service.user.UserService;
import com.y0lo.service.user.UserServiceImpl;
import com.y0lo.util.Constants;
import com.y0lo.util.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//实现Servlet复用
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if(method.equals("savepwd")&&method!=null){
            this.updatePwd(req,resp);
        }else if(method.equals("pwdmodify")&&method!=null){
            this.pwdModify(req,resp);
        }else if(method.equals("query")&&method!=null){
            this.query(req,resp);
        }
    }

    //重点、难点
    public void query(HttpServletRequest req, HttpServletResponse resp){

        //查询用户列表

        //从前端获取数据
        String queryUserName = req.getParameter("queryname");
        String temp = req.getParameter("queryUserRole");
        String pageIndex = req.getParameter("pageIndex");
        int queryUserRole=0;

        //获取用户列表
        UserServiceImpl userService = new UserServiceImpl();

        //第一次走这个请求，一定是第一页，页面大小固定的
        int pageSize=5;     //可以把这个写到配置文件里，方便后期修改
        int currentPageNo=1;
        List<User> userList;


        if(queryUserName==null){
            queryUserName="";
        }
        if(temp!=null&& !temp.equals("")){
            queryUserRole=Integer.parseInt(temp);      //给查询赋值
        }
        if(pageIndex!=null){

            try {
                currentPageNo = Integer.parseInt(pageIndex);
            } catch (Exception e) {
                try {
                    resp.sendRedirect("error.jsp");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }

        //获取用户的总数（分页：上一页、下一页）
        int totalCount = userService.getUserCount(queryUserName, queryUserRole);

        //总页数支持
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);

        int totalPageCount = pageSupport.getTotalPageCount();   //总共有几页

        //控制首页和尾页
        //如果页面要小于1了，就显示第一页的东西
        if(totalPageCount<1){
            currentPageNo=1;
        }else if(currentPageNo>totalPageCount){ //当前页面大于了最后一页
            currentPageNo=totalPageCount;
        }


        //获取用户列表显示
        userList=userService.getUserList(queryUserName, queryUserRole, currentPageNo, pageSize);
        req.setAttribute("userList",userList);
        RoleServiceImpl roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleList();
        req.setAttribute("roleList",roleList);
        req.setAttribute("totalCount",totalCount);
        req.setAttribute("currentPageNo",currentPageNo);
        req.setAttribute("totalPageCount",totalPageCount);
        req.setAttribute("queryUserName",queryUserName);
        req.setAttribute("queryUserRole",queryUserRole);

        //返回前端
        try {
            req.getRequestDispatcher("userlist.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException     {
        doGet(req, resp);
    }
    //修改密码
    public void updatePwd(HttpServletRequest req, HttpServletResponse resp){
        //从Session里面拿ID;
        Object o = req.getSession().getAttribute(Constants.USER_SESSION);
        String newpassword = req.getParameter("newpassword");
        System.out.println("UserServlet:"+newpassword);

        boolean flag = false;

        if(o!=null && !StringUtils.isNullOrEmpty(newpassword)){
            UserService userService = new UserServiceImpl();
            flag = userService.updatePwd(((User) o).getId(), newpassword);
            System.out.println(flag);
            if(flag){
                req.setAttribute("message","修改密码成功，请退出，使用新密码登录");
                //密码修改成功，移除当前Session
                req.getSession().removeAttribute(Constants.USER_SESSION);
            }else {
                //密码修改失败
                req.setAttribute("message","密码修改失败");
            }
        }else {
            req.setAttribute("message","新密码有问题");
        }

        try {
            req.getRequestDispatcher("pwdmodify.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //验证旧密码，session中有用于的密码
    public void pwdModify(HttpServletRequest req, HttpServletResponse resp){
        Object o = req.getSession().getAttribute(Constants.USER_SESSION);
        String oldpassword = req.getParameter("oldpassword");

        //万能的Map ： 结果集
        Map<String,String> resultMap= new HashMap<String, String>();
        if(o==null){    //Session失效了，Session过期了
            resultMap.put("result","sessionerror");
        }else if(StringUtils.isNullOrEmpty(oldpassword)){   //输入的密码为空
            resultMap.put("result","error");
        }else {
            String userPassword = ((User) o).getUserPassword(); //Session中用户的密码
            if(oldpassword.equals(userPassword)){
                resultMap.put("result","true");
            }else {
                resultMap.put("result","false");
            }
        }

        try {
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            //JSONArray 阿里巴巴的JSON工具类，转换格式
            /*
            * resultMap = ["result","sessionerror","result","error"]
            * Json格式 = {key:value}
            * */
            writer.write(JSONArray.toJSONString(resultMap));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
