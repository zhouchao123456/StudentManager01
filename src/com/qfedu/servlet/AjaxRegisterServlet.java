package com.qfedu.servlet;

import com.qfedu.daoImp.SelectUserDaoImp;
import com.qfedu.serviceImp.FindUserImp;
import com.qfedu.util.DruidGetConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ajaxRegisterServlet")
public class AjaxRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username+"a   anihao  "+password+"a");
        FindUserImp findUserImp = new FindUserImp();
        SelectUserDaoImp selectUserDaoImp = new SelectUserDaoImp();
        DruidGetConnection druidGetConnection = new DruidGetConnection();
        selectUserDaoImp.setConnection(druidGetConnection.getConnection());

        findUserImp.setSelectUserDaoImp(selectUserDaoImp);

        boolean result = findUserImp.findUserByUsername(username);
        resp.getWriter().print(result);

        System.out.println(result);
        if (result){
            findUserImp.addUser(username,password);

        }else {

        }

    }
}
