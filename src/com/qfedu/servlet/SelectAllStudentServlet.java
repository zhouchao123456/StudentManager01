package com.qfedu.servlet;

import com.google.gson.Gson;
import com.qfedu.daoImp.SelectStudentDaoImp;
import com.qfedu.domain.Student;
import com.qfedu.serviceImp.FindStudentImp;
import com.qfedu.util.DruidGetConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/selectAllStudentServlet")
public class SelectAllStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        SelectStudentDaoImp selectStudentDaoImp = new SelectStudentDaoImp();
        Connection connection = DruidGetConnection.getConnection();
        selectStudentDaoImp.setConnection(connection);
        FindStudentImp findStudentImp = new FindStudentImp();
        findStudentImp.setSelectStudentDaoImp(selectStudentDaoImp);

        List<Student> students = findStudentImp.getAllStudent();
        System.out.println(students);

        Gson gson = new Gson();

        String json = gson.toJson(students);

        resp.getWriter().print(json);


    }
}
