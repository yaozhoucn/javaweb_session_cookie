package com.yaozhou.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by WXHang on HANG at 2021/6/16 16:51
 * Desc：
 */
public class CookieDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建一个cookie，设置失效的cookie名字必须相同
        Cookie lastLogintime = new Cookie("LastLogintime", System.currentTimeMillis() + "");
        //设置失效日期为0，马上失效
        lastLogintime.setMaxAge(0);

        resp.addCookie(lastLogintime);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
