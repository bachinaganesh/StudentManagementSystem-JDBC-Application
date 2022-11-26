package com.ganesh.services;

import com.ganesh.dao.StudentDao;
import com.ganesh.dto.Student;
import com.ganesh.factories.StudentDaoFactory;

public class StudentServiceImpl implements StudentService{
    @Override
    public String addStudent(Student student) {
        StudentDao studentDao = StudentDaoFactory.getStudentDao();
        return studentDao.add(student);
    }

    @Override
    public Student searchStudent(int studentId) {
        StudentDao studentDao = StudentDaoFactory.getStudentDao();
        return studentDao.search(studentId);
    }

    @Override
    public String updateStudent(int studentId) {
        StudentDao studentDao = StudentDaoFactory.getStudentDao();
        return studentDao.update(studentId);
    }

    @Override
    public String deleteStudent(int studentId) {
        StudentDao studentDao = StudentDaoFactory.getStudentDao();
        return studentDao.delete(studentId);
    }
}
