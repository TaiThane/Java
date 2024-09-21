package studentver1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;


public class StudentList {
    private ArrayList<Student> students;
    
    public StudentList() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean updateStudentById(String id, Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getID().equals(id)) {
                // Cập nhật thông tin sinh viên
                students.set(i, updatedStudent);
                return true; // Trả về true nếu cập nhật thành công
            }
        }
        return false; // Trả về false nếu không tìm thấy sinh viên
    }

    public boolean deleteStudentById(String id) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getID().equals(id)) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public Student findStudentID(String id) {
        for (Student student : students) {
            if (student.getID().equals(id)) {
                return student; // Trả về sinh viên nếu tìm thấy
            }
        }
        return null; // Trả về null nếu không tìm thấy sinh viên
    }

    public void displayAllStudent() {
        for (Student student : students) {
            student.displayInfo();
            System.out.println();
        }
    }

    public Student findTopStudent() {
        Student topStudent = students.get(0);
        for (Student student : students) {
            if (student.getGPA() > topStudent.getGPA()) {
                return student;
            }
        }
        return topStudent;
    }
}

