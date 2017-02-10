package main.java.scheduler.dao;

import main.java.scheduler.model.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private static final Logger logger = LoggerFactory.getLogger(CourseDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addStudent(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(student);
        logger.info("Student successfully saved." + student.toString());
    }

    @Override
    public void updateStudent(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(student);
        logger.info("Student successfully update." + student.toString());
    }

    @Override
    public void removeStudent(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Student student = (Student) session.load(Student.class, new Integer(id));

        if(student!=null){
            session.delete(student);
        }
        logger.info("Student successfully removed." + student.toString());
    }

    @Override
    public Student getStudentById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Student student = (Student) session.load(Student.class, new Integer(id));
        logger.info("Student successfully loaded." + student.toString());

        return student;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Student> listStudents() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Student> studentList = session.createQuery("from Student").list();

        for(Student student : studentList){
            logger.info("Student list: " + student.toString());
        }

        return studentList;
    }
}

