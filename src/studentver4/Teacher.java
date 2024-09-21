package studentver4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Teacher extends Person{
    private String department;
    private String teachingsubject;

    public Teacher() {
        super();
    }

    public Teacher(String department, String teachingsubject, String id, String fullName, Date dateOfBirth) {
        super(id, fullName, dateOfBirth);
        this.department = department;
        this.teachingsubject = teachingsubject;
    }
    
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTeachingsubject() {
        return teachingsubject;
    }

    public void setTeachingsubject(String teachingsubject) {
        this.teachingsubject = teachingsubject;
    }
    
    public void addPerson(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id: ");
        id = sc.nextLine();
        System.out.println("Enter full name: ");
        fullName = sc.nextLine();
        System.out.println("Enter date of birth: ");
        String dateOfBirthString = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dateOfBirth = sdf.parse(dateOfBirthString);
        } catch (Exception e) {
            System.out.println("wrong fomat!");
        }
        System.out.println("Enter depertment: ");
        department = sc.nextLine();
        System.out.println("Enter teachingsubject: ");
        teachingsubject = sc.nextLine();
    }
    
    public void updatePerson(String id){}
    
    public void displayInfo(){
        SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
        int i=0;
        System.out.println("Enter id: "+this.getId(i));
        System.out.println("Enter full name: "+this.getFullName());
        System.out.println("Enter date of birth: "+sdf.format(dateOfBirth));
        System.out.println("Enter depertment: "+this.getDepartment());
        System.out.println("Enter teachingsubject: "+this.getTeachingsubject());
    }
}
