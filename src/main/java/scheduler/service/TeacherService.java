package main.java.scheduler.service;

import main.java.scheduler.model.Teacher;

import java.util.List;

public interface TeacherService {

    public void addTeacher(Teacher teacher);

    public void updateTeacher(Teacher teacher);

    public void removeTeacher(int id);

    public Teacher getTeacherById(int id);

    public List<Teacher> listStudents();
}

