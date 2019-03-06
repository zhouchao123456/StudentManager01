package com.qfedu.serviceImp;

import com.qfedu.daoImp.SelectStudentDaoImp;
import com.qfedu.domain.Page;
import com.qfedu.domain.Student;
import com.qfedu.service.FindStudent;
import com.sun.org.apache.bcel.internal.generic.Select;

import java.util.List;

public class FindStudentImp implements FindStudent {
    private SelectStudentDaoImp selectStudentDaoImp;

    public SelectStudentDaoImp getSelectStudentDaoImp() {
        return selectStudentDaoImp;
    }

    public void setSelectStudentDaoImp(SelectStudentDaoImp selectStudentDaoImp) {
        this.selectStudentDaoImp = selectStudentDaoImp;
    }

    @Override
    public boolean findStudentByUsername(String username) {
        return selectStudentDaoImp.selectStudentByUsername(username);
    }

    @Override
    public int deleteStudentBySid(String sid) {
       return selectStudentDaoImp.deleteStudentBySid(sid);
    }


    //分页查询
    @Override
    public Page buildData(int startPage) {
        Page page = new Page();

        //设置page的属性
        page.setStudents(selectStudentDaoImp.selectStudentByLimit(startPage));
        page.setTotalCount(selectStudentDaoImp.selectCountOfStudent());
        page.setThisPage(startPage);
        return page;
    }

    @Override
    public int addStudent(Student student) {
        return selectStudentDaoImp.addStudent(student);
    }

    @Override
    public List<Student> getAllStudent() {
       return selectStudentDaoImp.selectAllStudent();
    }
}
