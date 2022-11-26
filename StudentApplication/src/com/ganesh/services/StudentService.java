package com.ganesh.services;

import com.ganesh.dto.Student;

public interface StudentService {
    String addStudent(Student student);
    Student searchStudent(int studentId);
    String updateStudent(int studentId);
    String deleteStudent(int studentId);
}
