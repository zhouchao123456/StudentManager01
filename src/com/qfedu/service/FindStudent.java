package com.qfedu.service;

import com.qfedu.domain.Page;
import com.qfedu.domain.Student;

import java.util.List;

public interface FindStudent {
    public boolean findStudentByUsername(String username);

    public int deleteStudentBySid(String sid);

    public Page buildData(int startPage);

    public int addStudent(Student student);

    public List<Student> getAllStudent();
}
