package studentver4;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonList {
    private ArrayList<Person> personList;
    
    public PersonList(){
        personList = new ArrayList<>();
    }
    
    public void addStudent(Student student){
        personList.add(student);
    }
    
    public void addTeacher(Teacher teacher){
        personList.add(teacher);
    }
    
    public void updatePerson(String updateid){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student id to update");
        String id = sc.nextLine();
        for(int i=0;i<personList.size();i++){
            if(personList.get(i).getId(i).equals(id)){
                System.out.println("update information");
                Person updatePerson = personList.get(i);
               
                System.out.print("Enter full name: ");
                updatePerson.setFullName(sc.nextLine());

                System.out.print("Enter date of birth: ");
                String dobStr = sc.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    updatePerson.setDateOfBirth(sdf.parse(dobStr));
                } catch (Exception e) {
                    System.out.println("Wrong Format!");
                }
                personList.set(i, updatePerson);
            }
        }
    }
    
    public void deletePersonById(String id) {
        int i=0;
        personList.removeIf(person -> person.getId(i).equals(id));
    }
    
    public void displayAll(){
        System.out.println("List of all students and teachers:");
        for(Person person : personList){
            if(person instanceof Student){
                System.out.println("Enter student: ");
            }else if(person instanceof Teacher){
                System.out.println("Enter teacher: ");
            }
            person.displayInfo();
        } 
    }
    
    public Student findTopStudent() {
        Student topStudent = null;
        for (Person person : personList) {
            if (person instanceof Student) {
                Student student = (Student) person;
                if (topStudent == null || student.getGpa() > topStudent.getGpa()) {
                    topStudent = student;
                }
            }
        }
        return topStudent;
    }

    // Find a teacher by department
    public Teacher findTeacherByDepartment(String department) {
        for (Person person : personList) {
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getDepartment().equals(department)) {
                    return teacher;
                }
            }
        }
        return null;
    }
    
}
