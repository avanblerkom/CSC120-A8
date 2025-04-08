import java.util.ArrayList;

public class Student {
    // Attributes
    private String name;
    private String id;
    private int classYear;
    private ArrayList<course> classes;

    /**
     * Constructor to initialize a Student object.
     * @param name The name of the student.
     * @param id The ID of the student.
     * @param classYear The class year of the student.
     */
    public Student(String name, String id, int classYear) {
        this.name = name;
        this.id = id;
        this.classYear = classYear;
        this.classes = new ArrayList<>();
    }

    /**
     * Gets the name of the student.
     * @return The name of the student.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns a string representation of the student.
     * @return A string containing the student's name, ID, and class year.
     */
    @Override
    public String toString() {
        return this.name + " ID: " + this.id + " Class Year: " + this.classYear;
    }

    /**
     * Inner class representing a course.
     */
    public class course {
        private String name;
        private String code;
        private String schedule;

        /**
         * Constructor to initialize a course object.
         * @param name The name of the course.
         * @param code The course code.
         * @param schedule The schedule of the course.
         */
        public course(String name, String code, String schedule) {
            this.name = name;
            this.code = code;
            this.schedule = schedule;
        }

        /**
         * Returns a string representation of the course.
         * @return A string containing the course name, code, and schedule.
         */
        @Override
        public String toString() {
            return this.name + " (" + this.code + ") - " + this.schedule;
        }
    }

    public static void main(String[] args) {
        // Create a Student object
        Student ab = new Student("Ab", "9909abc", 2014);
        System.out.println(ab);

        // Create a course and add it to the student's classes
        Student.course csc120 = ab.new course("OOP", "CSC120", "TR 10:50");
        ab.classes.add(csc120);

        // Print the student's classes
        System.out.println(ab.classes);
    }
}



