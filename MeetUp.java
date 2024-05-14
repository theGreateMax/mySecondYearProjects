import java.util.Scanner;

/* Name: Lihle Mabuza
   Student Number: 4327587
   Practical 1: MeetUp.Java

 */

public class MeetUp {
    private static Student[] studentsArray;

    private static  void fillArray() {

        // ask the user for the number of students
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many student you want to input? ");
        int numberStudents = scanner.nextInt();

        studentsArray = new Student[numberStudents];

        System.out.println("Enter the information for each student" + "\n");

        int count = 0;
        // capture information for each student
        while (count != numberStudents) {

            // ask for student's information

            System.out.print("Student name: ");
            String studentName = scanner.next();

            System.out.print("Student number: ");
            int studentNumber = scanner.nextInt();

            System.out.print("Registration year: ");
            long regYear = scanner.nextLong();

            System.out.print("Faculty: ");
            String faculty = scanner.next();

            System.out.print("Department: ");
            String department = scanner.next();

            System.out.print("Gender: ");
            String gender = scanner.next();

            System.out.print("Race: ");
            String race = scanner.next();

            // create a new student object
            Student newStudent = new Student(studentName, studentNumber, regYear, faculty, department, gender, race);

            // and add it to the student array
            studentsArray[count++] = newStudent;

            // tell the user that taking information of a student is done
            System.out.println("Done! capturing information for student " + count + "\n");

        }
        // close the scanner object
        scanner.close();

    }

    //this method checks whether the students list consist of at least different races
    private static boolean checkRace() {

        int countBlacks = 0;
        int countColoureds = 0;
        int countAsians = 0;
        int countLatinos = 0;
        int countIndians = 0;
        int countWhites = 0;

        for (Student race : studentsArray) {
            if (race.getRace().equalsIgnoreCase("black")) {
                countBlacks = 1;
            } else if (race.getRace().equalsIgnoreCase("coloured")) {
                countColoureds = 1;
            } else if (race.getRace().equalsIgnoreCase("Asian")) {
                countAsians = 1;
            } else if (race.getRace().equalsIgnoreCase("Latino")) {
                countLatinos = 1;
            } else if (race.getRace().equalsIgnoreCase("Indian")) {
                countIndians = 1;
            } else if (race.getRace().equalsIgnoreCase("white")) {
                countWhites = 1;
            }
        }

        return countBlacks + countColoureds + countAsians + countLatinos + countIndians + countWhites >= 3;


    }

    public static void main(String[] args) {

        fillArray();

        // get the number of females
        int countFemale = 0;
        for (Student student : studentsArray) {
            String gender = student.getGender();

            if (gender.equalsIgnoreCase("female")) {
                countFemale++;
            }
        }

        if (studentsArray.length / 2 <= countFemale && checkRace()) {
            System.out.println("Great! We are making progress! Let's keep it up.");
        } else System.out.println("We need to work on diversifying more.");

    }
}