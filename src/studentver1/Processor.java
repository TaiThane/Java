package studentver1;


    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.Scanner;

    public class Processor {
        public static void main(String[] args) {
            StudentList studentList = new StudentList();
           
            Scanner scanner = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            while (true) {
                System.out.println("1. Add a new student");
                System.out.println("2. Update a student by id");
                System.out.println("3. Delete a student by id");
                System.out.println("4. Display all students");
                System.out.println("5. Find the student with the highest GPA");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();
                scanner.nextLine();  

                switch (option) {
                    case 1:
                        System.out.print("Enter ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter Full Name: ");
                        String FullName = scanner.nextLine();
                        System.out.print("Enter Date of Birth (dd-MM-yyyy): ");
                        Date dateOfBirth = null;
                        try {
                            dateOfBirth = sdf.parse(scanner.nextLine());
                        } catch (ParseException e) {
                            System.out.println("Invalid date format.");
                            break;
                        }
                        System.out.print("Enter GPA: ");
                        float GPA = scanner.nextFloat();
                        scanner.nextLine();
                        System.out.print("Enter Major: ");
                        String major = scanner.nextLine();
                        Student student = new Student(id, FullName, dateOfBirth);
                        studentList.addStudent(student);
                        break;
                    case 2:
                        System.out.print("Enter ID of the student to update: ");
                        String updateId = scanner.nextLine();
                        System.out.print("Enter new Full Name: ");
                        String newFullName = scanner.nextLine();
                        System.out.print("Enter new Date of Birth (yyyy-MM-dd): ");
                        Date newDateOfBirth = null;
                        try {
                            newDateOfBirth = sdf.parse(scanner.nextLine());
                        } catch (ParseException e) {
                            System.out.println("Invalid date format.");
                            break;
                        }
                        System.out.print("Enter new GPA: ");
                        float newGpa = scanner.nextFloat();
                        scanner.nextLine();
                        System.out.print("Enter new Major: ");
                        String newMajor = scanner.nextLine();
                        Student updatedStudent = new Student(updateId, newFullName, newDateOfBirth, newGpa, newMajor);
                        studentList.updateStudentById(updateId, updatedStudent);
                        break;
                    case 3:
                        System.out.print("Enter ID of the student to delete: ");
                        String deleteId = scanner.nextLine();
                        studentList.deleteStudentById(deleteId);
                        break;
                    case 4:
                        studentList.displayAllStudent();
                        break;
                    case 5:
                        Student topStudent = studentList.findTopStudent();
                        if (topStudent != null) {

                            System.out.println("Student with the highest GPA:");
                            topStudent.displayInfo();
                        } else {
                            System.out.println("No students found.");
                        }
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }
