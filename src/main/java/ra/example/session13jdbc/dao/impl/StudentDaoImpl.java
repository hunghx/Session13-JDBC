package ra.example.session13jdbc.dao.impl;

import ra.example.session13jdbc.dao.IStudentDao;
import ra.example.session13jdbc.model.Student;
import ra.example.session13jdbc.util.ConnectJava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements IStudentDao {
    @Override
    public List<Student> getAll() {
        List<Student> studentList = new ArrayList<>();
        Connection conn = ConnectJava.openConnection();

        try {
            PreparedStatement prep = conn.prepareStatement("select * from student");
            ResultSet rs = prep.executeQuery();
            while (rs.next()){
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAge(rs.getInt("age"));
                s.setSex(rs.getBoolean("sex"));
                studentList.add(s);
            }
            return studentList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectJava.closeConnection(conn);
        }
    }

    @Override
    public Student getById(Integer id) {
        Connection conn = ConnectJava.openConnection();

        try {
            PreparedStatement prep = conn.prepareStatement("select * from student where id = ?");
            prep.setInt(1,id);
            ResultSet rs = prep.executeQuery();
           if (rs.next()){
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAge(rs.getInt("age"));
                s.setSex(rs.getBoolean("sex"));
               return s;
            }
           return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectJava.closeConnection(conn);
        }
    }

    @Override
    public void add(Student student) {
        Connection conn = ConnectJava.openConnection();

        try {
            PreparedStatement prep = conn.prepareStatement("insert into student(name, age, sex) value(?,?,?)");
            prep.setString(1,student.getName());
            prep.setInt(2,student.getAge());
            prep.setBoolean(3,student.getSex());
            prep.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectJava.closeConnection(conn);
        }
    }

    @Override
    public void update(Student student) {
        Connection conn = ConnectJava.openConnection();

        try {
            PreparedStatement prep = conn.prepareStatement("update student set name= ?, age=?, sex=" +
                    "? where id = ?");
            prep.setString(1,student.getName());
            prep.setInt(2,student.getAge());
            prep.setBoolean(3,student.getSex());
            prep.setInt(4,student.getId());
            prep.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectJava.closeConnection(conn);
        }
    }

    @Override
    public void deleteById(Integer id) {
        Connection conn = ConnectJava.openConnection();

        try {
            PreparedStatement prep = conn.prepareStatement("delete from student where id = ? ");
            prep.setInt(1,id);
            prep.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectJava.closeConnection(conn);
        }
    }
}
