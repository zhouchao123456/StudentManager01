package com.qfedu.servlet;

import com.qfedu.daoImp.SelectStudentDaoImp;
import com.qfedu.domain.Page;
import com.qfedu.serviceImp.FindStudentImp;
import com.qfedu.util.DruidGetConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
@WebServlet("/limitPageServlet")
public class LimitPageServlet extends HttpServlet {
    private  FindStudentImp findStudentImp = null;


    private void initData() {
        Connection connection = DruidGetConnection.getConnection();
        SelectStudentDaoImp selectStudentDao = new SelectStudentDaoImp();
        selectStudentDao.setConnection(connection);

         findStudentImp = new FindStudentImp();
        findStudentImp.setSelectStudentDaoImp(selectStudentDao);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        initData();

        //接收前端参数
        int startPage = Integer.parseInt(req.getParameter("startPage"));

        Page page = findStudentImp.buildData(startPage);

        //设置域对象
        req.getSession().setAttribute("page",page);

        //重定向
        resp.sendRedirect(getServletContext().getContextPath()+"/selectStudentByLimitPage.jsp");
    }
}
