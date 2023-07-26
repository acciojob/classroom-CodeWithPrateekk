package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String,Student> studentDb = new HashMap<>();
    HashMap<String,Teacher> teacherDb = new HashMap<>();
    HashMap<String,List<String>> studentTeacherPairDb = new HashMap<>();

    public String addStudent(Student student) {
        if(studentDb.containsKey(student.getName()))
            return "Student already exists";

        studentDb.put(student.getName(),student);
        return "New student added successfully";
    }

    public String addTeacher(Teacher teacher) {
        if(teacherDb.containsKey(teacher.getName()))
            return "Teacher already exists";

        teacherDb.put(teacher.getName(),teacher);
        return "New teacher added successfully";
    }


    public String addStudentTeacherPair(String student, String teacher) {
        if(!studentDb.containsKey(student))
            return "Student does not exists";

        if(!teacherDb.containsKey(teacher))
            return "Teacher does not exists";

        List<String> students = new ArrayList<>();
        if(studentTeacherPairDb.containsKey(teacher)){
            students = studentTeacherPairDb.get(teacher);
            if(!students.contains(student)){
                students.add(student);
                studentTeacherPairDb.put(teacher,students);
            }

        }
        else {
            students.add(student);
            studentTeacherPairDb.put(teacher, students);
        }
        return "New student-teacher pair added successfully";
    }

    public Student getStudentByName(String name) {
        if(!studentDb.containsKey(name))
            return null;


        return studentDb.get(name);
    }

    public Teacher getTeacherByName(String name) {
        if(!teacherDb.containsKey(name))
            return null;

        return teacherDb.get(name);
    }

    public List<String> getAllStudents() {

        List<String> students = new ArrayList<>();
        for(String s : studentDb.keySet())
            students.add(s);

        return students;
    }



    public String deleteTeacherByName(String teacher) {
        if(!teacherDb.containsKey(teacher))
            return null;

        teacherDb.remove(teacher);
        studentTeacherPairDb.remove(teacher);

        return teacher;
    }

    public String deleteAllTeachers() {
        if (teacherDb.size() == 0)
            return "No teacher is present in the database";
        else {
            teacherDb = new HashMap<>();

        }
        studentTeacherPairDb = new HashMap<>();

        return "All teachers deleted successfully";
    }

    public List<String> getStudentsByTeacherName(String teacher) {

        if(!studentTeacherPairDb.containsKey(teacher)){
            return new ArrayList<>();
        }

        return studentTeacherPairDb.get(teacher);
    }


}
