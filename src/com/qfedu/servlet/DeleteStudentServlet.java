package com.qfedu.servlet;

import com.qfedu.daoImp.SelectStudentDaoImp;
import com.qfedu.serviceImp.FindStudentImp;
import com.qfedu.util.DruidGetConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/deleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("sid");
        sid = sid.split("-")[1];
        SelectStudentDaoImp selectStudentDaoImp = new SelectStudentDaoImp();
        Connection connection = DruidGetConnection.getConnection();
        selectStudentDaoImp.setConnection(connection);
        FindStudentImp findStudentImp = new FindStudentImp();
        findStudentImp.setSelectStudentDaoImp(selectStudentDaoImp);

        findStudentImp.deleteStudentBySid(sid);


    }
}
