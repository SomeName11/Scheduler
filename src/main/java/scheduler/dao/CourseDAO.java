package main.java.scheduler.dao;

import main.java.scheduler.model.Course;

import java.util.List;

public interface CourseDAO {

    public void addCourse(Course course);

    public void updateCourse(Course course);

    public void removeCourse(int id);

    public Course getCourseById(int id);

    public List<Course> listCourses();
}
