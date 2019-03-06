package com.qfedu.dao;

import com.qfedu.domain.Student;

import java.util.List;

public interface SelectStudentDao {
    public boolean selectStudentByUsername(String username);
    public int deleteStudentBySid(String sid);
    public int addStudent(Student student);
    //查询当前分页结果集
    public List<Student> selectStudentByLimit(int startPage);
    public List<Student> selectAllStudent();
}
