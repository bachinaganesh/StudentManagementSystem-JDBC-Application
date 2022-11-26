package com.ganesh.factories;

import com.ganesh.services.StudentService;
import com.ganesh.services.StudentServiceImpl;

public class StudentServiceFactory {
    public static StudentService studentService = null;

    static
    {
        studentService = new StudentServiceImpl();
    }

    public static StudentService getStudentService()
    {
        return studentService;
    }
}
