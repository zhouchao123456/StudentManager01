package com.qfedu.servlet;

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

@WebServlet("/insertStudentServlet")
public class InsertStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charSet=utf-8");
        String sid = req.getParameter("sid");
        String sname = req.getParameter("sname");
        int sage = Integer.parseInt(req.getParameter("sage"));
        String ssex = req.getParameter("ssex");
        Student student = new Student();
        student.setSid(sid);
        student.setSname(sname);
        student.setSage(sage);
        student.setSsex(ssex);
        System.out.println(student);

        SelectStudentDaoImp selectStudentDaoImp = new SelectStudentDaoImp();
        Connection connection = DruidGetConnection.getConnection();
        selectStudentDaoImp.setConnection(connection);
        FindStudentImp findStudentImp = new FindStudentImp();
        findStudentImp.setSelectStudentDaoImp(selectStudentDaoImp);

        int result = findStudentImp.addStudent(student);
        resp.getWriter().print(result);


    }
}
