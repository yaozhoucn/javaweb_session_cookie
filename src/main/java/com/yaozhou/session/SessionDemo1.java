package com.yaozhou.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by WXHang on HANG at 2021/6/11 10:29
 * @author HANG
 */
public class SessionDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    //解决乱码问题
        //得到session
        //给session中存东西，响应回去
        resp.setHeader("content-type", "text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //设置浏览器接受的类型
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        session.setAttribute("name","尧舟");
        String sessionId = session.getId();
        System.out.println(sessionId);


        if (session.isNew()) {
            resp.getWriter().write("session创建成功,sessionID为"+sessionId);
        }else {
            resp.getWriter().write("session已经在服务器中存在"+sessionId);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}