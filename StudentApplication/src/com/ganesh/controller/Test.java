package com.ganesh.controller;
import com.ganesh.dto.Student;
import com.ganesh.factories.ConnectionFactory;
import com.ganesh.factories.StudentServiceFactory;
import com.ganesh.services.StudentService;
import java.util.Scanner;

public class Test {

    static
    {
        try {
            Class.forName("com.ganesh.factories.ConnectionFactory");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void displayChoices()
    {
        System.out.println("1. Add a student");
        System.out.println("2. Search a student");
        System.out.println("3. Update a student");
        System.out.println("4. Delete a student");
        System.out.println("5. Exit");
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentService studentService = StudentServiceFactory.getStudentService();
        Student student = null;
        int choice;
        int studentId;
        String status;

        try {
            while (true) {
                displayChoices();
                System.out.print("Choose the above Choice - ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter the student id - ");
                        studentId = scanner.nextInt();
                        student = studentService.searchStudent(studentId);
                        if(student != null)
                        {
                            System.out.println("----------------------- Status : Student already existed -----------------------");
                        }
                        else {
                            student = new Student();
                            student.setStudentId(studentId);

                            System.out.print("Enter the student name - ");
                            student.setStudentName(scanner.next());

                            System.out.print("Enter the student fee - ");
                            student.setStudentFee(scanner.nextFloat());

                            System.out.print("Enter the student email id - ");
                            student.setStudentEmail(scanner.next());

                            System.out.print("Enter the student address - ");
                            student.setStudentAddress(scanner.next());

                            status = studentService.addStudent(student);
                            if (status.equalsIgnoreCase("success")) {
                                System.out.println("---------------------- Status : Student Insertion Success --------------------------");
                            } else if (status.equalsIgnoreCase("failure")) {
                                System.out.println("---------------------- Status: Student Insertion Failure ---------------------------");
                            } else {
                                System.out.println("---------------------- Status: Student Insertion Error ------------------------------");
                            }
                        }
                        break;
                    case 2:
                        System.out.print("Enter the student id - ");
                        studentId = scanner.nextInt();

                        student = studentService.searchStudent(studentId);
                        if(student == null)
                        {
                            System.out.println("------------------- Status : Student Doesn't Existed------------------");
                        }
                        else
                        {
                            System.out.println();
                            System.out.println("============ STUDENT DETAILS =============");
                            System.out.println();
                            System.out.println("Student Id - " + student.getStudentId());
                            System.out.println("Student Name - " + student.getStudentName());
                            System.out.println("Student Fee - " + student.getStudentFee());
                            System.out.println("Student Email - " + student.getStudentEmail());
                            System.out.println("Student Address - " + student.getStudentAddress());
                            System.out.println();
                        }
                        break;
                    case 3:
                        System.out.print("Enter the student id - ");
                        studentId = scanner.nextInt();
                        student = studentService.searchStudent(studentId);
                        if(student == null)
                        {
                            System.out.println("--------------------- Status : Student Doesn't Existed ----------------------");
                        }
                        else
                        {
                            status = studentService.updateStudent(studentId);
                            if(status.equalsIgnoreCase("success"))
                            {
                                System.out.println("-------------------- Status : Student Updated Successfully ---------------------");
                            }
                            else
                            {
                                System.out.println("-------------------- Status : Student Updation Failure ---------------------");
                            }
                        }
                        break;
                    case 4:
                        System.out.print("Enter the student id - ");
                        studentId = scanner.nextInt();

                        student = studentService.searchStudent(studentId);

                        if(student == null)
                        {
                            System.out.println("--------------------- Status : Student Doesn't Existed ----------------------");
                        }
                        else
                        {
                            status = studentService.deleteStudent(studentId);
                            if(status.equalsIgnoreCase("success"))
                            {
                                System.out.println("------------------------ Status : Student Deleted Successfully -------------------------");
                            }
                            else
                            {
                                System.out.println("------------------------ Status: Student Deletion Failure ----------------------------");
                            }
                        }
                        break;
                    case 5:
                        System.out.println("------------ Thank you for using this application ------------");
                        ConnectionFactory.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("---------------- Invalid Option Chosen ---------------");
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
