package com.y0lo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HandleLadder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Double top = Double.valueOf(req.getParameter("top"));
        Double bottom = Double.valueOf(req.getParameter("bottom"));
        Double height = Double.valueOf(req.getParameter("height"));
        System.out.println(top);
    }
}
