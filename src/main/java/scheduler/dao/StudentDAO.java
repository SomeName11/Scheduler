package main.java.scheduler.dao;

import main.java.scheduler.model.Student;

import java.util.List;

public interface StudentDAO {

    public void addStudent(Student student);

    public void updateStudent(Student student);

    public void removeStudent(int id);

    public Student getStudentById(int id);

    public List<Student> listStudents();
}

