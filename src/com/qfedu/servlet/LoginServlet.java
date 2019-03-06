package com.qfedu.servlet;

import com.qfedu.daoImp.SelectUserDaoImp;
import com.qfedu.util.DruidGetConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String authLogin = req.getParameter("authLogin");

        SelectUserDaoImp selectUserDaoImp = new SelectUserDaoImp();
        selectUserDaoImp.setConnection(DruidGetConnection.getConnection());
        boolean result = selectUserDaoImp.selectUserByUsernameAndPassword(username, password);
        HttpSession session = req.getSession();
        Cookie cookie = new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(1800);
        resp.addCookie(cookie);
        session.setAttribute("username",username);
        System.out.println(result+"登录");
        resp.getWriter().print(result);

    }
}
