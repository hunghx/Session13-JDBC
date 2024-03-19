package ra.example.session13jdbc.service.impl;

import ra.example.session13jdbc.dao.IStudentDao;
import ra.example.session13jdbc.dao.impl.StudentDaoImpl;
import ra.example.session13jdbc.model.Student;
import ra.example.session13jdbc.service.IGenericService;
import ra.example.session13jdbc.service.IStudentService;

import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private static final IStudentDao studentDao  = new StudentDaoImpl();
    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @Override
    public Student getById(Integer id) {
        return studentDao.getById(id);
    }

    @Override
    public void add(Student student) {
        studentDao.add(student);
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    public void deleteById(Integer id) {
        studentDao.deleteById(id);
    }
}
