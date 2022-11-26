package com.ganesh.dao;

import com.ganesh.dto.Student;

public interface StudentDao {

    String add(Student student);
    Student search(int studentId);
    String update(int studentId);
    String delete(int studentId);
}

