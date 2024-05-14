

/* Name: Lihle Mabuza
   Student Number: 4327587
   Practical 1: MeetUp.Java

 */

public class Student {
    private String studentName;
    private int studentNumber;
    private long registrationYear;
    private String faculty;
    private String department;
    private String gender;
    private String race;

    // Default constructor
    public Student() {
    }

    // A constructor taking all the attributes of the student class
    public Student(String studentName, int studentNumber, long registrationYear, String faculty, String department, String gender, String race) {
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.registrationYear = registrationYear;
        this.faculty = faculty;
        this.department = department;
        this.gender = gender;
        this.race = race;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setRegistrationYear(long registrationYear) {
        this.registrationYear = registrationYear;
    }

    public long getRegistrationYear() {
        return registrationYear;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getRace() {
        return race;
    }

    public String toString() {
        return getStudentName() + " " + getStudentNumber() + " " + getDepartment();
    }


}
