package studentver4;

import java.util.Scanner;

public class Processor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PersonList personList = new PersonList();
        
        while (true) {
            System.out.println("1. Add a new student");
            System.out.println("2. Add a new teacher");
            System.out.println("3. Update person");
            System.out.println("4. Delete person by ID");
            System.out.println("5. Display all students and teachers");
            System.out.println("6. Find the student with the highest GPA");
            System.out.println("7. Find a teacher by department");
            System.out.println("0. exit");
            System.out.println("choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    Student st = new Student();
                    st.addPerson();
                    personList.addStudent(st);
                    break;
                    
                case 2:
                    Teacher teacher = new Teacher();
                    teacher.addPerson();
                    personList.addTeacher(teacher);
                    break;
                    
                case 3:
                    System.out.print("Enter ID of the person to update: ");
                    String updateperson = sc.nextLine();
                    personList.updatePerson(updateperson);
                    break;
                    
                case 4:
                    System.out.print("Enter person ID to delete: ");
                    String deleteId = sc.nextLine();
                    personList.deletePersonById(deleteId);
                    break;   
                    
                case 5: 
                    System.out.println("List of all students and teachers:");
                    personList.displayAll();
                    break;
                    
                case 6:
                    Student topStudent = personList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Student with the highest GPA:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students found.");
                    }
                    break;

                case 7:
                    System.out.print("Enter the department to search for a teacher: ");
                    String department = sc.nextLine();
                    Teacher foundTeacher = personList.findTeacherByDepartment(department);
                    if (foundTeacher != null) {
                        System.out.println("Teacher found in department " + department + ":");
                        foundTeacher.displayInfo();
                    } else {
                        System.out.println("No teacher found in department " + department);
                    }
                    break;
                    
                case 0:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                
                default:
                    System.out.println("Invalid choice, please try again.");    
            }
        }
    }
}    