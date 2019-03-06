package com.qfedu.daoImp;

import com.qfedu.dao.SelectStudentDao;
import com.qfedu.domain.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SelectStudentDaoImp implements SelectStudentDao {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean selectStudentByUsername(String username) {
        String sql = "select * from student where sname = ?";
        QueryRunner queryRunner = new QueryRunner();
        try {
            Student student = queryRunner.query(connection, sql, new BeanHandler<Student>(Student.class), username);
            if(student==null){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }



//分页查询
    @Override
    public int selectCountOfStudent() {
        String sql = "select count(*) from student";
        QueryRunner queryRunner = new QueryRunner();

        int result = 0;
        try {
            result = queryRunner.query(connection,sql,new ScalarHandler<Long>()).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteStudentBySid(String sid) {
        int result = -1;
        String sql = "delete from student where sid=?";
        QueryRunner queryRunner = new QueryRunner();
        try {
            result = queryRunner.update(connection, sql, sid);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int addStudent(Student student) {
        int result = -1;
        String sql = "insert into student(sname,ssex,sage,sid) values(?,?,?,?)";
        QueryRunner queryRunner = new QueryRunner();
        try {
            result = queryRunner.update(connection, sql, student.getSname(), student.getSsex(), student.getSage(), student.getSid());
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Student> selectStudentByLimit(int startPage) {
        String sql = "select * from student limit ?,3";
        QueryRunner queryRunner = new QueryRunner();

        int m = (startPage-1)*3;

        List<Student> students = null;
        try {
            students = queryRunner.query(connection,sql,new BeanListHandler<Student>(Student.class),m);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<Student> selectAllStudent() {
        String sql = "select * from student";
        QueryRunner queryRunner = new QueryRunner();
        List<Student> students = null;
        try {
            students = queryRunner.query( connection, sql,new BeanListHandler<Student>(Student.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
