package studentver1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student extends Person{
    private float GPA;
    private String major;

    public Student(String id, String fullName, Date dateOfBirth) {
        super(id, fullName, dateOfBirth);
    }    
    public Student(String id, String fullName, Date dateOfBirth, float GPA, String major) {
        super(id, fullName, dateOfBirth);
        this.GPA = GPA;
        this.major = major;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float gpa) {
        this.GPA = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    

    @Override
    public void displayInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("ID: " + getID());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Date of Birth: " + sdf.format(getDateOfBirth()));
        System.out.println("GPA: " + GPA);
        System.out.println("Major: " + major);
    }
}
