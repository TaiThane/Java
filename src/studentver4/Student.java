package studentver4;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student extends Person{
    private float gpa;
    private String major;

    public Student() {
        super();
    }

    public Student(float gpa, String major, String id, String fullName, Date dateOfBirth) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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
        System.out.println("Enter gpa: ");
        gpa = Float.parseFloat(sc.nextLine());
        System.out.println("Enter major");
        major = sc.nextLine();
    }
    
    public void updatePerson(String id){}
    
    public void displayInfo(){
        SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
        int i = 0;
        System.out.println("Enter id: "+this.getId(i));
        System.out.println("Enter full name: "+this.getFullName());
        System.out.println("Enter date of birth: "+sdf.format(dateOfBirth));
        System.out.println("Enter gpa: "+this.gpa);
        System.out.println("Enter major: "+this.major);
    }
}

