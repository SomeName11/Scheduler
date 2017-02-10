package main.java.scheduler.dao;

import main.java.scheduler.model.Teacher;

import java.util.List;

public interface TeacherDAO {

    public void addTeacher(Teacher teacher);

    public void updateTeacher(Teacher teacher);

    public void removeTecher(int id);

    public Teacher getTeacherById(int id);

    public List<Teacher> listTeachers();
}

