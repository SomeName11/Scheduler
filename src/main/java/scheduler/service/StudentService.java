package main.java.scheduler.service;

import main.java.scheduler.model.Student;

public interface StudentService {

    void save(Student student);

    Student findByLogin(String login);
}
