/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DataAccess.StudentDAO;
import Model.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author HI
 */
public class StudentRepository implements Comparator<Student>, IStudentRepository{
    ArrayList<Student> studentList;

    public StudentRepository() {
        this.studentList = new ArrayList<>();
    }
    
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }

    @Override
    public Comparator<Student> reversed() {
        return Comparator.super.reversed();
    }

    @Override
    public void addStudent() {
        StudentDAO.Instance().addStudent(studentList);
    }

    @Override
    public void SortAndDisplay() {
        Collections.sort(studentList, this);
        for (int i = 0; i < studentList.size(); i++) {
            Student get = studentList.get(i);
            System.out.println("------------ Student" + i + "------------");
            System.out.println("Name: " + get.getName());
            System.out.println("Classes: " + get.getClasses());
            System.out.println("Mark: " + get.getMark());
        }
    }
    
    
}
