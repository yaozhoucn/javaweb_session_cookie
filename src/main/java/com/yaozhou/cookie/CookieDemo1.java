package com.yaozhou.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by WXHang on HANG at 2021/6/16 11:54
 * @
 * Desc：
 */
public class CookieDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //没有IO做不了的事情
        //保护用户上次访问的时间
        //服务器，告诉你你来的时间，把这个时间封装成为-一个信件，你下次带来，我就知道你来了

        //解决中文乱码
        resp.setHeader("content-type", "text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();
        Cookie cookie = new Cookie("LastLogintime",System.currentTimeMillis()+"");
        Cookie[] cookies = req.getCookies();
        //cookie,服务器端从客户端获取
        if(cookies!= null){
            out.println("您上一次访问的时间是");
            for (Cookie c : cookies) {
               if (c.getName().equals("LastLogintime")){
                   //获取cookie中的值
                   String LastLogintime = c.getValue();

                   Long Ltime = Long.parseLong(LastLogintime);
                   Date date = new Date(Ltime);
                   out.println(date+"");
               }
            }
        }else {
            out.println("您是第一次登录系统");
        }
        //设置cookie的有效期为一天
        cookie.setMaxAge(24*60*12);
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);

    }

}
