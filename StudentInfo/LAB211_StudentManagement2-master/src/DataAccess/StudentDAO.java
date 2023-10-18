/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Common.Validation;
import Model.Student;
import java.util.ArrayList;

/**
 *
 * @author HI
 */
public class StudentDAO {

    private static StudentDAO instance = null;
    Validation validation = new Validation();

    public static StudentDAO Instance() {
        if (instance == null)
            synchronized (StudentDAO.class) {
            if (instance == null) {
                instance = new StudentDAO();
            }
        }
        return instance;        
    }
    
    public void addStudent(ArrayList<Student> studentList) {
        do {            
            System.out.println("Please input student information: ");
            String name = validation.inputString("Name: ", "^[a-zA-Z\s]*$");
            String classes = validation.inputString("Classes: ", "^[a-zA-Z0-9\s]*$");
            double mark = validation.inputDouble("Mark: ", 0);
            studentList.add(new Student(name, classes, mark));
            System.out.println("Do you want to add more student? ");
        } while (validation.checkInputYN());
    }
}
