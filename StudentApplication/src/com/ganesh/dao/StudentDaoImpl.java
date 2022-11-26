package com.ganesh.dao;

import com.ganesh.dto.Student;
import com.ganesh.factories.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDaoImpl implements StudentDao{

    @Override
    public String add(Student student) {
        String status = "";
        try
        {
            Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();
            String query = "insert into student values(" + student.getStudentId() + ", '" + student.getStudentName() + "', "
                    + student.getStudentFee() + ", '" + student.getStudentEmail() + "', '" + student.getStudentAddress() + "')";
            int rowCount = statement.executeUpdate(query);
            if(rowCount == 1)
                status = "success";
            else
                status = "failure";
        }
        catch (Exception e)
        {
            status = "Error";
        }
        return status;
    }

    @Override
    public Student search(int studentId) {
        Student student = null;
        try {
            Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();
            String query = "select * from student where sno = " + studentId;
            ResultSet resultSet = statement.executeQuery(query);
            boolean flag = resultSet.next();
            if(flag)
            {
                student = new Student();
                student.setStudentId(resultSet.getInt("SNO"));
                student.setStudentName(resultSet.getString("SNAME"));
                student.setStudentFee(resultSet.getFloat("SFEE"));
                student.setStudentEmail(resultSet.getString("SEMAIL"));
                student.setStudentAddress(resultSet.getString("SADDRESS"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public String update(int studentId) {
        String status = "";
        try
        {
            Scanner scanner = new Scanner(System.in);

            Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();
            String sname;
            float sfee;
            String semail;
            String saddress;
            int option;
            String query = "";

            System.out.println("1. Update student name");
            System.out.println("2. Update student fee");
            System.out.println("3. Update student email");
            System.out.println("4. Update student address");
            System.out.println("5. Update all fields");
            System.out.println();

            System.out.print("Choose the above option above - ");
            option = scanner.nextInt();

            switch (option)
            {
                case 1:
                    System.out.print("Enter the new student name - ");
                    sname = scanner.next();
                    query = "update student set sname = '" + sname + "' where sno = " + studentId;
                    break;
                case 2:
                    System.out.print("Enter the new Student fee - ");
                    sfee = scanner.nextFloat();
                    query = "update student set sfee = " + sfee + " where sno = " + studentId;
                    break;
                case 3:
                    System.out.print("Enter the student email - ");
                    semail = scanner.next();
                    query = "update student set semail = '" + semail + "' where sno = " + studentId;
                    break;
                case 4:
                    System.out.print("Enter the student address - ");
                    saddress = scanner.next();
                    query = "update student set saddress = '" + saddress + "' where sno = " + studentId;
                    break;
                case 5:
                    System.out.print("Enter the new student name - ");
                    sname = scanner.next();
                    System.out.print("Enter the new Student fee - ");
                    sfee = scanner.nextFloat();
                    System.out.print("Enter the student email - ");
                    semail = scanner.next();
                    System.out.print("Enter the student address - ");
                    saddress = scanner.next();
                    query = "update student set sname = '" + sname + "', sfee = " + sfee + ", semail = '" + semail + "', saddress = '" + saddress + "'";
                    break;
            }
            int rowCount = statement.executeUpdate(query);
            if(rowCount == 1)
                status = "success";
            else
                status = "failure";
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public String delete(int studentId) {
        String status = "";
        try
        {
            Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();
            String query = "delete from student where sno = " + studentId;
            int rowCount = statement.executeUpdate(query);

            if(rowCount == 1)
            {
                status = "success";
            }
            else
            {
                status = "failure";
            }
        }
        catch (Exception e)
        {
            status = "failure";
            e.printStackTrace();
        }
        return status;
    }
}
