package com.yaozhou.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by WXHang on HANG at 2021/6/16 16:55
 * Desc：
 */
public class CookieDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码
        resp.setHeader("content-type", "text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();

        Cookie[] cookies = req.getCookies();
        //cookie,服务器端从客户端获取
        if(cookies!= null){
            out.println("您上一次访问的时间是");
            for (Cookie c : cookies) {
                if (c.getName().equals("name")){
                    //解码中文
                    URLDecoder.decode(c.getValue(),"utf-8");
                    //获取cookie中的值
                  out.write(c.getValue());
                    System.out.println(c.getValue());
                }
            }
        }else {
            out.println("您是第一次登录系统");
        }
        //设置中文编码为utf-8
        Cookie cookie = new Cookie("name", URLEncoder.encode("尧舟","utf-8"));
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
