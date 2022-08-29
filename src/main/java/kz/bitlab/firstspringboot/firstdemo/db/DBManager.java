package kz.bitlab.firstspringboot.firstdemo.db;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Student> students = new ArrayList<>();
    static {

        students.add(new Student(1l,"Raimbek","Nabiyev",80));
        students.add(new Student(2l,"Askar","Askarov",69));
        students.add(new Student(3l,"Nurbek","Aitkul",55));
        students.add(new Student(4l,"Tore","Knyaz",85));
        students.add(new Student(5l,"Asyl","Khan",95));
    }
    private static Long id = 6l;

    public static ArrayList<Student> getStudents(){
        return students;
    }
    public static void addStudent(Student student){
        student.setId(id);
        students.add(student);
        id++;
    }
    public static Student getStudent(Long id){
        for (Student st : students){
            if (st.getId()==id)
                return st;
        }
        return null;
    }
}
