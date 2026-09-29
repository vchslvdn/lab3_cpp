package Tasks;

import model.StudentRecord;

public final class ArrayObjectTask
{
    private ArrayObjectTask() {}

    private static final int COUNT = 7;
    private static final int GRADE_BASE = 78;

    public static void run()
    {
        System.out.println("\nPart D: Array of objects");
        StudentRecord[] students = new StudentRecord[COUNT];

        for (int i = 0; i < students.length; i++)
        {
            String name = "Student_9_" + i;
            int grade = GRADE_BASE + (i % 5);
            students[i] = new StudentRecord(name, grade);
        }

        for (StudentRecord student : students)
        {
            System.out.println(student);
        }

        StudentRecord best = bestStudent(students);
        System.out.println("\nStudent with the maximum grade: " + best);
    }

    private static StudentRecord bestStudent(StudentRecord[] students)
    {
        StudentRecord best = students[0];
        for (int i = 1; i < students.length; i++)
        {
            if (students[i].getGrade() > best.getGrade())
            {
                best = students[i];
            }
        }
        return best;
    }
}