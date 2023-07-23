package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public String addStudent(Student student) {

        return studentRepository.addStudent(student);
    }

    public String addTeacher(Teacher teacher) {
        return studentRepository.addTeacher(teacher);
    }

    public String addStudentTeacherPair(String student, String teacher) {

        return studentRepository.addStudentTeacherPair(student,teacher);
    }

    public Student addStudentByName(String name) {
        return studentRepository.addStudentByName(name);
    }

    public Teacher getTeacherByName(String name) {
        return studentRepository.getTeacherByName(name);
    }

    public List<String> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public String deleteTeacherByName(String teacher) {
        return studentRepository.deleteTeacherByName(teacher);
    }

    public String deleteAllTeachers() {
        return studentRepository.deleteAllTeachers();
    }

    public List<String> getStudentsByTeacherName(String teacher) {

        return studentRepository.getStudentsByTeacherName(teacher);
    }
}
