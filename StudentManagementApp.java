import java.util.*;

public class StudentManagementApp {

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student(101, "Pratiksha", 85));
        studentList.add(new Student(102, "Rajashri", 72));
        studentList.add(new Student(103, "Sneha", 90));
        studentList.add(new Student(101, "Pratiksha", 85)); // duplicate

        Set<Student> uniqueStudents = new HashSet<>(studentList);

        System.out.println("===== Unique Students =====");
        for (Student s : uniqueStudents) {
            System.out.println(s);
        }

        Map<Integer, Student> studentMap = new HashMap<>();
        for (Student s : uniqueStudents) {
            studentMap.put(s.getId(), s);
        }

        System.out.println("\n===== Lookup Student by ID (102) =====");
        System.out.println(studentMap.get(102));

        List<Student> sortedList = new ArrayList<>(uniqueStudents);
        sortedList.sort(Comparator.comparingDouble(Student::getMarks).reversed());

        System.out.println("\n===== Students Sorted by Marks (Descending) =====");
        for (Student s : sortedList) {
            System.out.println(s);
        }

        System.out.println("\n===== Student Report =====");
        System.out.printf("%-5s %-10s %-6s%n", "ID", "Name", "Marks");
        System.out.println("-------------------------");
        for (Student s : sortedList) {
            System.out.printf("%-5d %-10s %-6.2f%n",
                    s.getId(), s.getName(), s.getMarks());
        }
    }
}
