package com.ganesh.factories;

import com.ganesh.dao.StudentDao;
import com.ganesh.dao.StudentDaoImpl;

public class StudentDaoFactory {

    private static StudentDao studentDao = null;
    static
    {
        studentDao = new StudentDaoImpl();
    }
    public static StudentDao getStudentDao()
    {
        return studentDao;
    }
}

